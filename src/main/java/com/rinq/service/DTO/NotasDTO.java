package com.rinq.service.DTO;

import org.springframework.stereotype.Service;

import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Notas;

@Service
public class NotasDTO {
	
	private Discente discente;
	private Disciplina disciplina;
			
    private String prova1Semestre1;
    private String prova2Semestre1;
    private String recuperacaoSemestre1;
    private String mediaSemestre1;	
    private String prova1Semestre2;
    private String prova2Semestre2;
    private String recuperacaoSemestre2;
    private String mediaSemestre2;
    
    private String mediaFinal;
    
    public void initializeNotasDTO(Notas notas) {
    	this.discente = notas.getDiscente();
    	this.disciplina = notas.getDisciplina();
    	
    	this.setProva1Semestre1(String.valueOf(notas.getProva1Semestre1()));
    	this.setProva2Semestre1(String.valueOf(notas.getProva2Semestre1()));
    	this.setRecuperacaoSemestre1(String.valueOf(notas.getRecuperacaoSemestre1()));
    	this.setMediaSemestre1(String.valueOf(notas.getMediaSemestre1()));
    	
    	this.setProva1Semestre2(String.valueOf(notas.getProva1Semestre2()));
    	this.setProva2Semestre2(String.valueOf(notas.getProva2Semestre2()));
    	this.setRecuperacaoSemestre2(String.valueOf(notas.getRecuperacaoSemestre2()));
    	this.setMediaSemestre2(String.valueOf(notas.getMediaSemestre2()));
    	
    	this.setMediaFinal(String.valueOf(notas.getMediaFinal()));
    }
    
	public String getProva1Semestre1() {
		return (prova1Semestre1 == null) ? "" : prova1Semestre1;
	}	
	
	public void setProva1Semestre1(String prova1Semestre1) {
		this.prova1Semestre1 = (prova1Semestre1.equals("null") || prova1Semestre1.isBlank()) ? null : prova1Semestre1;
	}
	
	public String getProva2Semestre1() {
		return (prova2Semestre1 == null) ? "" : prova2Semestre1;	
	}
	
	public void setProva2Semestre1(String prova2Semestre1) {
		this.prova2Semestre1 = (prova2Semestre1.equals("null") || prova2Semestre1.isBlank()) ? null : prova2Semestre1;
	}
	
	public String getRecuperacaoSemestre1() {
		return (recuperacaoSemestre1 == null) ? "" : recuperacaoSemestre1;	
	}
	
	public void setRecuperacaoSemestre1(String recuperacaoSemestre1) {
		this.recuperacaoSemestre1 = (recuperacaoSemestre1.equals("null") || recuperacaoSemestre1.isBlank()) ? null : recuperacaoSemestre1;
	}
	
	public String getMediaSemestre1() {
		return (mediaSemestre1 == null) ? "" : mediaSemestre1; 	
	}
	
	public void setMediaSemestre1(String mediaSemestre1) {
		this.mediaSemestre1 = (mediaSemestre1.equals("null") || mediaSemestre1.isBlank()) ? null : mediaSemestre1;
	}
	
	public String getProva1Semestre2() {
		return (prova1Semestre2 == null) ? "" : prova1Semestre2;
	}	
	
	public void setProva1Semestre2(String prova1Semestre2) {
		this.prova1Semestre2 = (prova1Semestre2.equals("null") || prova1Semestre2.isBlank()) ? null : prova1Semestre2;
	}
	
	public String getProva2Semestre2() {
		return (prova2Semestre2 == null) ? "" : prova2Semestre2;	
	}
	
	public void setProva2Semestre2(String prova2Semestre2) {
		this.prova2Semestre2 = (prova2Semestre2.equals("null") || prova2Semestre2.isBlank()) ? null : prova2Semestre2;
	}
	
	public String getRecuperacaoSemestre2() {
		return (recuperacaoSemestre2 == null) ? "" : recuperacaoSemestre2;	
	}
	
	public void setRecuperacaoSemestre2(String recuperacaoSemestre2) {
		this.recuperacaoSemestre2 = (recuperacaoSemestre2.equals("null") || recuperacaoSemestre2.isBlank()) ? null : recuperacaoSemestre2;
	}
	
	public String getMediaSemestre2() {
		return (mediaSemestre2 == null) ? "" : mediaSemestre2; 	
	}
	
	public void setMediaSemestre2(String mediaSemestre2) {
		this.mediaSemestre2 = (mediaSemestre2.equals("null") || mediaSemestre2.isBlank()) ? null : mediaSemestre2;
	}
	
	public String getMediaFinal() {
		return (mediaFinal == null) ? "" : mediaFinal; 	
	}

	public void setMediaFinal(String mediaFinal) {
		this.mediaFinal = (mediaFinal.equals("null") || mediaFinal.isBlank()) ? null : mediaFinal;
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
	
	public Notas getNotas() {
		Notas notas = new Notas(discente, disciplina);
		 
		if(prova1Semestre1 != null) {notas.setProva1Semestre1(Float.valueOf(prova1Semestre1));}
		if(prova2Semestre1 != null) {notas.setProva2Semestre1(Float.valueOf(prova2Semestre1));}
		if(recuperacaoSemestre1 != null) {notas.setRecuperacaoSemestre1(Float.valueOf(recuperacaoSemestre1));}
		if(mediaSemestre1 != null) {notas.setMediaSemestre1(Float.valueOf(mediaSemestre1));}
		
		if(prova1Semestre2 != null) {notas.setProva1Semestre2(Float.valueOf(prova1Semestre2));}
		if(prova2Semestre2 != null) {notas.setProva2Semestre2(Float.valueOf(prova2Semestre2));}
		if(recuperacaoSemestre2 != null) {notas.setRecuperacaoSemestre2(Float.valueOf(recuperacaoSemestre2));}
		if(mediaSemestre2 != null) {notas.setMediaSemestre2(Float.valueOf(mediaSemestre2));}
		
		if(mediaFinal != null) {notas.setMediaFinal(Float.valueOf(mediaFinal));}
		
		return notas;
	}
}