package com.rinq.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Docente extends Usuario{

	private String course;
	private String subject;
	private String siape;

	@OneToMany(mappedBy = "siape", targetEntity = Aula.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aula> aulas;
	
	public Docente() {}
	
	public Docente(DataTransferObject DTO) {
		super(DTO);
		this.setSiape(DTO.getSiape()); 
		this.subject = DTO.getSubject();
		this.course  = DTO.getCourse();
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
