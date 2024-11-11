package com.kaarspringassessment.springassessment.controller;

import com.kaarspringassessment.springassessment.entity.EmployeeDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class DemoController {


    private EmployeeDetails employeeDetails;

    public DemoController(EmployeeDetails employeeDetails){
        this.employeeDetails = employeeDetails;
    }

    @GetMapping("/employees")
    public void getEmployeeDetails(){
        employeeDetails.getEmployeeDetails();
    }

}
