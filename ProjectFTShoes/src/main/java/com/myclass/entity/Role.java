package com.myclass.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity(name = "roles")
public class Role {
	@Id
	private String Role_id;
	@NotBlank(message = "Vui lòng nhập tên!")
	@Length(min = 4, message = "Tên không được ít hơn 4 ký tự!")
	@Column(name = "NameRole")
	private String NameRole;
	
	@NotBlank(message = "Vui lòng nhập mô tả!")
	@Column(name ="description")
	private String description;
	//@OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
	
	public Role(String role_id, String nameRole, String description) {
		super();
		Role_id = role_id;
		NameRole = nameRole;
		this.description = description;
	}
	
	public String getRole_id() {
		return Role_id;
	}
	public void setRole_id(String role_id) {
		Role_id = role_id;
	}
	public String getNameRole() {
		return NameRole;
	}
	public void setNameRole(String nameRole) {
		NameRole = nameRole;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
