package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Role;

public interface RoleRepository {
	List<Role> findAll();
	boolean saveOrUpdate(Role role);
	boolean removeById(String id);
	Role findById(String id);
}
