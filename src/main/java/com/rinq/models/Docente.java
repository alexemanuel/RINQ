package com.rinq.models;

import java.util.List;

import javax.persistence.*;


@Entity
public class Docente extends Usuario{
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	private Curso curso;

	private String siape;

	@ManyToOne
	private Disciplina disciplina;

	@OneToMany(mappedBy = "docente", targetEntity = Aula.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aula> aulas;
	
	public Docente() {}
	
	public Docente(DataTransferObject DTO, Curso curso) {
		super(DTO);
		this.siape = DTO.getSiape(); 
		//this.disciplina = DTO.getSubject();
		this.curso = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}
}
