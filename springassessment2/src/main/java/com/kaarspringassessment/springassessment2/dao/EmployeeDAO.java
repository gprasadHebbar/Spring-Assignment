package com.kaarspringassessment.springassessment2.dao;

import com.kaarspringassessment.springassessment2.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public void save(Employee theEmployee);

    public List<Employee> read();

    public Employee findById(Integer theId);

    public void update(Employee theEmployee);

    public void Delete(Integer id);
}
