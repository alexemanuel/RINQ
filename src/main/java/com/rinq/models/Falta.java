package com.rinq.models;

import javax.persistence.*;

@Entity
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "discente", referencedColumnName = "cpf")
    private Usuario discente;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @Column(nullable = true)
    private Integer quantidadeFalta;

    public Falta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getDiscente() {
        return discente;
    }

    public void setDiscente(Usuario discente) {
        this.discente = discente;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Integer getQuantidadeFalta() {
        return quantidadeFalta;
    }

    public void setQuantidadeFalta(Integer quantidadeFalta) {
        this.quantidadeFalta = quantidadeFalta;
    }
}
