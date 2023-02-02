package com.example.crudDemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crudDemo.DAO.EmployeeDAO;
import com.example.crudDemo.entity.Employee;
import com.example.crudDemo.service.EmployeeService;
import com.example.crudDemo.service.EmployeeServiceImpl;

@RestController
@RequestMapping("/api")
public class RestServiceController {

	@Autowired
	private EmployeeService empService;
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployee(){
		return empService.getFull();
	}
	
	@GetMapping("/employees/{empId}")
	public Employee getEmployeeById(@PathVariable int empId ) throws Exception {
		Employee emp=empService.getById(empId);
		if(emp==null) {
			throw new Exception("Id not found");
		}
		return emp;
	}
	
	@PostMapping("/employees")
	public void add(@RequestBody Employee theemp) {
		theemp.setId(0);
		empService.save(theemp);
	}
	
	@PutMapping("/employees")
	public Employee update(@RequestBody Employee theemp) {
	
		empService.save(theemp);
		return theemp;
	}
	
	@DeleteMapping("/employees/{cusId}")
	public String Delete(@PathVariable int cusId) throws Exception {
		Employee emp=empService.getById(cusId);
		if(emp==null) {
			throw new Exception("Id not found");
		}
		empService.delete(cusId);
		
		return "Employee with Id deleted "+cusId;
	}
	
}
