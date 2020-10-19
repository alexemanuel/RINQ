package com.rinq.services.security;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinq.models.PasswordResetToken;
import com.rinq.models.Usuario;
import com.rinq.repositories.PasswordResetTokenRepository;

@Service
public class PasswordResetTokenService {
		
	@Autowired
	PasswordResetTokenRepository passwordResetTokenRepository;
	
	public PasswordResetToken createToken(Usuario user) {
		String tokenValue = UUID.randomUUID().toString();
		PasswordResetToken passwordResetTokenObj = new PasswordResetToken(tokenValue, user);
		
		return passwordResetTokenObj;
	}
	
	public boolean isValidToken(String tokenValue) {
		Calendar calendar = Calendar.getInstance();		
		PasswordResetToken passwordResetTokenObj = passwordResetTokenRepository.findByToken(tokenValue);
		
		return passwordResetTokenObj != null && calendar.before(passwordResetTokenObj.getDataExperiracao());
	}
}
