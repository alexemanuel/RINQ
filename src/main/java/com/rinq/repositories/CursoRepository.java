package com.rinq.repositories;

import org.springframework.data.repository.CrudRepository;

import com.rinq.models.Curso;

public interface CursoRepository extends CrudRepository<Curso, String> {

    Curso findByIdCurso(Long idCurso);

    boolean existsByIdCurso(Long idCurso);
}
