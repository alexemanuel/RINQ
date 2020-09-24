package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rinq.models.Discente;

public interface DocenteRepository extends CrudRepository<Discente, String>{
	
	Discente findByCpf(String Cpf);
}
