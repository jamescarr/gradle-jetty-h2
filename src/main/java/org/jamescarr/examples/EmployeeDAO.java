package org.jamescarr.examples;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.ParameterizedBeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
	private JdbcTemplate template;
	
	@Autowired
	public void init(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}
	
	void save(Employee employee){
		template.update("INSERT INTO employees (first_name, last_name) VALUES (?, ?)",
				employee.getFirstName(), employee.getLastName());
	}
	
	public List<Employee> getAll(){
		return template.query("SELECT * FROM employees", ParameterizedBeanPropertyRowMapper.newInstance(Employee.class));
	}
}
