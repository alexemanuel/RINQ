package com.rinq.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCurso;
    private String nameCurso;
    private String turno;

    public Curso() {}

    public Curso(DataTransferObject DTO){
        this.nameCurso = DTO.getNameCurso();
        this.turno = DTO.getTurno();
    }

    public Long getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(Long idCurso) {
        this.idCurso = idCurso;
    }

    public String getNameCurso() {
        return nameCurso;
    }

    public void setNameCurso(String name) {
        this.nameCurso = nameCurso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }
}
