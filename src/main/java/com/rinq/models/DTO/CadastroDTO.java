package com.rinq.models.DTO;

import org.springframework.beans.factory.annotation.Autowired;

import com.rinq.models.Curso;
import com.rinq.models.Disciplina;
import com.rinq.repositories.CursoRepository;
import com.rinq.repositories.DisciplinaRepository;

public class UsuarioDTO {

	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;
	
	// General User Attributes
	private String nome;
	private String email;
	private String cpf;
	private String funcao;
	
	// Docente and Discente Atrributes
	private Curso curso;
	
	// Only Docente Attributes
	private Disciplina disciplina;
	private String siape;
	
	public UsuarioDTO(){}	
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(String nomeCurso) {
		this.curso = cursoRepository.findByNome(nomeCurso);
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String nomeDisciplina) {
		this.disciplina = disciplinaRepository.findByNome(nomeDisciplina);
	}

	public String getSiape() {
		return siape;
	}

	public void setSiape(String siape) {
		this.siape = siape;
	}
}
