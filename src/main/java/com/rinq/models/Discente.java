package com.rinq.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Discente extends Usuario{
	
	private static final long serialVersionUID = 1L;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "id_curso")
	private Curso curso;
	
	@Column(nullable = false, length = 11)
	private String matricula;

	@ManyToMany(mappedBy = "discentes")
	private List<Disciplina> disciplinas;
	
	@OneToMany(mappedBy = "discente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Falta> faltas;
	
	@OneToMany(mappedBy = "discente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Prova> provas;
	
	public Discente() {}
	
	public Discente(DataTransferObject DTO, Curso curso, String matricula) {
		super(DTO);
		this.curso  = curso;
		this.matricula = matricula;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}

	//	public List<Falta> getFaltas() {
//		return faltas;
//	}
//
//	public void setFaltas(List<Falta> faltas) {
//		this.faltas = faltas;
//	}	
//	
//	public List<Prova> getProvas() {
//		return provas;
//	}
//
//	public void setProvas(List<Prova> provas) {
//		this.provas = provas;
//	}	
}
