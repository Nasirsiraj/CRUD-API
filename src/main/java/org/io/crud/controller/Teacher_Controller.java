package org.io.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.io.crud.model.Teacher;
import org.io.crud.service.Teacher_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Teacher_Controller {
    @Autowired
    Teacher_Service teacher_service;

    // get all teacher
    @GetMapping("/teachers")
    public List<Teacher> getTeacherList(){
        return teacher_service.getTeacherList();
    }
    // get teacher by id
    @GetMapping("/teacher/{id$}")
    public Teacher getTeacher(@PathVariable int id$){
        return teacher_service.getTeacher(id$);
    }
    // post all teacher
    @PostMapping("/teachers")
    public List<Teacher> postTeacherList(@RequestBody List<Teacher> teacherList$){
        return teacher_service.postTeacherList(teacherList$);
    }
    // post one teacher
    @PostMapping("/teacher")
    public Teacher postTeacher(@RequestBody Teacher teacher$){
        return teacher_service.postTeacher(teacher$);
    }
    // delete teacher by id
    @DeleteMapping("/teacher/{id$}")
    public String deleteTeacher(@PathVariable int id$){
        return teacher_service.deleteTeacher(id$);
    }
    // delete teacher by obj
    @DeleteMapping("/teacher")
    public String deleteTeacher(@RequestBody Teacher teacher$){
        return teacher_service.deleteTeacher(teacher$);
    }
    // update teacher by obj
    @PutMapping("/teacher")
    public Teacher updateTeacher(@RequestBody Teacher teacher$){
        return teacher_service.updateTeacher(teacher$);
    }
}
