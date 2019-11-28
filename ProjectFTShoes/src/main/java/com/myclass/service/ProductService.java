package com.myclass.service;

import java.util.List;

import com.myclass.dto.ProducerDto;
import com.myclass.dto.ProducerEditDto;
import com.myclass.dto.ProductDto;
import com.myclass.dto.ProductEditDto;
import com.myclass.entity.Product;

public interface ProductService {
	List<Product> getAll();
	boolean save(ProductDto productDto);
	boolean update(String id , ProductEditDto productEditDto);
	boolean delete(String id);
	Product findById(String id);
}
