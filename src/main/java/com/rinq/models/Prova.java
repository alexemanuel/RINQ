package com.rinq.models;

import javax.persistence.*;

@Entity
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float prova1;
    private Float recuperacao1;
    private Float prova2;
    private Float recuperacao2;
    private Float mediaFinal;
    private Float recuperacaoFinal;

    @ManyToOne
    @JoinColumn(name = "matricula_discente", referencedColumnName = "matricula")
    private Discente discente;

    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    public Prova() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getProva1() {
        return prova1;
    }

    public void setProva1(Float prova1) {
        this.prova1 = prova1;
    }

    public Float getRecuperacao1() {
        return recuperacao1;
    }

    public void setRecuperacao1(Float recuperacao1) {
        this.recuperacao1 = recuperacao1;
    }

    public Float getProva2() {
        return prova2;
    }

    public void setProva2(Float prova2) {
        this.prova2 = prova2;
    }

    public Float getRecuperacao2() {
        return recuperacao2;
    }

    public void setRecuperacao2(Float recuperacao2) {
        this.recuperacao2 = recuperacao2;
    }

    public Float getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(Float mediaFinal) {
        this.mediaFinal = mediaFinal;
    }

    public Float getRecuperacaoFinal() {
        return recuperacaoFinal;
    }

    public void setRecuperacaoFinal(Float recuperacaoFinal) {
        this.recuperacaoFinal = recuperacaoFinal;
    }

    public Discente getDiscente() {
        return discente;
    }

    public void setDiscente(Discente discente) {
        this.discente = discente;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
