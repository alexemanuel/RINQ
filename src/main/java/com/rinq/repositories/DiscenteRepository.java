package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rinq.models.Discente;

public interface DiscenteRepository extends CrudRepository<Discente, String>{
	
	Discente findByCpf(String cpf);
}
