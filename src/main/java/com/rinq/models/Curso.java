package com.rinq.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCurso;
    private String nameCurso;
    private String turno;
    @OneToMany(mappedBy = "curso", targetEntity = Disciplina.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Disciplina> disciplinas;

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

    public void setNameCurso(String nameCurso) {
        this.nameCurso = nameCurso;
    }

    public String getTurno() {
        return turno;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    public List<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(List<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
