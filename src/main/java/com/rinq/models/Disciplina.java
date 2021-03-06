package com.rinq.models;

import java.util.Collections;
import java.util.List;

import javax.persistence.*;

@Entity
public class Disciplina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 100)
    private String nome;
    @Column(nullable = false)
    private int cargaHoraria;

    @ManyToOne
    @JoinColumn(name = "id_curso")
    private Curso curso;

    @OneToOne(mappedBy = "disciplina", targetEntity = Docente.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Docente docente;

    @ManyToMany
    @JoinTable(name = "discente_disciplina", 
    		   joinColumns = {@JoinColumn(name = "id_disciplina")}, 
    		   inverseJoinColumns = {@JoinColumn(name = "cpf_discente")})
    private List<Discente> discentes;

    @OneToMany(mappedBy = "disciplina", targetEntity = Aula.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Aula> aulas;

    @OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Notas> provas;

    public Disciplina() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public List<Notas> getProvas() {
        return provas;
    }

    public void setProvas(List<Notas> provas) {
        this.provas = provas;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Discente> getDiscentes() {
        Collections.sort(discentes); // Sort discentes by name attribute
        return discentes;
    }

    public void setDiscentes(List<Discente> discentes) {
        this.discentes = discentes;
    }

    public void addAula(Aula aula){
        this.aulas.add(aula);
        aula.setDisciplina(this);
    }

    public void removeAula(Aula aula){
        this.aulas.remove(aula);
        aula.setDisciplina(null);
    }
    
    public void addDiscente(Discente discente) {
    	this.discentes.add(discente);
    }
    
    @Override
    public String toString() {
    	return nome;
    }
}
