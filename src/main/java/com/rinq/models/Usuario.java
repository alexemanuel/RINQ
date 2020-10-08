 package com.rinq.models;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;


 @Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario{	

	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Id
	private String cpf;
	private String senha;
	private String nome;
	private String email;
	private String funcao;

	@OneToMany(mappedBy = "discente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Falta> faltas;

	@OneToMany(mappedBy = "discente", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Prova> provas;
	
	public Usuario() {}
	
	public Usuario(DataTransferObject DTO) {	
		this.cpf   = DTO.getCpf();
		this.nome  = DTO.getName();
		this.email = DTO.getEmail();
		this.funcao  = DTO.getRole();
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {		
		this.senha = passwordEncoder.encode(senha);
	}
	
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

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}

	 public Set<Falta> getFaltas() {
		 return faltas;
	 }

	 public void setFaltas(Set<Falta> faltas) {
		 this.faltas = faltas;
	 }

	 public Set<Prova> getProvas() {
		 return provas;
	 }

	 public void setProvas(Set<Prova> provas) {
		 this.provas = provas;
	 }
 }
