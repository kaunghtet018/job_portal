package com.hostmdy.model;

import java.time.LocalDate;
import java.time.LocalTime;

public class UserInfo{
	private Long userId;
	private Long jobPostId;
	private String nickName;
	private String email;
	private LocalDate applyDate;
	private LocalTime applyTime;
	
	public UserInfo(Long userId, Long jobPostId, String nickName, String email, LocalDate applyDate,
			LocalTime applyTime) {
		super();
		this.userId = userId;
		this.jobPostId = jobPostId;
		this.nickName = nickName;
		this.email = email;
		this.applyDate = applyDate;
		this.applyTime = applyTime;
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
		return "UserInfo [userId=" + userId + ", jobPostId=" + jobPostId + ", nickName=" + nickName + ", email="
				+ email + ", applyDate=" + applyDate + ", applyTime=" + applyTime + "]";
	}
	
}
