package com.kaar.springmvc_thymeleaf.service;

import com.kaar.springmvc_thymeleaf.model.Student;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

@Service
public class StudentService {

    private List<Student> studentList = new ArrayList<>();
    Student student = new Student();

    private int id1 = student.getId();

    public List<Student> getAllStudents(){
        return studentList;
    }

    public void addStudent(Student student){
        student.setId(id1+1);
        studentList.add(student);
        id1++;
    }

    public Optional<Student> getStudentById(int id){
        return studentList.stream().filter(s -> s.getId() == id).findFirst();
    }

    public void updateStudent(Student student){
        getStudentById(student.getId()).ifPresent(student1 -> {
            student1.setName(student.getName());
            student1.setEmail(student.getEmail());
            student1.setCourse(student.getCourse());
        });
    }

    public void deleteStudent(int id){
        studentList.removeIf(student -> student.getId() == id);
    }
}
