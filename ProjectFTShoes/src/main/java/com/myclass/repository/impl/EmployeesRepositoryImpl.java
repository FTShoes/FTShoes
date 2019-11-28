package com.myclass.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Employees;
import com.myclass.repository.EmployeesRepository;

@Repository
@Transactional(rollbackOn = Exception.class)
public class EmployeesRepositoryImpl implements EmployeesRepository {
	@Autowired
	private SessionFactory sessionFactory;

	public List<Employees> findAll() {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Employees> query = session.createQuery("FROM Employees", Employees.class);
			List<Employees> employees = query.getResultList();
			return employees;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ArrayList<Employees>();
	}

	public Employees findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.find(Employees.class,id);
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null ;
	}

	public Employees findByEmail(String email) {
		// TODO Auto-generated method stub
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Employees> query = session.createQuery("From Employees WHERE email= :email", Employees.class);
			query.setParameter("email", email);
			List<Employees> list = query.list();
			if(!list.isEmpty()) {
				return list.get(0);
			}
			//return query.uniqueResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveorUpdate(Employees employees) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(employees);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Employees entity = session.find(Employees.class, id);
			session.load(Employees.class, id);
			session.delete(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
