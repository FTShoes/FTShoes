package com.myclass.admin.controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myclass.dto.SaleInvoicesDto;
import com.myclass.entity.SaleInvoice;
import com.myclass.repository.SaleInvoiceRepository;
import com.myclass.service.SaleInvoicesService;

@RestController
@RequestMapping("api/admin/saleinvoices")

public class AdminSaleInvoiceController {
	
	@Autowired //Tiêm SaleInvoiceRepository vào để xài
	SaleInvoiceRepository saleInvoiceRepository;
	
	@Autowired
	private SaleInvoicesService saleInvoicesService;
	@CrossOrigin("*")
	
	@GetMapping("")
	public Object getAll() {
		// Tạo đối tượng session để truy vấn database
		List<SaleInvoice> saleInvoices = saleInvoicesService.getAll();
		// Nếu trả vể null (có lỗi xảy ra ở tầng Reponsitory)
		if (saleInvoices == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		// Nếu hàm findAll trả về khac null (không có lỗi) thì trả về danh sách user
		return new ResponseEntity<List<SaleInvoice>>(saleInvoices, HttpStatus.OK);
	}
	
	@GetMapping("{/{id}}")
	public Object getID(@PathVariable("id") String id) {
		SaleInvoice saleInvoice= saleInvoiceRepository.findById(id);
		return new ResponseEntity<SaleInvoice>(saleInvoice, HttpStatus.OK);
	}
	
	@PostMapping("")
	public Object add(@Valid @RequestBody SaleInvoicesDto saleInvoicesDto, BindingResult errors) {
		// 
		if(errors.hasErrors()) {
			return new ResponseEntity<Object>(errors.getAllErrors(),HttpStatus.BAD_REQUEST);
		}
		// Kiểm tra điều kiện trong SalaInvoiceDto
		// Thực hiện hàm saveorUpdate thành công(ko có lỗi)
		if (saleInvoicesService.save(saleInvoicesDto)) {
			// Thêm thành công
			return new ResponseEntity<SaleInvoicesDto>(saleInvoicesDto, HttpStatus.CREATED);
		}
		// Thêm thất bại
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("{/{id}}")
	public Object delete(@PathVariable("id") String id) {
		if (saleInvoiceRepository.removeById(id)) {
			return new ResponseEntity<SaleInvoice>(HttpStatus.OK);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	}
}
