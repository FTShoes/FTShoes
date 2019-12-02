package com.myclass.service.impl;

import java.util.List;
import java.util.UUID;

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
	private EmployeesRepository employeesRepository;

	public List<Employees> getAll() {
		return employeesRepository.findAll();
	}

	public boolean checkValidEmail(String email) {
		// Khac null => da ton tai email trong database => tra ve true
		if (employeesRepository.findByEmail(email) != null)
			return true;
		return false;
	}

	public boolean save(EmployeesDto employeesDto) {
		// Tạo id cho user
		employeesDto.setId(UUID.randomUUID().toString());
		 //Mã hóa mật khẩu
		String hashed = BCrypt.hashpw(employeesDto.getPassword(), BCrypt.gensalt());
		
		Employees employees = new Employees(
				employeesDto.getId(),
				employeesDto.getName(),
				employeesDto.getEmail(),
				employeesDto.getPhone(),
				hashed,
				employeesDto.getAddress(),
				employeesDto.getGender(),
				employeesDto.getRoleId()
				);
		return employeesRepository.saveorUpdate(employees);
	}

	public boolean update(String id, EmployeesEditDto employeesEditDto) {
		Employees employees =employeesRepository.findById(id);
		if(employees == null) return false;
		
		employees.setName(employeesEditDto.getName());
		employees.setEmail(employeesEditDto.getEmail());
		employees.setPhone(employeesEditDto.getPhone());
		employees.setAddress(employeesEditDto.getAddress());
		employees.setGender(employeesEditDto.getGender());
		employees.setPassword(employeesEditDto.getPassword());
		employees.setRoleId(employeesEditDto.getRoleId());
		
		return employeesRepository.saveorUpdate(employees);
	}

	public boolean delete(String id) {
		return employeesRepository.removeById(id);
	}

	public Employees findById(String id) {
		return employeesRepository.findById(id);
	}

	public Employees findByEmail(String email) {
		return employeesRepository.findByEmail(email);
	}

}
