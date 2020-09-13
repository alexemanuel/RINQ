package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rinq.models.PasswordResetToken;

public interface PasswordResetTokenRepository extends CrudRepository<PasswordResetToken, Long> {
	
	PasswordResetToken findByToken(String tokenValue); 
	
}
