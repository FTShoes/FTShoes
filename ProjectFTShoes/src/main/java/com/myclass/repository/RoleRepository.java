package com.myclass.repository;

import java.util.List;

import com.myclass.entity.Role;

public interface RoleRepository {
	List<Role> findAll();
	boolean add(Role role);
	boolean saveorUpdate( Role role);
	boolean removeById(String id);
}
