package com.kaarspringassessment.springassessment2.dao;

import com.kaarspringassessment.springassessment2.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{

    //define field for Entity manager
    private EntityManager entityManager;

    // inject using constructor injection
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public void save(Employee theEmployee) {
        entityManager.persist(theEmployee);
    }

    @Override
    public List<Employee> read() {
        TypedQuery<Employee> theQuery = entityManager.createQuery("FROM Employee", Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public Employee findById(Integer theId) {
        return entityManager.find(Employee.class, theId);
    }

    @Override
    @Transactional
    public void update(Employee theEmployee) {
        entityManager.merge(theEmployee);
    }

    @Override
    @Transactional
    public void Delete(Integer id) {
        // retrieve the employee
        Employee employee = entityManager.find(Employee.class, id);
        //Delete the student
        entityManager.remove(employee);
    }
}
