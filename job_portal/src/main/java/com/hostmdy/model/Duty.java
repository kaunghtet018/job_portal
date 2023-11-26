package com.hostmdy.model;

public class Duty {
	
	private Long id;
	private String duty;
	private Long jobPostId;
	
	public Duty() {
		// TODO Auto-generated constructor stub
	}

	public Duty(String duty, Long jobPostId) {
		super();
		this.duty = duty;
		this.jobPostId = jobPostId;
	}

	public Duty(Long id, String duty, Long jobPostId) {
		super();
		this.id = id;
		this.duty = duty;
		this.jobPostId = jobPostId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDuty() {
		return duty;
	}

	public void setDuty(String duty) {
		this.duty = duty;
	}

	public Long getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(Long jobPostId) {
		this.jobPostId = jobPostId;
	}

	@Override
	public String toString() {
		return "Duty [id=" + id + ", duty=" + duty + ", jobPostId=" + jobPostId + "]";
	}
	
	

}
