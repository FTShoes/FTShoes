package com.myclass.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
@Repository
@Transactional(rollbackOn = Exception.class)
public class RoleRepositoryImpl implements RoleRepository {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Role> findAll() {
		// TODO Auto-generated method stub
		// Tạo đối tượng session để truy vấn database
				Session session = sessionFactory.getCurrentSession(); // Nhân viên ngân hàng

				try {
					// Thực hiện giao dịch
					Query<Role> query = session.createQuery("FROM Role", Role.class);
					List<Role> roles = query.getResultList();

					return roles;
				} catch (Exception e) {
					e.printStackTrace();
				} 
				return new ArrayList<Role>();
	}

	public boolean add(Role role) {
		// TODO Auto-generated method stub
		// Thực hiện giao dịch
				// Tạo đối tượng session để truy vấn database
				Session session = sessionFactory.getCurrentSession(); // Nhân viên ngân hàng
				try {
					// Thực hiện giao dịch
					session.save(role);
					// Trả về đối tượng vừa thêm vào
					return true;
				} catch (HibernateException e) {
					e.printStackTrace();
				} 
				return false;
	}

	public boolean saveorUpdate(Role role) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
				Session session = sessionFactory.getCurrentSession(); //Nhân viên ngân hàng
				//Transaction transaction = null;
				try {
					session.saveOrUpdate(role);
					// Trả về đối tượng vừa cập nhật
					return true;
				} catch (HibernateException e) {
					e.printStackTrace();
				}
				return false;
	}

	public boolean removeById(String id) {
		Session session = sessionFactory.getCurrentSession();
		try {
			// thuc hien giao dich
			Role entity = session.find(Role.class, id);
			session.delete(entity);					   
			return true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	

	}

}
