package org.jamescarr.examples;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	private EmployeeDAO employees;
	
	@RequestMapping("/")
	public String index() {
		return "/employee/index";
	}
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String create(Employee employee) {
		employees.save(employee);
		return "redirect:/employee/";
	}

	@RequestMapping("/list")
	public @ResponseBody List<Employee> list(){
		return employees.getAll();
	}
}
