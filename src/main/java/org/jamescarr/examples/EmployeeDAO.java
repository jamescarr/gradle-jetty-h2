package org.jamescarr.examples;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmployeeDAO {
	private final JdbcTemplate template;
	
	@Autowired
	public EmployeeDAO(DataSource dataSource){
		template = new JdbcTemplate(dataSource);
	}
	
	public void save(Employee employee){
		String sql = "INSERT INTO employees (first_name, last_name) VALUES (?, ?)";
		template.update(sql, employee.getFirstName(), employee.getLastName());
	}
	
	public List<Employee> getAll(){
		return template.query("SELECT * FROM employees", BeanPropertyRowMapper.newInstance(Employee.class));
	}
}
