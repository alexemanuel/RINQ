package com.rinq.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.rinq.repositories.UserRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		UserDetails user = userRepository.findByLogin(login);
		
		if(user == null) {
			throw new UsernameNotFoundException("User does not exist!");
		}
		return user; 	
	}
}
