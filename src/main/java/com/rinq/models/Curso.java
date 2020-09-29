package com.rinq.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Curso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idCurso;
    private String nameCurso;
    private String turno;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_Curso")
    private List<Disciplina> disciplinas = new ArrayList<>();

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
