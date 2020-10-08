package com.rinq.models;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Set;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Calendar data;
    
    private String assunto;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "siape", referencedColumnName = "siape")
    private Docente siape;
    
    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    @OneToMany(mappedBy = "aula", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Falta> faltas;

    public Aula() {}

    public Aula(DataTransferObject DTO) {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
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

    public Set<Falta> getFaltas() {
        return faltas;
    }

    public void setFaltas(Set<Falta> faltas) {
        this.faltas = faltas;
    }
}
