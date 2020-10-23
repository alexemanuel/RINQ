package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Prova;

@Repository
public interface ProvaRepository extends CrudRepository<Prova, Long> {
    
    Prova findByDiscenteAndDisciplina(Discente discente, Disciplina disciplina);
}