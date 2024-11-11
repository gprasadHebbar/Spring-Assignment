package com.kaarspringassessment.springassessment3.datarepository;

import com.kaarspringassessment.springassessment3.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
