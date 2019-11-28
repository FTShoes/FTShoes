package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Producer;

public interface ProducerRepository {

	List<Producer> findAll();
	boolean saveOrUpdate(Producer producer);
	boolean removeById(String id);
	Producer findById(String id);
}
