package com.rinq.models;

import javax.persistence.*;
import java.util.Calendar;

@Entity
public class Aula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAula;
    @Temporal(TemporalType.DATE)
    private Calendar dataAula;
    private String assunto;
    private Integer quantidade;

    @ManyToOne
    @JoinColumn(name = "siape")
    private Docente siape;

    @ManyToOne
    @JoinColumn(name = "disciplina_id")
    private Disciplina disciplina;

    public Aula() {}

    public Aula(DataTransferObject DTO) {}

    public Long getIdAula() {
        return idAula;
    }

    public void setIdAula(Long idAula) {
        this.idAula = idAula;
    }

    public Calendar getDataAula() {
        return dataAula;
    }

    public void setDataAula(Calendar dataAula) {
        this.dataAula = dataAula;
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

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

    public void setSiape(Docente siape) {
        this.siape = siape;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
}
