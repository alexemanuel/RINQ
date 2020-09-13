package com.rinq.services.token;

import java.util.Calendar;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;

import com.rinq.models.PasswordResetToken;
import com.rinq.models.Usuario;
import com.rinq.repositories.PasswordResetTokenRepository;

public class PasswordResetTokenService {
	
	@Autowired
	static
	PasswordResetTokenRepository passwordResetTokenRepository;
	
	public static PasswordResetToken createToken(Usuario user) {
		String tokenValue = UUID.randomUUID().toString();
		PasswordResetToken passwordResetTokenObj = new PasswordResetToken(tokenValue, user);
		
		return passwordResetTokenObj;
	}
	
	public static boolean checkTokenValidity(String tokenValue) {
		Calendar calendar = Calendar.getInstance();
		PasswordResetToken passwordResetTokenObj = passwordResetTokenRepository.findByToken(tokenValue);
		
		return passwordResetTokenObj != null || calendar.before(passwordResetTokenObj.getExperyDate());
	}
}
