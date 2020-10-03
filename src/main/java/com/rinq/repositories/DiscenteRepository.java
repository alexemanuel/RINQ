package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rinq.models.Docente;

public interface DiscenteRepository extends CrudRepository<Docente, String>{
	
	Docente findByCpf(String cpf);
}
