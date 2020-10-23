package com.rinq.models;

import java.util.Date;
import java.util.List;

import javax.persistence.*;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date data;

    private String observacao;
    @Column(nullable = false)
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "siape_docente", referencedColumnName = "siape")
    private Docente docente;
    
    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    @OneToMany(mappedBy = "aula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Falta> faltas;

    public Aula() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }
    
    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public List<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(List<Falta> faltas) {
        this.faltas = faltas;
    }
}
