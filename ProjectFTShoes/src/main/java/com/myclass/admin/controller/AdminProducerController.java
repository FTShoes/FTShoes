package com.myclass.admin.controller;

import com.myclass.dto.ProducerDto;
import com.myclass.dto.ProducerEditDto;
import com.myclass.entity.Producer;
import com.myclass.repository.ProducerRepository;
import com.myclass.service.ProducerService;

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

@RestController
@RequestMapping("api/admin/producer")
@CrossOrigin("*")
public class AdminProducerController {

	@Autowired
	private ProducerService producerService;

	@GetMapping("")
	public Object getAll() {
		List<Producer> producer = producerService.getAll();
		if (producer == null) {
			return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<Producer>>(producer, HttpStatus.OK);
	}

	@PostMapping("")
	public Object add(@Valid @RequestBody ProducerDto producerDto, BindingResult errors) {
		if (errors.hasErrors()) {
			return new ResponseEntity<Object>(errors.getAllErrors(), HttpStatus.BAD_REQUEST);
		}
		producerDto.setId(UUID.randomUUID().toString());
		if (producerService.save(producerDto)) {
			return new ResponseEntity<ProducerDto>(producerDto, HttpStatus.CREATED);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}

	@PutMapping("/{id}")
	public Object update(@PathVariable("id") String id, @RequestBody ProducerEditDto producerEditDto) {
		producerEditDto.setId(id);
		if (producerService.update(id, producerEditDto)) {
			return new ResponseEntity<ProducerEditDto>(producerEditDto, HttpStatus.OK);
		}

		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	
	@DeleteMapping("/{id}")
	public Object delete(@PathVariable("id") String id) {
		if (producerService.delete(id)) {
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<HttpStatus>(HttpStatus.BAD_REQUEST);
	}
	
	@GetMapping("/{id}")
	public Object findById(@PathVariable("id") String id) {
		Producer producer = producerService.findById(id);
		if (producer != null) {
			return new ResponseEntity<Producer>(producer, HttpStatus.OK);
		}
		return new ResponseEntity<String>("Khong Tim Thay Producer Trong DataBase",HttpStatus.NO_CONTENT);
	}

}
