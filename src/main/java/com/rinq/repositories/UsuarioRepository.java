package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rinq.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findByCpf(String cpf);
	Usuario findByEmail(String email);
	
	boolean existsByCpf(String cpf);
	
	void removeByCpf(String cpf);
	
	
	 
}
