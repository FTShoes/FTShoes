package com.myclass.repository.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;

@Repository
@Transactional(rollbackOn = Exception.class)
public class RoleRepositoryImpl implements RoleRepository{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Role> findAll() {
		Session session = sessionFactory.getCurrentSession();
		try {
			Query<Role> query = session.createQuery("FROM Role", Role.class);
			List<Role> roles = query.getResultList();
			return roles;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean saveOrUpdate(Role role) {
		Session session = sessionFactory.getCurrentSession();
		try {
			session.saveOrUpdate(role);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public boolean removeById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			Role entity = session.find(Role.class, id);
			session.delete(entity);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public Role findById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			return session.find(Role.class, id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
