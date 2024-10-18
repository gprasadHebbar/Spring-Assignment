package com.kaarspringassessment.springassessment3.controller;

import com.kaarspringassessment.springassessment3.entity.Employee;
import com.kaarspringassessment.springassessment3.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll(){
        return employeeService.findAll();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> findById(@PathVariable int employeeId){
        return employeeService.findById(employeeId);
    }

    @PostMapping("/employees")
    public Employee save(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    @PutMapping("/employees")
    public Employee update(@RequestBody Employee theEmployee){
        return employeeService.save(theEmployee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteById(@PathVariable int employeeId){
        employeeService.deleteById(employeeId);
    }
}
