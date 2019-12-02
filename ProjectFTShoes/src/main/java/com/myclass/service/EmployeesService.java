package com.myclass.service;

import java.util.List;

import com.myclass.dto.EmployeesDto;
import com.myclass.dto.EmployeesEditDto;
import com.myclass.entity.Employees;

public interface EmployeesService {

	List<Employees> getAll();

	boolean checkValidEmail(String email);

	boolean save(EmployeesDto employeesDto);

	boolean update(String id, EmployeesEditDto employeesEditDto);

	boolean delete(String id);

	Employees findById(String id);

	Employees findByEmail(String email);
}
