package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Notas;

@Repository
public interface NotasRepository extends CrudRepository<Notas, Long> {
    
    Notas findByDiscenteAndDisciplina(Discente discente, Disciplina disciplina);
    
	@Transactional
	void deleteByDiscenteAndDisciplina(Discente discente, Disciplina disciplina);
}