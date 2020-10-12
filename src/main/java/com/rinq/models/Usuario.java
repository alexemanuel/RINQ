 package com.rinq.models;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Id
	private String cpf;
	private String senha;
	private String nome;
	private String email;
	private String funcao;

	public Usuario() {}
	
	public Usuario(DataTransferObject DTO) {	
		this.cpf    = DTO.getCpf();
		this.nome   = DTO.getName();
		this.email  = DTO.getEmail();
		this.funcao = DTO.getRole();
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
 }
