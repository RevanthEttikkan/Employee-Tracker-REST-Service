package com.example.crudDemo.DAO;

import java.util.List;

import com.example.crudDemo.entity.Employee;

public interface EmployeeDAO {
	
	public List<Employee> getFull();
	public Employee getById(int id);
	public void save(Employee theemp);
	public void delete(int id);
	
	

}
