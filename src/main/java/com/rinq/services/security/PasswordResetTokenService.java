package com.rinq.services.security;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinq.models.PasswordUpdateToken;
import com.rinq.models.Usuario;
import com.rinq.repositories.PasswordUpdateTokenRepository;

@Service
public class PasswordResetTokenService {
		
	@Autowired
	PasswordUpdateTokenRepository passwordResetTokenRepository;
	
	public PasswordUpdateToken generateToken(Usuario user) {
		String tokenValue = UUID.randomUUID().toString();
		PasswordUpdateToken passwordResetTokenObj = new PasswordUpdateToken(tokenValue, user);
		
		return passwordResetTokenObj;
	}
	
	public boolean isValidToken(String tokenValue) {
		Calendar calendar = Calendar.getInstance();		
		PasswordUpdateToken passwordResetTokenObj = passwordResetTokenRepository.findByTokenString(tokenValue);
		
		return passwordResetTokenObj != null && calendar.before(passwordResetTokenObj.getDataExperiracao());
	}
}
