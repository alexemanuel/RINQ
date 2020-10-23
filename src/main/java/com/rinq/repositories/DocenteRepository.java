package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rinq.models.Docente;

@Repository
public interface DocenteRepository extends CrudRepository<Docente, String>{
	
	Docente findByCpf(String cpf);
	
	Docente findByLogin(String login);
	
	boolean existsByCpf(String cpf);
	
	boolean existsByLogin(String login);
	
}
