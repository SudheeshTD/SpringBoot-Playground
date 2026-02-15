package com.sudheesh.springboot.thymeleafdemo.controller;

import com.sudheesh.springboot.thymeleafdemo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.SQLOutput;
import java.util.List;

@Controller
public class StudentController {


    @Value("${countries}")
    private List<String> countries;


    @Value("${languages}")
    private List<String> languages;

    @Value("${systems}")
    private List<String> systems;


    @GetMapping("/showStudentForm")
    public String showForm(Model theModel){

        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);
        theModel.addAttribute("countries", countries);
        theModel.addAttribute("languages", languages);
        theModel.addAttribute("systems", systems);

        return "student-form";
    }

    @PostMapping("/processStudentForm")
    public String processForm(@ModelAttribute("student") Student theStudent){

        System.out.println("theStudent: " + theStudent.getFirstName() + " " + theStudent.getLastName());

        System.out.println("Place: " + theStudent.getCountry());

        System.out.println("Fav Subj: "+ theStudent.getFavoriteLanguage());

        return "student-confirmation";

    }
}
