package com.hostmdy.model;

public class Requirement {
	
	private Long id;
	private String requirement;
	private Long jobPostId;
	
	public Requirement() {
		// TODO Auto-generated constructor stub
	}

	public Requirement(String requirement, Long jobPostId) {
		super();
		this.requirement = requirement;
		this.jobPostId = jobPostId;
	}

	public Requirement(Long id, String requirement, Long jobPostId) {
		super();
		this.id = id;
		this.requirement = requirement;
		this.jobPostId = jobPostId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequirement() {
		return requirement;
	}

	public void setRequirement(String requirement) {
		this.requirement = requirement;
	}

	public Long getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(Long jobPostId) {
		this.jobPostId = jobPostId;
	}

	@Override
	public String toString() {
		return "Requirement [id=" + id + ", requirement=" + requirement + ", jobPostId=" + jobPostId + "]";
	}
	
	

}
