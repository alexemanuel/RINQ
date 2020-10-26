package com.rinq.service.DTO;

import org.springframework.stereotype.Service;

import com.rinq.models.Curso;
import com.rinq.models.Disciplina;

@Service
public class CadastroDTO {
	
	// General User Attributes
	
	private String nome;
	private String email;
	private String cpf;
	private String funcao;
	
	// Docente and Discente Atrributes
	private String abreviacaoCurso;
	private Curso curso;
	
	// Only Docente Attributes
	private String nomeDisciplina;
	private Disciplina disciplina;
	private String siape;
	
	// Only Discente Attributes
	private String matricula;

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

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;	
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getAbreviacaoCurso() {
		return abreviacaoCurso;
	}

	public void setAbreviacaoCurso(String abreviacaoCurso) {
		this.abreviacaoCurso = abreviacaoCurso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
