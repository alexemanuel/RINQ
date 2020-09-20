package com.rinq.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn()
public class Docente extends Usuario{
	
	private String course;
	private String subject;
	
	public Docente() {}
	
	public Docente(DataTransferObject ODT) {
		super(ODT);
		this.course  = ODT.getCourse();
		this.subject = ODT.getSubject();
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
		this.course = subject;
	}
}
