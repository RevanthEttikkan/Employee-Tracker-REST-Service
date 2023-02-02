package com.example.crudDemo.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import com.example.crudDemo.entity.Employee;

import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {
	
	@Autowired
	private EntityManager entityManager;
	

	@Override
	public List<Employee> getFull() {
		Session cs=entityManager.unwrap(Session.class);
		
		Query<Employee> get=cs.createQuery("from Employee",Employee.class);
		
		List<Employee> res=get.getResultList();
		
		return res;
	}
	
	public Employee getById(int id) {
		Session cs=entityManager.unwrap(Session.class);
		Employee e=cs.get(Employee.class, id);
		return e;
	}
	
	

	
	

	@Override
	public void save(Employee theemp) {
		Session cs=entityManager.unwrap(Session.class);
		
		cs.saveOrUpdate(theemp);
		
	}

	@Override
	public void delete(int id) {
		Session cs=entityManager.unwrap(Session.class);
		
		@SuppressWarnings("deprecation")
		Query thequery=cs.createQuery("delete from Employee where id =: employeeId");
		thequery.setParameter("employeeId",id);
		thequery.executeUpdate();
		
		
	}


}
