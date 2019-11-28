package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Producer;
import com.myclass.repository.ProducerRepository;
import com.myclass.service.ProducerService;

@Repository
@Transactional(rollbackOn = Exception.class)
public class ProducerRepositoryImpl implements ProducerRepository {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Producer> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Producer> query = session.createQuery("FROM Producer", Producer.class);
			List<Producer> producers = query.getResultList();
			return producers;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveOrUpdate(Producer producer) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(producer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Producer entity = session.find(Producer.class, id);
			session.delete(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Producer findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.find(Producer.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
