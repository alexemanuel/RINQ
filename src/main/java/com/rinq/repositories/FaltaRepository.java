package com.rinq.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Falta;

@Repository
public interface FaltaRepository extends CrudRepository<Falta, Long> {

    List<Falta> findByDiscente(Discente discente);
    
    int countByDiscenteAndDisciplina(Discente discente, Disciplina disciplina);
}