package com.myclass.admin.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
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
import com.myclass.entity.Product;
import com.myclass.service.EmployeesService;

@RestController
@RequestMapping("api/admin/employees")
public class AdminEmployeesController {

	@Autowired
	private EmployeesService employeesService;

	@GetMapping("")
	public Object getAll() {
		List<Employees> employees = employeesService.getAll();
		if (employees == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Employees>>(employees, HttpStatus.OK);
	}

	@PostMapping("")
	public Object add(@Valid @RequestBody EmployeesDto employeesDto, BindingResult errors) {
		// Kiểm tra lỗi nhập liệu
		if (errors.hasErrors())
			return new ResponseEntity<Object>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);

		// Kiểm tra xem email tồn tại chưa (khác null là đã có trong db rồi)
		if (employeesService.checkValidEmail(employeesDto.getEmail())) {
			return new ResponseEntity<String>("Email DA ton tai trong database, vui long kiem tra lai",
					HttpStatus.BAD_REQUEST);
		} else {
			// Thực hiện hàm saveOrUpdate thành công (Không có lỗi)
			if (employeesService.save(employeesDto)) {
				return new ResponseEntity<EmployeesDto>(employeesDto, HttpStatus.CREATED);
			}
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public Object update(@PathVariable("id") String id, @Valid @RequestBody EmployeesEditDto employeesEditDto,
			BindingResult errors) {
		employeesEditDto.setId(id);
		// Kiểm tra lỗi nhập liệu
		if (errors.hasErrors()) {
			return new ResponseEntity<Object>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}

		if (employeesService.checkValidEmail(employeesEditDto.getEmail())) {

			return new ResponseEntity<String>("Email KHONG ton tai trong database, vui long kiem tra lai" , HttpStatus.BAD_REQUEST);
		}

		if (employeesService.update(id, employeesEditDto)) {
			return new ResponseEntity<EmployeesEditDto>(employeesEditDto, HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") String id) {
		if (employeesService.delete(id)) {
			return new ResponseEntity<String>(" Da Xoa Employees ", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Xoa That Bai", HttpStatus.BAD_REQUEST);
	}
	
	
	@PostMapping("/{id}")
	public Object FindByID(String id) {
		if (employeesService.findById(id) != null) {
			Employees employees = employeesService.findById(id);
			return new ResponseEntity<Employees>(employees, HttpStatus.OK);
		}
		return new ResponseEntity<Employees>(HttpStatus.BAD_REQUEST);
	}
	
	@PostMapping("/{email}")
	public Object FindByEmail(String email) {
		if (employeesService.findByEmail(email) != null) {
			Employees employees = employeesService.findByEmail(email);
			return new ResponseEntity<Employees>(employees, HttpStatus.OK);
		}
		return new ResponseEntity<Employees>(HttpStatus.BAD_REQUEST);
	}
}
