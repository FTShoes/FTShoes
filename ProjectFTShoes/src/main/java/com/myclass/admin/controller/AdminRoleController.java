package com.myclass.admin.controller;

import java.util.List;
import java.util.UUID;

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

import com.myclass.dto.RoleDto;
import com.myclass.dto.RoleEditDto;
import com.myclass.entity.Role;
import com.myclass.service.RoleService;

@RestController
@RequestMapping("api/admin/role")
@CrossOrigin("*")
public class AdminRoleController {

	@Autowired
	private RoleService roleService;

	@GetMapping("")
	public Object getAll() {
		List<Role> role = roleService.getAll();
		if (role == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Role>>(role, HttpStatus.OK);
	}

	@PostMapping("")
	public Object add(@Valid @RequestBody RoleDto roleDto, BindingResult errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<Object>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		roleDto.setId(UUID.randomUUID().toString());
		if (roleService.save(roleDto)) {
			return new ResponseEntity<RoleDto>(roleDto, HttpStatus.CREATED);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public Object update(@PathVariable("id") String id, @RequestBody RoleEditDto roleEditDto, BindingResult errors) {
		if (errors.hasErrors())
			return new ResponseEntity<Object>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		roleEditDto.setId(id);
		if (roleService.update(id, roleEditDto)) {
			return new ResponseEntity<RoleEditDto>(roleEditDto, HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") String id) {
		if (roleService.delete(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	

	@GetMapping("/{id}")
	public Object findById(@PathVariable("id") String id) {
		Role role = roleService.findById(id);
		if (role != null) {
			return new ResponseEntity<Role>(role, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Khong Tim Thay Producer Trong DataBase", HttpStatus.NO_CONTENT);
	}
}