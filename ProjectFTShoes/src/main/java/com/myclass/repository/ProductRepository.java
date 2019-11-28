package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Product;

public interface ProductRepository {
		List<Product> findAll();
		Product findById(String id);
		boolean saveOrUpdate(Product product);
		boolean removeById(String id);
}
