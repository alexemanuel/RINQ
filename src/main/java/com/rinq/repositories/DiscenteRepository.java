package com.rinq.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rinq.models.Curso;
import com.rinq.models.Discente;

@Repository
public interface DiscenteRepository extends CrudRepository<Discente, String>{
	
	Discente findByCpf(String cpf);
	
	Discente findByLogin(String login);
	
	Discente findByMatricula(String String);
	
	boolean existsByCpf(String cpf);
	
	boolean existsByLogin(String login);
	
	List<Discente> findByCursoOrderByNome(Curso curso);
		
	int countByCurso(Curso curso);
}
