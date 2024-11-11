package com.kaarspringassessment.springassessment2;

import com.kaarspringassessment.springassessment2.dao.EmployeeDAO;
import com.kaarspringassessment.springassessment2.entity.Employee;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Springassessment2Application {

	public static void main(String[] args) {
		SpringApplication.run(Springassessment2Application.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(EmployeeDAO employeeDAO){
		return runner -> {
			//createEmployee(EmployeeDAO employeeDAO);
			readEmployee(EmployeeDAO employeeDAO);
			updateEmployee(EmployeeDAO employeeDAO);
			deleteEmployee(EmployeeDAO employeeDAO);

		};
	}

	private void createEmployee(EmployeeDAO employeeDAO){
		System.out.println("Create new employee ");
		Employee tempEmployee = new Employee("Siva Kumar", "Gabu", "skreddy@gmail.com");
		System.out.println("Saving the Employee...");
		employeeDAO.save(tempEmployee);
		System.out.println("Id of the created employee : " +tempEmployee.getId());
	}

	private void readEmployee(EmployeeDAO employeeDAO){
		List<Employee> employeeList = employeeDAO.read();
	}

	private void updateEmployee(EmployeeDAO employeeDAO){
		int id = 6;
		Employee employee = employeeDAO.findById(id);
		employee.setFirstName("Reddy");
		employeeDAO.update(employee);
	}

	private void deleteEmployee(EmployeeDAO employeeDAO){
		int id = 6;
		System.out.println("Delete the employee with id : " +id);
		employeeDAO.Delete(id);
	}



}
