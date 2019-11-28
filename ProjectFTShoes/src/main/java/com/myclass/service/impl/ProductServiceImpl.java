package com.myclass.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.ProductDto;
import com.myclass.dto.ProductEditDto;
import com.myclass.entity.Producer;
import com.myclass.entity.Product;
import com.myclass.repository.ProductRepository;
import com.myclass.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	public List<Product> getAll() {
		return productRepository.findAll();
	}

	public boolean save(ProductDto productDto) {
		productDto.setId(UUID.randomUUID().toString());
	Product product = new Product(
			productDto.getId(),
			productDto.getName(),
			productDto.getProducer_id(),
			productDto.getType(),
			productDto.getSize(),
			productDto.getAmount(),
			productDto.getPrice(),
			productDto.getPriceSale(),
			productDto.getDayInput()
			);
		return productRepository.saveOrUpdate(product);
	}

	public boolean update(String id, ProductEditDto productEditDto) {
		Product product = productRepository.findById(id);
		if(product == null) {
			return false;
		}
		product.setProducer_id(productEditDto.getProducer_id());
		product.setName(productEditDto.getName());
		product.setType(productEditDto.getType());
		product.setSize(productEditDto.getSize());
		product.setAmount(productEditDto.getAmount());
		product.setPrice(productEditDto.getPrice());
		product.setPriceSale(productEditDto.getPriceSale());
		return productRepository.saveOrUpdate(product);
	}

	public boolean delete(String id) {
		return productRepository.removeById(id);
	}

	public Product findById(String id) {
		return productRepository.findById(id);
	}
}
