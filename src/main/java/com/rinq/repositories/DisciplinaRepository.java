package com.rinq.repositories;

import com.rinq.models.Disciplina;
import com.rinq.models.DisciplinaCursoId;
import org.springframework.data.repository.CrudRepository;

public interface DisciplinaRepository extends CrudRepository<Disciplina, DisciplinaCursoId> {

    Disciplina findByIdDisciplina(Long idDisciplina);

    boolean existsByIdDisciplina(Long idDisciplina);
}
