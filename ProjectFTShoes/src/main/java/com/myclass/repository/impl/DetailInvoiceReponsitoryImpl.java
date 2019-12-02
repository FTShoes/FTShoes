package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.myclass.entity.DetailInvoices;
import com.myclass.entity.Employees;
import com.myclass.repository.DetailInvoicesRepository;

@Repository
@Transactional(rollbackOn = Exception.class)
public class DetailInvoiceReponsitoryImpl implements DetailInvoicesRepository {

	@Autowired
	private SessionFactory sessionFactory;

//	public DetailInvoices findBySaleId(String sale_id) {
//		Session session = sessionFactory.getCurrentSession();
//		try {
//			Query<DetailInvoices> query = session.createQuery("FROM detailInvoices WHERE sale_id = :sale_id", DetailInvoices.class);
//			query.setParameter("sale_id", sale_id);
//			List<DetailInvoices> list = query.list();
//			if (!list.isEmpty())
//				return list.get(0);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return  null;
//	}
	
	public List<DetailInvoices> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<DetailInvoices> query = session.createQuery("FROM DetailInvoices", DetailInvoices.class);
			List<DetailInvoices> detailInvoices = query.getResultList();
			return detailInvoices;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<DetailInvoices> findBySaleId(String sale_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return  (List<DetailInvoices>) session.find(DetailInvoices.class, sale_id);
					//find(DetailInvoices.class, sale_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	public boolean saveOrUpdate(DetailInvoices detailInvoices) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(detailInvoices);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeBySaleId(String sale_id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			DetailInvoices entity = session.find(DetailInvoices.class, sale_id);
			session.delete(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	
}
