package com.example.crudDemo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.crudDemo.DAO.EmployeeDAO;
import com.example.crudDemo.entity.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDAO employeeDao;

	@Override
	@Transactional
	public List<Employee> getFull() {
		// TODO Auto-generated method stub
		return employeeDao.getFull();
	}

	@Override
	@Transactional
	public Employee getById(int id) {
		// TODO Auto-generated method stub
		return employeeDao.getById(id);
	}

	@Override
	@Transactional
	public void save(Employee theemp) {
		employeeDao.save(theemp);

	}

	@Override
	@Transactional
	public void delete(int id) {
		employeeDao.delete(id);

	}

}
