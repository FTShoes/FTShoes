package com.myclass.entity;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employees {
	@Id
	@Column(name ="employees_id")
	private String id;
	@OneToMany(mappedBy = "employees",fetch = FetchType.LAZY)
	private List<SaleInvoice> saleInvoices;
	
	@Column(name ="nameEmployees")
	private String name;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="phone")
	private String phone;
	
	@Column(name ="address")
	private String address;
	
	@Column(name ="genderEmployees")
	private String gender;
	
	@Column(name="password")
	private String password;
	
	@Column(name="role_id")
	private String roleId;
	
	@ManyToOne
	@JoinColumn(name ="role_id" , insertable = false , updatable = false)
	
	private Role role;
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Employees() {
		// TODO Auto-generated constructor stub
	}
	public Employees(String id, String name, String email, String phone, String address, String gender, String roleId , String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.gender = gender;
		this.roleId = roleId;
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
}
