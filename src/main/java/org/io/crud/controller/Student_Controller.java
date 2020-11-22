package org.io.crud.controller;

import lombok.extern.slf4j.Slf4j;
import org.io.crud.model.Student;
import org.io.crud.service.Student_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Student_Controller {
    @Autowired
    Student_Service student_service;

    // get all student
    @GetMapping("/students")
    public List<Student> getStudentList(){
        return student_service.getStudentList();
    }
    // get student by id
    @GetMapping("/student/{id$}")
    public Student getStudent(@PathVariable int id$){
        return student_service.getStudentById(id$);
    }
    // post all student
    @PostMapping("/students")
    public List<Student> postStudentList(@RequestBody List<Student> studentList$){
        return student_service.postStudentList(studentList$);
    }
    // post one student
    @PostMapping("/student")
    public Student postStudent(@RequestBody Student student$){
        return student_service.postStudent(student$);
    }
    // delete student by id
    @DeleteMapping("/student/{id$}")
    public String deleteStudent(@PathVariable int id$){
        return student_service.deleteStudent(id$);
    }
    // delete student by obj
    @DeleteMapping("/student")
    public String deleteStudent(@RequestBody Student student$){
        return student_service.deleteStudent(student$);
    }
    // update student obj
    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student$){
        return student_service.updateStudent(student$);
    }
}
