 package com.rinq.models;

import java.io.Serializable;

import javax.persistence.*;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.rinq.service.DTO.CadastroDTO;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario implements Serializable{	
	
	private static final long serialVersionUID = 1L;
	private static final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	@Id
	private String login;
	@Column(nullable = false, length = 14)
	private String cpf;
	@Column(nullable = false, length = 60)
	private String senha;
	@Column(nullable = false, length = 100)
	private String nome;
	@Column(nullable = false, length = 100)
	private String email;
	@Column(nullable = false, length = 14)
	private String funcao;

	public Usuario() {}
	
	public Usuario(CadastroDTO DTO) {	
		cpf    = DTO.getCpf();
		nome   = DTO.getNome();
		email  = DTO.getEmail();
		funcao = DTO.getFuncao();
		login  = (funcao.equals("discente")) ? DTO.getMatricula() : DTO.getSiape();		
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
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
