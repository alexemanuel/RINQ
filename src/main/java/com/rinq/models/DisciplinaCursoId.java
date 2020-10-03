package com.rinq.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class DisciplinaCursoId implements Serializable {

    private Long idCurso;
    private Long idDisciplina;
}
