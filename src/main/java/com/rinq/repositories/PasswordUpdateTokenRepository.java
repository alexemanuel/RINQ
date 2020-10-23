package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rinq.models.PasswordUpdateToken;

@Repository
public interface PasswordUpdateTokenRepository extends CrudRepository<PasswordUpdateToken, Long> {
	
	PasswordUpdateToken findByTokenString(String tokenString); 
	
	@Transactional
	void deleteByTokenString(String tokenString);
}
