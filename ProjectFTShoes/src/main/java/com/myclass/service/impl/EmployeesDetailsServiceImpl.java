//package com.myclass.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import com.myclass.dto.EmployeesDetailsDto;
//
//import com.myclass.entity.Employees;
//import com.myclass.repository.EmployeesRepository;
//@Service
//public class EmployeesDetailsServiceImpl implements UserDetailsService{
//
//	@Autowired
//	private EmployeesRepository employeesRepository;
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		Employees employees = employeesRepository.findByEmail(email);
//		if(employees == null) {
//			throw new UsernameNotFoundException("Email không tồn tại!");
//		}
//		//Lấy ra tên quyền tương ứng với user
//		//Bảng user join 
//		String roleName = employees.getRole().getName();
//		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
//		authorities.add(new SimpleGrantedAuthority(roleName));
//		//Tạo đối tượng UserDetailsDTO
//		EmployeesDetailsDto EmployeesDetailsDto = 
//				new EmployeesDetailsDto(employees.getName(), employees.getPassword(), authorities);
//		return EmployeesDetailsDto;
//		}
//
//}