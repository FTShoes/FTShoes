package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Employees;

public interface EmployeesRepository {
	List<Employees> findAll();
	Employees findById(String id);
	Employees findByEmail(String email);
	boolean saveorUpdate(Employees employees);
	boolean removeById(String id);
	
}
