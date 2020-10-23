package com.rinq.models;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PasswordUpdateToken {
	
	private static final int TEMPO_EXPIRACAO = 10; //Minutes
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "login_usuario")
	private Usuario usuario;
	
	private String tokenString;
	private Calendar dataExperiracao;
	
	public PasswordUpdateToken() {}
	
	public PasswordUpdateToken(String tokenString, Usuario usuario) {
		this.tokenString = tokenString;
		this.usuario = usuario;
		
		initializeDataExpiracao();
	}
	
	private void initializeDataExpiracao() {
		// Instance an object with the current date
		dataExperiracao = Calendar.getInstance();
		// Add TEMPO_EXPIRACAO in current date minutes
		dataExperiracao.set(Calendar.MINUTE, dataExperiracao.get(Calendar.MINUTE) + TEMPO_EXPIRACAO);
	}

	public Calendar getDataExperiracao() {
		return dataExperiracao;
	}

	public void setDataExperiracao(Calendar dataExpericao) {
		this.dataExperiracao = dataExpericao;
	}

	public String getTokenString() {
		return tokenString;
	}

	public void setTokenString(String tokenString) {
		this.tokenString = tokenString;
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
	
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
