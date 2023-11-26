package com.hostmdy.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class JobApply {
	
	private Long id;
	private Long userId;
	private Long jobPostId;
	private LocalDate applyDate;
	private LocalTime applyTime;
	
	public JobApply() {
		// TODO Auto-generated constructor stub
	}

	public JobApply(Long userId, Long jobPostId, LocalDate applyDate, LocalTime applyTime) {
		super();
		this.userId = userId;
		this.jobPostId = jobPostId;
		this.applyDate = applyDate;
		this.applyTime = applyTime;
	}

	public JobApply(Long id, Long userId, Long jobPostId, LocalDate applyDate, LocalTime applyTime) {
		super();
		this.id = id;
		this.userId = userId;
		this.jobPostId = jobPostId;
		this.applyDate = applyDate;
		this.applyTime = applyTime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(Long jobPostId) {
		this.jobPostId = jobPostId;
	}

	public LocalDate getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(LocalDate applyDate) {
		this.applyDate = applyDate;
	}

	public LocalTime getApplyTime() {
		return applyTime;
	}

	public void setApplyTime(LocalTime applyTime) {
		this.applyTime = applyTime;
	}

	@Override
	public String toString() {
		return "JobApply [id=" + id + ", userId=" + userId + ", jobPostId=" + jobPostId + ", applyDate=" + applyDate
				+ ", applyTime=" + applyTime + "]";
	}
	
	

}
