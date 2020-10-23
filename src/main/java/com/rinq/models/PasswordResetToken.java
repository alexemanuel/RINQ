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
public class PasswordResetToken {
	
	private static final int TEMPO_EXPIRACAO = 10; //Minutes
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "cpf_usuario")
	private Usuario user;
	
	private String token;
	private Calendar dataExperiracao;
	
	public PasswordResetToken() {}
	
	public PasswordResetToken(String token, Usuario user) {
		this.token = token;
		this.user = user;
		this.dataExperiracao = calcExperyDate();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Usuario getUser() {
		return user;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	private Calendar calcExperyDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE) + TEMPO_EXPIRACAO);
		
		return calendar;
	}

	public Calendar getDataExperiracao() {
		return dataExperiracao;
	}

	public void setDataExperiracao(Calendar dataExpericao) {
		this.dataExperiracao = dataExpericao;
	}
}
