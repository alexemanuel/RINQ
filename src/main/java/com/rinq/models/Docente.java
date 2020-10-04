package com.rinq.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Docente extends Usuario{
	
	private String siape;
	private String curso;
	private String disciplina;

	@OneToMany(mappedBy = "siape", targetEntity = Aula.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aula> aulas;
	
	public Docente() {}
	
	public Docente(DataTransferObject DTO) {
		super(DTO);
		this.siape = DTO.getSiape(); 
		this.disciplina = DTO.getSubject();
		this.curso  = DTO.getCourse();
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}
}
