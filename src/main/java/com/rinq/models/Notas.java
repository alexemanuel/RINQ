package com.rinq.models;

import javax.persistence.*;

@Entity
public class Notas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Float prova1Semestre1;
    private Float prova2Semestre1;
    private Float recuperacaoSemestre1;
    private Float mediaSemestre1;
    private Float prova1Semestre2;
    private Float prova2Semestre2;
    private Float mediaSemestre2;
    private Float recuperacaoSemestre2;
    private Float mediaFinal;

    @ManyToOne
    @JoinColumn(name = "matricula_discente", referencedColumnName = "matricula")
    private Discente discente;

    @ManyToOne
    @JoinColumn(name = "id_disciplina")
    private Disciplina disciplina;

    public Notas() {}
    
    public Notas(Discente discente, Disciplina disciplina) {
    	this.discente = discente;
    	this.disciplina = disciplina;
    }

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

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }

	public Float getProva1Semestre1() {
		return prova1Semestre1;
	}

	public void setProva1Semestre1(Float prova1Semestre1) {
		this.prova1Semestre1 = prova1Semestre1;
	}

	public Float getProva2Semestre1() {
		return prova2Semestre1;
	}

	public void setProva2Semestre1(Float prova2Semestre1) {
		this.prova2Semestre1 = prova2Semestre1;
	}

	public Float getRecuperacaoSemestre1() {
		return recuperacaoSemestre1;
	}

	public void setRecuperacaoSemestre1(Float recuperacaoSemestre1) {
		this.recuperacaoSemestre1 = recuperacaoSemestre1;
	}
	
	public Float getProva1Semestre2() {
		return prova1Semestre2;
	}

	public void setProva1Semestre2(Float prova1Semestre2) {
		this.prova1Semestre2 = prova1Semestre2;
	}

	public Float getProva2Semestre2() {
		return prova2Semestre2;
	}

	public void setProva2Semestre2(Float prova2Semestre2) {
		this.prova2Semestre2 = prova2Semestre2;
	}

	public Float getRecuperacaoSemestre2() {
		return recuperacaoSemestre2;
	}

	public void setRecuperacaoSemestre2(Float recuperacaoSemestre2) {
		this.recuperacaoSemestre2 = recuperacaoSemestre2;
	}

	public Float getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(Float mediaFinal) {
		this.mediaFinal = mediaFinal;
	}

	public Float getMediaSemestre1() {
		return mediaSemestre1;
	}

	public void setMediaSemestre1(Float mediaSemestre1) {
		this.mediaSemestre1 = mediaSemestre1;
	}

	public Float getMediaSemestre2() {
		return mediaSemestre2;
	}

	public void setMediaSemestre2(Float mediaSemestre2) {
		this.mediaSemestre2 = mediaSemestre2;
	}
}
