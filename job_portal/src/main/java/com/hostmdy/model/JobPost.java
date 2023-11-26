package com.hostmdy.model;

import java.time.LocalDate;

public class JobPost {
	
	private Long id;
	private String title;
	private LocalDate dueDate;
	private String employer;
	private String location;
	private String type;
	private String industry;
	private Integer salary;
	
	private String description;
	private String status;
	
	public JobPost() {
		// TODO Auto-generated constructor stub
	}

	public JobPost(String title, LocalDate dueDate, String employer, String location, String type, String industry,
			Integer salary, String description) {
		super();
		this.title = title;
		this.dueDate = dueDate;
		this.employer = employer;
		this.location = location;
		this.type = type;
		this.industry = industry;
		this.salary = salary;
		this.description = description;
	}

	public JobPost(Long id, String title, LocalDate dueDate, String employer, String location, String type,
			String industry, Integer salary, String description) {
		super();
		this.id = id;
		this.title = title;
		this.dueDate = dueDate;
		this.employer = employer;
		this.location = location;
		this.type = type;
		this.industry = industry;
		this.salary = salary;
		this.description = description;
	}
	
	

	public JobPost(Long id, String title, LocalDate dueDate, String employer, String location, String type,
			String industry, Integer salary, String description, String status) {
		super();
		this.id = id;
		this.title = title;
		this.dueDate = dueDate;
		this.employer = employer;
		this.location = location;
		this.type = type;
		this.industry = industry;
		this.salary = salary;
		this.description = description;
		this.status = status;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public Integer getSalary() {
		return salary;
	}

	public void setSalary(Integer salary) {
		this.salary = salary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "JobPost [id=" + id + ", title=" + title + ", dueDate=" + dueDate + ", employer=" + employer
				+ ", location=" + location + ", type=" + type + ", industry=" + industry + ", salary=" + salary
				+ ", description=" + description + ", status=" + status + "]";
	}
	
}
