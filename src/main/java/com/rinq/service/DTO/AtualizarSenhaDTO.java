package com.rinq.service.DTO;

import org.springframework.stereotype.Service;

import com.rinq.models.PasswordUpdateToken;

@Service
public class AtualizarSenhaDTO {
	
	private String login;
	private String password;
	private PasswordUpdateToken token;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PasswordUpdateToken getToken() {
		return token;
	}

	public void setToken(PasswordUpdateToken passwordResetToken) {
		this.token = passwordResetToken;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}
}
