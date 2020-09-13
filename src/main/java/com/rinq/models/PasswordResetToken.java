package com.rinq.models;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class PasswordResetToken {
	
	private static final int EXPIRATION_TIME = 10; //Minutes
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@OneToOne(targetEntity = Usuario.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private Usuario user;
	
	private String token;
	private Date experyDate;
	
	public PasswordResetToken(String token, Usuario user) {
		this.token = token;
		this.user = user;
		this.experyDate = calcExperyDate();
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getExperyDate() {
		return experyDate;
	}

	public void setExperyDate(Date experyDate) {
		this.experyDate = experyDate;
	}
	
	public Usuario getUser() {
		return user;
	}
	
	public void setUser(Usuario user) {
		this.user = user;
	}
	
	private Date calcExperyDate() {
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.MINUTE, calendar.get(Calendar.MINUTE + EXPIRATION_TIME));
		
		return calendar.getTime();
	}
}
