package com.myclass.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.SaleInvoice;
import com.myclass.repository.SaleInvoiceRepository;
@Repository
@Transactional(rollbackOn = Exception.class)
public class SaleRepositoryImpl implements SaleInvoiceRepository{
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<SaleInvoice> findAll() {
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession();
				try {
					Query<SaleInvoice> query = session.createQuery("FROM SaleInvoice", SaleInvoice.class);
					List<SaleInvoice> saleInvoices = query.getResultList();
					return saleInvoices;
				} catch (Exception e) {
					e.printStackTrace();
				}
				return new ArrayList<SaleInvoice>();
	}

	public SaleInvoice findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.find(SaleInvoice.class,id);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}

	public boolean save(SaleInvoice saleInvoice) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.save(saleInvoice);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			SaleInvoice entity = session.find(SaleInvoice.class, id);
			session.load(SaleInvoice.class, id);
			session.delete(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
