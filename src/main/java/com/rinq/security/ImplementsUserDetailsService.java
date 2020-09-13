package com.rinq.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.rinq.models.UserDetailsImpl;
import com.rinq.models.Usuario;
import com.rinq.repositories.UsuarioRepository;

@Repository
public class ImplementsUserDetailsService implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String cpf) throws UsernameNotFoundException {
		Usuario user = usuarioRepository.findByCpf(cpf);
		
		if(user == null) {
			throw new UsernameNotFoundException("User does not exist!");
		}
		return new UserDetailsImpl(user);
	}
}
