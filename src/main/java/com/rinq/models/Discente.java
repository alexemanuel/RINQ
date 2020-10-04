package com.rinq.models;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
	
@Entity
public class Discente extends Usuario{
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	public Discente() {}
	
	public Discente(DataTransferObject DTO, Curso curso) {
		super(DTO);
		this.curso  = curso;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}
}
