package com.rinq.models;

import javax.persistence.*;

@Entity
public class Falta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "matricula_discente", referencedColumnName = "matricula")
    private Discente discente;

    @ManyToOne
    @JoinColumn(name = "id_aula")
    private Aula aula;

    @Column(nullable = true)
    private Integer quantidadeFaltas;

    public Falta() {}
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Discente getDiscente() {
        return discente;
    }

    public void setDiscente(Discente discente) {
        this.discente = discente;
    }

    public Aula getAula() {
        return aula;
    }

    public void setAula(Aula aula) {
        this.aula = aula;
    }

    public Integer getQuantidadeFaltas() {
        return quantidadeFaltas;
    }

    public void setQuantidadeFaltas(Integer quantidadeFaltas) {
        this.quantidadeFaltas = quantidadeFaltas;
    }
}
