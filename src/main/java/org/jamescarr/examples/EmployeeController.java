package org.jamescarr.examples;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EmployeeController {
	@Autowired
	EmployeeDAO employees;
	
	@PostConstruct
	public void startup(){
		Employee employee = new Employee();
		employee.setFirstName("James");
		employee.setLastName("Carr");
		employees.save(employee);
	}
}
