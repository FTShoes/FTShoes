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

import com.myclass.dto.ProducerDto;
import com.myclass.dto.ProducerEditDto;
import com.myclass.dto.ProductDto;
import com.myclass.dto.ProductEditDto;
import com.myclass.entity.Product;
import com.myclass.service.ProductService;

@RestController
@RequestMapping("api/admin/product")
@CrossOrigin("*")
public class AdminProductController {

	@Autowired
	private SessionFactory sessionFactory;

	@Autowired
	private ProductService productService;

	@GetMapping("")
	public Object getAll() {
		Session session = sessionFactory.openSession();
		List<Product> product = productService.getAll();
		if (product == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
	}

	@PostMapping("")
	public Object add(@Valid @RequestBody ProductDto productDto, BindingResult errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<Object>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		productDto.setId(UUID.randomUUID().toString());
		if (productService.save(productDto)) {
			return new ResponseEntity<ProductDto>(productDto, HttpStatus.CREATED);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public Object update(@PathVariable("id") String id, @RequestBody ProductEditDto productEditDto) {
		productEditDto.setId(id);
		// Gọi hàm cập nhật của repository
		if (productService.update(id, productEditDto)) {
			return new ResponseEntity<ProductEditDto>(productEditDto, HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") String id) {
		if (productService.delete(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@GetMapping("{/{id}}")
	public Object findById(@PathVariable("id") String id) {
		Product product = productService.findById(id);
		if (product != null) {
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
	}
}
