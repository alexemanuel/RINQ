package com.rinq.repositories;

import com.rinq.models.Falta;
import org.springframework.data.repository.CrudRepository;


public interface FaltaRepository extends CrudRepository<Falta, Long> {

    Falta findByDiscente(String discente);
}