package com.kaar.springmvc_thymeleaf.controller;

import com.kaar.springmvc_thymeleaf.model.Student;
import com.kaar.springmvc_thymeleaf.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/")
public class StudentController {

    private StudentService studentService;

    @Autowired
    public StudentController(StudentService theStudentService){
        studentService = theStudentService;
    }

    // mapping for viewing all students
    @GetMapping("/students")
    public String viewStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }

    // mapping for adding a student
    @GetMapping("/add")
    public String showFormForAdd(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "student-form";
    }

    //post mapping for handling form data
    @PostMapping("/addstudent")
    public String addStudent(@Valid @ModelAttribute("student") Student student, BindingResult result){
        if(result.hasErrors()){
            return "student-form";
        }
        studentService.addStudent(student);
        return "redirect:/students";
    }

    // mapping for editing student
    @GetMapping("/edit")
    public String showFormForEdit(@RequestParam("id") int id, Model model){
        Optional<Student> student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit-student";
    }

    @PostMapping("/update")
    public String updateStudent(@Valid @ModelAttribute("student") Student student, BindingResult result){
        if(result.hasErrors()){
            return "edit-student";
        }
        studentService.updateStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/delete")
    public String deleteStudent(@RequestParam("id") int id){
        studentService.deleteStudent(id);
        return "redirect:/students";
    }

}
