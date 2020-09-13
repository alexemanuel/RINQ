package com.rinq.models;

import javax.persistence.Entity;

@Entity
public class Discente extends Usuario{

	private String course;
	private String program;
	
	public Discente() {}
	
	public Discente(DataTransferObject OTD) {
		super(OTD);
		this.program = OTD.getProgram();
		this.course = OTD.getCourse();
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getProgram() {
		return program;
	}

	public void setProgram(String program) {
		this.program = program;
	}

}
