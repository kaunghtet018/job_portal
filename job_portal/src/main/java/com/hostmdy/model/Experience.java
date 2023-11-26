package com.hostmdy.model;

public class Experience {

	private Long id;
	private String company;
	private String location;
	private String position;
	private String dateRange;
	private String task;
	private Long resumeId;

	public Experience() {
		super();
	}

	public Experience(String company, String location, String position, String dateRange, String task, Long resumeId) {
		super();
		this.company = company;
		this.location = location;
		this.position = position;
		this.dateRange = dateRange;
		this.task = task;
		this.resumeId = resumeId;
	}

	public Experience(Long id, String company, String location, String position, String dateRange, String task,
			Long resumeId) {
		super();
		this.id = id;
		this.company = company;
		this.location = location;
		this.position = position;
		this.dateRange = dateRange;
		this.task = task;
		this.resumeId = resumeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public Long getResumeId() {
		return resumeId;
	}

	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}

	@Override
	public String toString() {
		return "Experience [id=" + id + ", company=" + company + ", location=" + location + ", position=" + position
				+ ", dateRange=" + dateRange + ", task=" + task + ", resumeId=" + resumeId + "]";
	}

}
