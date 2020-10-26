package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Notas;

@Repository
public interface ProvaRepository extends CrudRepository<Notas, Long> {
    
    Notas findByDiscenteAndDisciplina(Discente discente, Disciplina disciplina);
}