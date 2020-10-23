package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rinq.models.Administrador;

@Repository
public interface AdministradorRepository extends CrudRepository<Administrador, String>{
	
	Administrador findByCpf(String cpf);
}
