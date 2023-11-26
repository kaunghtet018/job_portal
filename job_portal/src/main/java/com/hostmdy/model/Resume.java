package com.hostmdy.model;

import java.time.LocalDate;

public class Resume {
	
	private Long id;
	private String name;
	private String gender;
	private LocalDate dateOfBirth;
	
	private String phone;
	private String email;
	private String address;
	
	private String about;
	
	public Resume() {
		// TODO Auto-generated constructor stub
	}

	public Resume(String name, String gender, LocalDate dateOfBirth, String phone, String email, String address,
			String about) {
		super();
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.about = about;
	}

	public Resume(Long id, String name, String gender, LocalDate dateOfBirth, String phone, String email,
			String address, String about) {
		super();
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.about = about;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	@Override
	public String toString() {
		return "Resume [id=" + id + ", name=" + name + ", gender=" + gender + ", dateOfBirth=" + dateOfBirth
				+ ", phone=" + phone + ", email=" + email + ", address=" + address + ", about=" + about + "]";
	}
	
	
	

}
