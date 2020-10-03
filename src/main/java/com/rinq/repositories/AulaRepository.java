package com.rinq.repositories;

import com.rinq.models.Aula;
import org.springframework.data.repository.CrudRepository;

public interface AulaRepository extends CrudRepository<Aula, Long> {

    Aula findByIdAula(Long idAula);

    boolean existsByIdAula(Long idAula);
}