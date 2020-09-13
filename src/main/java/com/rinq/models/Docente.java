package com.rinq.models;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn()
public class Docente extends Usuario{
	
	private String course;
	private String program;
	
	public Docente() {}
	
	public Docente(DataTransferObject ODT) {
		super(ODT);
		this.program = ODT.getCourse();
		this.course = ODT.getProgram();
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
