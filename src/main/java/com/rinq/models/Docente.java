package com.rinq.models;

import java.util.List;

import javax.persistence.*;

import com.rinq.service.DTO.CadastroDTO;


@Entity
public class Docente extends Usuario{
	
	private static final long serialVersionUID = 1L;
	
	@OneToOne
	@JoinColumn(name = "id_curso")
	private Curso curso;

	@Column(nullable = false, length = 9)
	private String siape;

	@OneToOne
	@JoinColumn(name = "id_disciplina")
	private Disciplina disciplina;

	@OneToMany(mappedBy = "docente", targetEntity = Aula.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Aula> aulas;
	
	public Docente() {}
	
	public Docente(CadastroDTO DTO) {
		super(DTO);
		this.siape = DTO.getSiape(); 
		this.disciplina = DTO.getDisciplina();
		this.curso = DTO.getCurso();
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
