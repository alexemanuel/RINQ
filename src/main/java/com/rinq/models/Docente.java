package com.rinq.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


@Entity
public class Docente extends Usuario{
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Curso curso;
	
	private String disciplina;
	private String siape;

	@OneToMany(mappedBy = "docente", targetEntity = Aula.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aula> aulas;
	
	public Docente() {}
	
	public Docente(DataTransferObject DTO, Curso curso) {
		super(DTO);
		this.siape = DTO.getSiape(); 
		this.disciplina = DTO.getSubject();
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
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
