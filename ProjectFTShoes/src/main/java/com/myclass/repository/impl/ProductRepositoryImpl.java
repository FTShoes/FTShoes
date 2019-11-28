package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Producer;
import com.myclass.entity.Product;
import com.myclass.repository.ProductRepository;

@Repository
@Transactional(rollbackOn = Exception.class)
public class ProductRepositoryImpl implements ProductRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Product> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Product> query = session.createQuery("FROM Product", Product.class);
			List<Product> product = query.getResultList();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public Product findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.find(Product.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveOrUpdate(Product product) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(product);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Product entity = session.find(Product.class, id);
			session.delete(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
}
