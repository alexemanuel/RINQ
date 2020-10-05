package com.rinq.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.rinq.models.Curso;
import com.rinq.models.Discente;

public interface DiscenteRepository extends CrudRepository<Discente, String>{
	
	Discente findByCpf(String cpf);
	
	List<Discente> findAllByCurso(Curso curso);	
}
