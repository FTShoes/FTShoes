package com.myclass.service;

import java.util.List;

import com.myclass.dto.RoleDto;
import com.myclass.dto.RoleEditDto;
import com.myclass.entity.Role;

public interface RoleService {
	List<Role> getAll();
	boolean save(RoleDto roleDto);
	boolean update(String id , RoleEditDto roleEditDto);
	boolean delete(String id);
	Role findById(String id);
}
