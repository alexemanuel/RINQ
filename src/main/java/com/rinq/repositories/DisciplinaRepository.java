package com.rinq.repositories;

import com.rinq.models.Disciplina;

import org.springframework.data.repository.CrudRepository;

public interface DisciplinaRepository extends CrudRepository<Disciplina, String> {

    Disciplina findByIdDisciplina(Long idDisciplina);

    boolean existsByIdDisciplina(Long idDisciplina);
}
