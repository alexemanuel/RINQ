package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rinq.models.Usuario;

@Repository
public interface UsuarioRepository extends CrudRepository<Usuario, String>{
	
	Usuario findByCpf(String cpf);
	
	Usuario findByEmail(String email);
	
	boolean existsByCpf(String cpf);
}
