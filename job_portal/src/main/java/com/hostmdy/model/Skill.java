package com.hostmdy.model;

public class Skill {
	
	private Long id;
	private String skill;
	private Long resumeId;
	public Skill() {
		super();
	}
	public Skill(String skill, Long resumeId) {
		super();
		this.skill = skill;
		this.resumeId = resumeId;
	}
	public Skill(Long id, String skill, Long resumeId) {
		super();
		this.id = id;
		this.skill = skill;
		this.resumeId = resumeId;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSkill() {
		return skill;
	}
	public void setSkill(String skill) {
		this.skill = skill;
	}
	public Long getResumeId() {
		return resumeId;
	}
	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}
	@Override
	public String toString() {
		return "Skill [id=" + id + ", skill=" + skill + ", resumeId=" + resumeId + "]";
	}
	
	

}
