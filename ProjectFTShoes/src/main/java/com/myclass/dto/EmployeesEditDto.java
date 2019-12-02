package com.myclass.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class EmployeesEditDto {

	private String id;
	
	@NotBlank(message = "cap nhat ten Employee")
	private String name;
	
	@NotBlank(message = "cap nhat email")
	@Email(message = "Emailkhong dung dinh dang, vui long xem lai!")
	private String email;
	@NotBlank(message = "cap nhat sdt")
	private String phone;
	private String address;
	private String gender;
	private String password;
	private String roleId;
	
	public EmployeesEditDto() {
		// TODO Auto-generated constructor stub
	}

	public EmployeesEditDto(String id, String name, String email, String phone, String address, String gender,
			String password, String roleId) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRoleId() {
		return roleId;
	}

	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}
}
