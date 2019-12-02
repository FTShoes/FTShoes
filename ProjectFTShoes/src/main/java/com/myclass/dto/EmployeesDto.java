package com.myclass.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

import com.myclass.entity.Role;

public class EmployeesDto {
	@Id
	@Column(name ="employees_id")
	private String id;
	
	@NotBlank(message = "Tên không được bỏ trống!")
	@Column(name ="nameEmployees")
	private String name;
	
	@NotBlank(message = "Vui lòng nhập email")
	@Email(message = "Email không đúng quy định")
	@Column(name ="email")
	private String email;
	
	@Column(name ="phone")
	private String phone;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="genderEmployees")
	private String gender;
	
	@Column(name="role_id")
	private String roleId;
	private Role role;
	@NotBlank(message = "Vui lòng nhập password")
	@Column(name="password")
	private String password;
	
	
	public EmployeesDto() {
		// TODO Auto-generated constructor stub
	}
	public EmployeesDto(String id, String name, String email, String phone, String address, String gender,
			String roleId, Role role, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.roleId = roleId;
		this.role = role;
		this.password = password;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRoleId() {
		return roleId;
	}
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
}
