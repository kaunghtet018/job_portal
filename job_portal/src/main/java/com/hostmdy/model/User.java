package com.hostmdy.model;

public class User {
	
	private Long id;
	private String firstName;
	private String lastName;
	private String nickName;
	private String email;
	private String password;
	private String role;
	private boolean locked;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(String firstName, String lastName, String nickName, String email, String password, String role,
			boolean locked) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.locked = locked;
	}



	

	public User(Long id, String firstName, String lastName, String nickName, String email, String password, String role,
			boolean locked) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nickName = nickName;
		this.email = email;
		this.password = password;
		this.role = role;
		this.locked = locked;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getNickName() {
		return nickName;
	}



	public void setNickName(String nickName) {
		this.nickName = nickName;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	public boolean isLocked() {
		return locked;
	}



	public void setLocked(boolean locked) {
		this.locked = locked;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", nickName=" + nickName
				+ ", email=" + email + ", password=" + password + ", role=" + role + ", locked=" + locked + "]";
	}



	
	
	

}
