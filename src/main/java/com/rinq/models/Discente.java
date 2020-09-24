package com.rinq.models;

import javax.persistence.Entity;

@Entity
public class Discente extends Usuario{

	private String course;
	private String subject;
	private String siape;
	
	public Discente() {}
	
	public Discente(DataTransferObject OTD) {
		super(OTD);
		this.setSiape(OTD.getSiape()); 
		this.subject = OTD.getSubject();
		this.course  = OTD.getCourse();
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}
}
