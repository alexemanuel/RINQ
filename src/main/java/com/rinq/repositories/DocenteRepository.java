package com.rinq.repositories;


import org.springframework.data.repository.CrudRepository;

import com.rinq.models.Docente;

public interface DocenteRepository extends CrudRepository<Docente, String>{
	
	Docente findByCpf(String cpf);
	
	boolean existsByCpf(String cpf);
	
}
