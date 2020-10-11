package com.rinq.repositories;

import com.rinq.models.Prova;
import org.springframework.data.repository.CrudRepository;


public interface ProvaRepository extends CrudRepository<Prova, Long> {

    Prova findByDiscente(String discente);
}