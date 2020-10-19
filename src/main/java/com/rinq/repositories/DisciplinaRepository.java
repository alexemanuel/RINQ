package com.rinq.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rinq.models.Curso;
import com.rinq.models.Disciplina;

@Repository
public interface DisciplinaRepository extends CrudRepository<Disciplina, Long> {
	
	Disciplina findByNome(String nome);
	
	List<Disciplina> findByCurso(Curso curso);
}
