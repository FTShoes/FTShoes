package com.myclass.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class RoleDto {
	
	private String id;
	
	@NotBlank(message = "Ten Khong duoc bo trong!")
	@Length(min = 3, message = "Tên không được ít hơn 3 ký tự!")
	private String name;
	
	@NotBlank(message = "Ten Khong duoc bo trong!")
	private String description;

	public RoleDto() {	}

	public RoleDto(String id, String name, String description) {
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
