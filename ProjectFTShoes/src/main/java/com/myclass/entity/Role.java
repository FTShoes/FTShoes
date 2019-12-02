package com.myclass.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;


@Entity
@Table(name = "roles")
public class Role {
	@Id
	@Column(name="role_id")
	private String id;
	
	@NotBlank(message = "Tên không được bỏ trống!")	
	@Column(name ="nameRole")
	private String name;
	
	@NotBlank(message = "Mô tả không được bỏ trống!")
	private String description;
	@OneToMany(mappedBy = "role",fetch = FetchType.LAZY)
	private List<Employees> employees;
	
	//@OneToMany(mappedBy = "role" , fetch = FetchType.LAZY)
	public Role() {
		
	}
	
	public Role(String id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
