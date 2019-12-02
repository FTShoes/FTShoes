package com.myclass.dto;

import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class RoleEditDto {
	
	private String id;
	@NotBlank(message = "Ten Khong duoc bo trong!")
	@Length(min = 3, message = "Ten khong duoc it hon 3 ký tự!")
	private String name;
	
	@NotBlank(message = "Ten Khong duoc bo trong!")
	private String description;

	public RoleEditDto() {
		// TODO Auto-generated constructor stub
	}
	
	public RoleEditDto(String id, String name, String description) {
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
