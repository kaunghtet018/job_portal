package com.hostmdy.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppliedJob {
	
	private Long jobPostId;
	private String jobTitle;
	private String status;
	private LocalDate appliedDate;
	private LocalTime appliedTime;
	
	public AppliedJob() {
		// TODO Auto-generated constructor stub
	}

	public AppliedJob(Long jobPostId, String jobTitle, String status, LocalDate appliedDate, LocalTime appliedTime) {
		super();
		this.jobPostId = jobPostId;
		this.jobTitle = jobTitle;
		this.status = status;
		this.appliedDate = appliedDate;
		this.appliedTime = appliedTime;
	}

	public Long getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(Long jobPostId) {
		this.jobPostId = jobPostId;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitel(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getAppliedDate() {
		return appliedDate;
	}

	public void setAppliedDate(LocalDate appliedDate) {
		this.appliedDate = appliedDate;
	}

	public LocalTime getAppliedTime() {
		return appliedTime;
	}

	public void setAppliedTime(LocalTime appliedTime) {
		this.appliedTime = appliedTime;
	}

	@Override
	public String toString() {
		return "AppliedJob [jobPostId=" + jobPostId + ", jobTitle=" + jobTitle + ", status=" + status + ", appliedDate="
				+ appliedDate + ", appliedTime=" + appliedTime + "]";
	}
	
	

}
