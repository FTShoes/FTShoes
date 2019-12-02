package com.myclass.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myclass.dto.RoleDto;
import com.myclass.dto.RoleEditDto;
import com.myclass.entity.Role;
import com.myclass.repository.RoleRepository;
import com.myclass.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	private RoleRepository roleRepository;
	
	public List<Role> getAll() {
		return roleRepository.findAll();
	}

	public boolean save(RoleDto roleDto) {
		roleDto.setId(UUID.randomUUID().toString());
		
		Role role = new Role(
				roleDto.getId(),
				roleDto.getName(),
				roleDto.getDescription()
				); 
		return roleRepository.saveOrUpdate(role);
	}

	public boolean update(String id, RoleEditDto roleEditDto) {
		Role role = roleRepository.findById(id);
		if(role == null) {
			return false;
		}
		role.setId(roleEditDto.getId());
		role.setName(roleEditDto.getName());
		role.setDescription(roleEditDto.getDescription());
		return roleRepository.saveOrUpdate(role);
	}
	
	public boolean delete(String id) {
		return roleRepository.removeById(id);
	}

	public Role findById(String id) {
		
		return roleRepository.findById(id);
	}



}
