package com.hostmdy.model;

public class Education {
	
	private Long id;
	private String certificate;
	private String institution;
	private String dateRange;
	private Long resumeId;
	
	public Education() {
		super();
	}

	public Education(String certificate, String institution, String dateRange, Long resumeId) {
		super();
		this.certificate = certificate;
		this.institution = institution;
		this.dateRange = dateRange;
		this.resumeId = resumeId;
	}

	public Education(Long id, String certificate, String institution, String dateRange, Long resumeId) {
		super();
		this.id = id;
		this.certificate = certificate;
		this.institution = institution;
		this.dateRange = dateRange;
		this.resumeId = resumeId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCertificate() {
		return certificate;
	}

	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}

	public String getInstitution() {
		return institution;
	}

	public void setInstitution(String institution) {
		this.institution = institution;
	}

	public String getDateRange() {
		return dateRange;
	}

	public void setDateRange(String dateRange) {
		this.dateRange = dateRange;
	}

	public Long getResumeId() {
		return resumeId;
	}

	public void setResumeId(Long resumeId) {
		this.resumeId = resumeId;
	}

	@Override
	public String toString() {
		return "Education [id=" + id + ", certificate=" + certificate + ", institution=" + institution + ", dateRange="
				+ dateRange + ", resumeId=" + resumeId + "]";
	}
	
	
	
	

}
