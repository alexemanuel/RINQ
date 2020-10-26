package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rinq.models.Curso;

@Repository
public interface CursoRepository extends CrudRepository<Curso, Long> {
	
	Curso findByNome(String nome);
	
	Curso findByAbreviacao(String abreviacao);
}
