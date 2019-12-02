package com.myclass.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import com.myclass.entity.Role;

public class EmployeesDto {

	private String id;

	@NotBlank(message = "nhap email!")
	private String name;

	@NotBlank(message = "nhap email!")
	@Email(message = "Emailkhong dung dinh dang, vui long xem lai!")
	private String email;

	@NotBlank(message = "nhap SDT!")
	private String phone;

	@NotBlank(message = "nhap password!")
	private String password;
	
	@NotBlank(message = "nhap lai password!")
	private String confirmPassword;

	private String gender;
	private String address;
	private String roleId;

	@ManyToOne
	@JoinColumn(name = "role_id", insertable = false, updatable = false)
	private Role role;

	public EmployeesDto() {
		// TODO Auto-generated constructor stub
	}

	public EmployeesDto(String id, String name, String email, String phone, String password, String confirmPassword,
			String gender, String address, String roleId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.gender = gender;
		this.address = address;
		this.roleId = roleId;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
