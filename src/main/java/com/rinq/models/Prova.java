package com.rinq.models;

import javax.persistence.*;

@Entity
public class Prova {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = true)
    private Float prova1;
    @Column(nullable = true)
    private Float recuperacao1;
    @Column(nullable = true)
    private Float prova2;
    @Column(nullable = true)
    private Float recuperacao2;
    @Column(nullable = true)
    private Float media;
    @Column(nullable = true)
    private Float recuperacaoFinal;

    @ManyToOne
    @JoinColumn(name = "discente", referencedColumnName = "cpf")
    private Usuario discente;

    @ManyToOne
    @JoinColumn(name = "disciplina")
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

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public Float getRecuperacaoFinal() {
        return recuperacaoFinal;
    }

    public void setRecuperacaoFinal(Float recuperacaoFinal) {
        this.recuperacaoFinal = recuperacaoFinal;
    }

    public Usuario getDiscente() {
        return discente;
    }

    public void setDiscente(Usuario discente) {
        this.discente = discente;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
}
