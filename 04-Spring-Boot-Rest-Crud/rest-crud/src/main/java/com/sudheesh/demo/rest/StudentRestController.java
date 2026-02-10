package com.sudheesh.demo.rest;

import com.sudheesh.demo.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {

    private List<Student> theStudents;

    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();

        theStudents.add(new Student("Sike", "Satisha"));
        theStudents.add(new Student("Marad", "Madesha"));
        theStudents.add(new Student("Badgyi", "Basavaraju"));
        theStudents.add(new Student("Romeo", "Ranganna"));

    }


    //Defne Endpoints for /students
    @GetMapping("/students")
    public List<Student> getStudents(){
        return theStudents;
    }

    //Endpoint to return single student by defining ID

    @GetMapping("/students/{studentId}")
    public Student getStudent(@PathVariable int studentId){

        if ( (studentId >= theStudents.size()) || (studentId < 0)){
            throw new StudentNotFoundException("Student Id Not found - "+ studentId);
        }

        return theStudents.get(studentId);
    }

}
