package com.myclass.admin.controller;

import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
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

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@RestController
@RequestMapping("api/admin/role")
@CrossOrigin("*")
public class AdminRoleController {
	
	@Autowired
	RoleRepository roleRepository ;
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@GetMapping("")
	public Object getAll() {
		// Tạo đối tượng session để truy vấn database
		Session session = sessionFactory.openSession(); // Nhân viên ngân hàng
			List<Role> roles = roleRepository.findAll();
			if(roles==null) {
				return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
			}
			return new ResponseEntity<List<Role>>(roles, HttpStatus.OK);
	}

	@PostMapping("")
	public Object add(@Valid @RequestBody Role role, BindingResult erros) {
		if (erros.hasErrors())
			return new ResponseEntity<Object>(erros.getAllErrors(), HttpStatus.BAD_REQUEST);
		// Tạo id cho role
		role.setId(UUID.randomUUID().toString());
		if (roleRepository.add(role)) {
			//Trả về đối tượng thêm vào
			return new ResponseEntity<Role>(role, HttpStatus.CREATED);
		}
		//Thêm thất bại
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping("/{id}")
	public Object edit(@PathVariable("id") String id , @RequestBody Role role) {
		// Tạo id cho role
		role.setId(id);
		if(roleRepository.saveorUpdate(role)) {
			return new ResponseEntity<Role>(role, HttpStatus.OK);
		}
		//Update thất bại
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);	
	}
	
	@DeleteMapping("/{id}")
	public Object remove(@PathVariable("id") String id) {
		if(roleRepository.removeById(id)) {
			return new ResponseEntity<Role>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
