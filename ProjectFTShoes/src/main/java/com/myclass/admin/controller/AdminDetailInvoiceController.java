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

import com.myclass.dto.DetailInvoiceDto;
import com.myclass.dto.EmployeesEditDto;
import com.myclass.entity.DetailInvoices;
import com.myclass.entity.Employees;
import com.myclass.repository.DetailInvoicesRepository;
import com.myclass.service.DetailInvoicesService;

@RestController
@RequestMapping("api/admin/detailinvoices")

public class AdminDetailInvoiceController {
	
	
	@Autowired
	private DetailInvoicesService detailInvoicesService;
	@CrossOrigin("*")
	@GetMapping("")
	public Object getAll() {
		List<DetailInvoices> detail = detailInvoicesService.getAll();
		if (detail == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<DetailInvoices>>(detail, HttpStatus.OK);
	}
	
	@GetMapping("/{sale_id}")
	public Object findBySaleId(String sale_id) {
		List<DetailInvoices> detail = detailInvoicesService.findBySaleId(sale_id);
		if (detail == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<DetailInvoices>>(detail, HttpStatus.OK);
	}

	@PutMapping("/{sale_id}")
	public Object update(@PathVariable("sale_id") String sale_id, @Valid @RequestBody DetailInvoiceDto detailInvoiceDto,
			BindingResult errors) {
		detailInvoiceDto.setSale_id(sale_id);
		if (errors.hasErrors()) {
			return new ResponseEntity<Object>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		if (detailInvoicesService.Update(sale_id, detailInvoiceDto)) {
			return new ResponseEntity<DetailInvoiceDto>(detailInvoiceDto, HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{sale_id}")
	public Object delete(@PathVariable("sale_id") String sale_id) {
		if (detailInvoicesService.removeBySaleId(sale_id)) {
			return new ResponseEntity<String>(" Da Xoa Employees ", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<String>("Xoa That Bai", HttpStatus.BAD_REQUEST);
	}
}
