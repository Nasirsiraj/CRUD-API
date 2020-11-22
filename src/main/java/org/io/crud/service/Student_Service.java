package org.io.crud.service;

import org.io.crud.model.Student;
import org.io.crud.repository.Student_Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
public class Student_Service {
    @Autowired
    Student_Repository student_repository;

    // get all student
    public List<Student> getStudentList(){
        return student_repository.findAll();
    }
    // get student by id
    public Student getStudentById(@Validated int id$){
        return student_repository.findById(id$).orElse(null);
    }
    // post all book
    public List<Student> postStudentList(@Validated List<Student> studentList$){
        return student_repository.saveAll(studentList$);
    }
    // post one book
    public Student postStudent(@Validated Student student$){
        return student_repository.save(student$);
    }
    // delete book by id
    public String deleteStudent(@Validated int id$){
        Student student$$ = student_repository.findById(id$).orElse(null);
        if(student$$ != null){
            student_repository.deleteById(id$);
            return "student deleted, id: "+id$+".";
        }else {
            return "student not found!";
        }
    }
    // delete book by obj
    public String deleteStudent(@Validated Student student$){
        Student student$$ = student_repository.findById(student$.getId()).orElse(null);
        if(student$$ != null){
            student_repository.delete(student$);
            return "student deleted, id: "+student$.getId()+".";
        }else {
            return "student not found!";
        }
    }
    // update book obj
    public Student updateStudent(@Validated Student student$){
        Student student$$ = student_repository.findById(student$.getId()).orElse(null);
        if(student$$ != null){
            student$$.setName(student$.getName());
            student$$.setRoll(student$.getRoll());
            student$$.setReg(student$.getReg());
            student$$.setEmail(student$.getEmail());
            student$$.setDepartment(student$.getDepartment());
            student$$.setSemester(student$.getSemester());

            return student_repository.save(student$$);
        }else{
            return null;
        }
    }
}
