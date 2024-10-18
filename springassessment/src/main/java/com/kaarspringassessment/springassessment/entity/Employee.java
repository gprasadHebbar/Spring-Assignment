package com.kaarspringassessment.springassessment.entity;


import org.springframework.stereotype.Component;

@Component
public class Employee implements EmployeeDetails{


    @Override
    public void getEmployeeDetails() {
        int id = 101;
        String name = "Skreddy";
        System.out.println("Emp id : " +id + " Emp name : " +name);
    }
}
