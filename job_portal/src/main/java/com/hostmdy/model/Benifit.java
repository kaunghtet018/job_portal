package com.hostmdy.model;

public class Benifit {
	
	private Long id;
	private String benifit;
	private Long jobPostId;
	
	public Benifit() {
		super();
	}

	public Benifit(String benifit, Long jobpostid) {
		super();
		this.benifit = benifit;
		this.jobPostId = jobpostid;
	}

	public Benifit(Long id, String benifit, Long jobpostid) {
		super();
		this.id = id;
		this.benifit = benifit;
		this.jobPostId = jobpostid;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBenifit() {
		return benifit;
	}

	public void setBenifit(String benifit) {
		this.benifit = benifit;
	}

	public Long getJobPostId() {
		return jobPostId;
	}

	public void setJobPostId(Long jobPostId) {
		this.jobPostId = jobPostId;
	}

	@Override
	public String toString() {
		return "Benifit [id=" + id + ", benifit=" + benifit + ", jobpostid=" + jobPostId + "]";
	}
	
	

}
