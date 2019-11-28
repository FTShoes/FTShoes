package com.myclass.dto;

import javax.validation.constraints.NotBlank;

public class ProducerEditDto {
	private String id;

	@NotBlank(message = "Nhap Ten NSX")
	private String name;

	@NotBlank(message = "Nhap So Dien Thoai NSX")
	private String phone;

	@NotBlank(message = "Nhap Dia Chi NSX")
	private String address;

	public ProducerEditDto() {
	}

	public ProducerEditDto(String id, String name, String phone, String address) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.address = address;
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

}
