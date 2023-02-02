package com.example.crudDemo.service;

import java.util.List;

import com.example.crudDemo.entity.Employee;

public interface EmployeeService {
	public List<Employee> getFull();
	public Employee getById(int id);
	public void save(Employee theemp);
	public void delete(int id);

}
