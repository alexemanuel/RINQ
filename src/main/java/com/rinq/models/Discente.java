package com.rinq.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn()
public class Discente extends Usuario{
	
	private String course;
	private String subject;
	
	public Discente() {}
	
	public Discente(DataTransferObject DTO) {
		super(DTO);
		this.course  = DTO.getCourse();
		this.subject = DTO.getSubject();
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
