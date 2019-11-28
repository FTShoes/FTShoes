package com.myclass.service.impl;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.ProducerDto;
import com.myclass.dto.ProducerEditDto;
import com.myclass.entity.Producer;
import com.myclass.repository.ProducerRepository;
import com.myclass.service.ProducerService;

@Service
public class ProducerServiceImpl implements ProducerService{

	@Autowired
	ProducerRepository producerRepository;
	
	public List<Producer> getAll() {
		return producerRepository.findAll();
	}

	public boolean save(ProducerDto producerDto) {
		//tao id cho producer
		producerDto.setId(UUID.randomUUID().toString());
		
		Producer Producer = new Producer(
				producerDto.getId(),
				producerDto.getName(),
				producerDto.getPhone(),
				producerDto.getAddress()
				);
		
		return producerRepository.saveOrUpdate(Producer);
	}

	public boolean update(String id, ProducerEditDto producerEditDto) {
		//lay thong tiu producer trong db
		Producer producer = producerRepository.findById(id);
		if(producer == null) {
			return false;
		}
		producer.setName(producerEditDto.getName());
		producer.setAddress(producerEditDto.getAddress());
		producer.setPhone(producerEditDto.getPhone());
		return producerRepository.saveOrUpdate(producer);
	}

	public boolean delete(String id) {
		return producerRepository.removeById(id);
	}

	public Producer findById(String id) {
		return producerRepository.findById(id);
	}
}
