package org.io.crud.service;

import org.io.crud.model.Teacher;
import org.io.crud.repository.Teacher_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
public class Teacher_Service {
    @Autowired
    Teacher_Repository teacher_repository;

    // get all teacher
    public List<Teacher> getTeacherList(){
        return teacher_repository.findAll();
    }
    // get teacher by id
    public Teacher getTeacher(@Validated int id$){
        return teacher_repository.findById(id$).orElse(null);
    }
    // post all teacher
    public List<Teacher> postTeacherList(@Validated List<Teacher> teacherList$){
        return teacher_repository.saveAll(teacherList$);
    }
    // post one teacher
    public Teacher postTeacher(@Validated Teacher teacher$){
        return teacher_repository.save(teacher$);
    }
    // delete teacher by id
    public String deleteTeacher(@Validated int id$){
        Teacher teacher$$ = teacher_repository.findById(id$).orElse(null);
        if (teacher$$ != null){
            teacher_repository.deleteById(id$);
            return "teacher deleted, id: "+id$+".";
        }else {
            return "teacher not found!";
        }
    }
    // delete teacher by obj
    public String deleteTeacher(@Validated Teacher teacher$){
        Teacher teacher$$ = teacher_repository.findById(teacher$.getId()).orElse(null);
        if (teacher$$ != null){
            teacher_repository.delete(teacher$);
            return "teacher deleted, id: "+teacher$.getId()+".";
        }else {
            return "teacher not found!";
        }
    }
    // update teacher obj
    public Teacher updateTeacher(@Validated Teacher teacher$){
        Teacher teacher$$ = teacher_repository.findById(teacher$.getId()).orElse(null);
        if(teacher$$ != null){
            teacher$$.setName(teacher$.getName());
            teacher$$.setSubject(teacher$.getSubject());
            teacher$$.setDepartment(teacher$.getDepartment());
            teacher$$.setShift(teacher$.getShift());
            teacher$$.setEmail(teacher$.getEmail());

            return teacher_repository.save(teacher$$);
        }else{
            return null;
        }
    }
}
