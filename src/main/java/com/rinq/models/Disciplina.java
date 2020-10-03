package com.rinq.models;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "Curso_Disciplina")
@IdClass(DisciplinaCursoId.class)
public class Disciplina {

    @Id
    private Long idCurso;
    @Id
    private Long idDisciplina;
    private String nameDisciplina;
    private int cargaHoraria;

    public Disciplina() {}

    public Disciplina(DataTransferObject DTO){
        this.cargaHoraria = DTO.getCargaHoraria();
        this.nameDisciplina = DTO.getNameDisciplina();
    }

}
