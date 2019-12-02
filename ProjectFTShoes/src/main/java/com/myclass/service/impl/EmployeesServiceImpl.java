package com.myclass.service.impl;

import java.util.List;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.EmployeesDto;
import com.myclass.dto.EmployeesEditDto;
import com.myclass.entity.Employees;
import com.myclass.repository.EmployeesRepository;
import com.myclass.service.EmployeesService;
@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	EmployeesRepository employeesRepository;

	public List<Employees> getAll() {
		// TODO Auto-generated method stub
		return employeesRepository.findAll();
	}

	public boolean checkValidEmail(String email) {
		// Khác null => Đã tồn tại chưa(Khác null là đã có trong database rồi)
				if(employeesRepository.findByEmail(email)!= null) {
					return true;
				}
				return false;
	}

	public boolean save(EmployeesDto employeesDto) {
		String hashed = BCrypt.hashpw(employeesDto.getPassword(), BCrypt.gensalt());
		Employees employees = new Employees(
			employeesDto.getId(),
			employeesDto.getName(), 
			employeesDto.getEmail(), 
			employeesDto.getPhone(), 
			employeesDto.getAddress(), 
			employeesDto.getGender(), 
			employeesDto.getRoleId(), 
			hashed
			);
		return employeesRepository.saveorUpdate(employees);
	}

	public boolean update(String id, EmployeesEditDto employeesEditDto) {
		Employees employees = employeesRepository.findById(id);
		if(id==null) {
			return false;
		}
		employees.setName(employeesEditDto.getName());
		employees.setEmail(employeesEditDto.getEmail());
		employees.setPhone(employeesEditDto.getPhone());
		employees.setAddress(employeesEditDto.getAddress());
		employees.setGender(employeesEditDto.getGender());
		employees.setRoleId(employeesEditDto.getRoleId());
		return employeesRepository.saveorUpdate(employees);
	}

}
