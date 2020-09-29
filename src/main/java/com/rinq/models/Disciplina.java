package com.rinq.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Disciplina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idDisciplina;
    private String nameDisciplina;
    private int cargaHoraria;

    public Disciplina() {}

    public Disciplina(DataTransferObject DTO){
        this.cargaHoraria = DTO.getCargaHoraria();
        this.nameDisciplina = DTO.getNameDisciplina();
    }

    public Long getIdDisciplina() {
        return idDisciplina;
    }

    public void setIdDisciplina(Long idDisciplina) {
        this.idDisciplina = idDisciplina;
    }

    public String getNameDisciplina() {
        return nameDisciplina;
    }

    public void setNameDisciplina(String nameDisciplina) {
        this.nameDisciplina = nameDisciplina;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
