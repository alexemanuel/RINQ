package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rinq.models.Administrador;

public interface AdministradorRepository extends CrudRepository<Administrador, String>{
	
	Administrador findByCpf(String cpf);
}
