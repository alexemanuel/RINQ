package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rinq.models.User;

public interface UserRepository extends CrudRepository<User, String>{
	
	User findByLogin(String login);
}
