package com.myclass.service;

import java.util.List;

import com.myclass.dto.ProducerDto;
import com.myclass.dto.ProducerEditDto;
import com.myclass.entity.Producer;

public interface ProducerService {
	List<Producer> getAll();
	boolean save(ProducerDto producerDto);
	boolean update(String id , ProducerEditDto producerEditDto);
	boolean delete(String id);
	Producer findById(String id);
}
