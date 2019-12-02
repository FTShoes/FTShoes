package com.myclass.admin.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.EmployeesDto;
import com.myclass.dto.EmployeesEditDto;
import com.myclass.entity.Employees;
import com.myclass.repository.EmployeesRepository;
import com.myclass.service.EmployeesService;

@RestController
@RequestMapping("api/admin/employees")
public class AdminEmployeesController {
	
	@Autowired // Tiêm EmployeesReponsitory vào để xài
	private EmployeesRepository employeesRepository;
	
	@Autowired
	private EmployeesService employeesService;
	@CrossOrigin("*")
	
	@GetMapping("")
	//Lấy hết nhân viên trong danh sách ra
	public Object getAll() {
		// Gọi hàm findAll của EmployeesReponsitory để lấy danh sách employees từ Database
		List<Employees> employees = employeesService.getAll();
		// Nếu trả vể null (có lỗi xảy ra ở tầng Reponsitory)
		if (employees == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		// Nếu hàm findAll trả về khac null (không có lỗi) thì trả về danh sách user
		return new ResponseEntity<List<Employees>>(employees, HttpStatus.OK);
	}
	
	//Tìm kiếm theo ID
	@GetMapping("{/{id}}")
	public Object getID(@PathVariable("id") String id) {
		Employees employees= employeesRepository.findById(id);
		return new ResponseEntity<Employees>(employees, HttpStatus.OK);
	}
	
	//Tìm kiếm theo Email
	@GetMapping("/{email}")
	public Object getEmail(String email) {
		Employees employees= employeesRepository.findByEmail(email);
		return new ResponseEntity<Employees>(employees, HttpStatus.OK);
	}
	
	//Thêm nhân viện mới
	@PostMapping("")
	public Object add(@Valid @RequestBody EmployeesDto employeesDto, BindingResult errors) {
		// 
		if(errors.hasErrors()) {
			return new ResponseEntity<Object>(errors.getAllErrors(),HttpStatus.BAD_REQUEST);
		}
		// Kiểm tra xem email tồn tại chưa
		
		if (employeesService.checkValidEmail(employeesDto.getEmail())) {
			return new ResponseEntity<String>("Email đã tồn tại!", HttpStatus.BAD_REQUEST);
		}
		// Thực hiện hàm saveorUpdate thành công(ko có lỗi)
		if (employeesService.save(employeesDto)) {
			// Thêm thành công
			return new ResponseEntity<EmployeesDto>(employeesDto, HttpStatus.CREATED);
		}
		// Thêm thất bại
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	
	//Cập nhật nhân viên
	@PutMapping("/{id}")
	public Object update(@PathVariable("id") String id ,@Valid @RequestBody EmployeesEditDto employeesEditDto, BindingResult errors) {
		if(errors.hasErrors()) {
			return new ResponseEntity<Object>(errors.getAllErrors(),HttpStatus.BAD_REQUEST);
		}
		if(employeesService.update(id, employeesEditDto)) {
			return new ResponseEntity<EmployeesEditDto>(employeesEditDto, HttpStatus.CREATED);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);		
	}

	//Xóa nhân viên
	@DeleteMapping("{/{id}}")
	public Object delete(@PathVariable("id") String id) {
		if (employeesRepository.removeById(id)) {
			return new ResponseEntity<Employees>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
	
}
