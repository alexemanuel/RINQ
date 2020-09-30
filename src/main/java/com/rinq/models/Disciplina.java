package com.rinq.models;

import javax.persistence.*;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDisciplina;
    private String nameDisciplina;
    private int cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "curso_id")
    private Curso curso;

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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
}
