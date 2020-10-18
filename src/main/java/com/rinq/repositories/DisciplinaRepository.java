package com.rinq.repositories;

import com.rinq.models.Disciplina;

import org.springframework.data.repository.CrudRepository;

public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
	
	Disciplina findByNome(String nome);
}
