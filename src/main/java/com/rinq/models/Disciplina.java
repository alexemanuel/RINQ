package com.rinq.models;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private int cargaHoraria;

    @ManyToOne
    private Curso curso;

    @OneToMany(mappedBy = "disciplina", targetEntity = Aula.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Aula> aulas;

    @OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Prova> provas;

    public Disciplina() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public List<Aula> getAulas() {
        return aulas;
    }

    public void setAulas(List<Aula> aulas) {
        this.aulas = aulas;
    }

    public Set<Prova> getProvas() {
        return provas;
    }

    public void setProvas(Set<Prova> provas) {
        this.provas = provas;
    }

    public void addAula(Aula aula){
        this.aulas.add(aula);
        aula.setDisciplina(this);
    }

    public void removeAula(Aula aula){
        this.aulas.remove(aula);
        aula.setDisciplina(null);
    }
}
