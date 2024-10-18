package com.kaarspringassessment.springassessment.entity;

import org.springframework.stereotype.Component;

@Component
public class EmployeeService implements EmployeeDetails {
    @Override
    public void getEmployeeDetails() {
        int id = 102;
        String name = "Suresh";
        System.out.println("Emp id : " +id + " Emp name : " +name);
    }
}
