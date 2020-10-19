package com.rinq.models.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Prova;
import com.rinq.repositories.FaltaRepository;
import com.rinq.repositories.ProvaRepository;

@Service
public class BoletimDTO {

	@Autowired
	ProvaRepository provaRepository;
	@Autowired
	FaltaRepository faltaRepository;

	private List<EntradaBoletimDTO> entradasBoletim;
	private String nomeDiscente;

	public List<EntradaBoletimDTO> getEntradasBoletim() {
		return entradasBoletim;
	}

	public void setEntradasBoletimDTO(List<EntradaBoletimDTO> entradasBoletim) {
		this.entradasBoletim = entradasBoletim;
	}
	
	public String getNomeDiscente() {
		return nomeDiscente;
	}
	
	public void setNomeDiscente(String nomeDiscente) {
		this.nomeDiscente = nomeDiscente;
	}

	public void initializeEntradasBoletim(Discente discente) {
		entradasBoletim = new ArrayList<EntradaBoletimDTO>();
		List<Disciplina> disciplinas = discente.getDisciplinas();
				
		for(Disciplina disciplina: disciplinas) {
			
			String nota1 = "";
			String nota2 = "";
			String mediaFinal = "";
					
			Prova notas = provaRepository.findByDiscenteAndDisciplina(discente, disciplina);
			
			if(notas != null) {
				nota1 = (notas.getProva1() != null) ? Float.toString(notas.getProva1()) : "";
				nota2 = (notas.getProva2() != null) ? Float.toString(notas.getProva2()) : "";
				mediaFinal = (notas.getMediaFinal() != null) ? Float.toString(notas.getMediaFinal()) : "";
			}		
			
			int totalFaltas = faltaRepository.countByDiscenteAndDisciplina(discente, disciplina);
						
			EntradaBoletimDTO entradaBoletimDTO = new EntradaBoletimDTO(disciplina, nota1, nota2, mediaFinal, totalFaltas);			
			entradasBoletim.add(entradaBoletimDTO);				
		}
	}
}

class EntradaBoletimDTO {

	private Disciplina disciplina;
	private String nota1, nota2, mediaFinal;
	private int totalFaltas;

	public EntradaBoletimDTO(Disciplina disciplina, String nota1, String nota2, String mediaFinal, int totalFaltas) {
		this.disciplina = disciplina;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.mediaFinal = mediaFinal;
		this.totalFaltas = totalFaltas;
	}

	public int getTotalFaltas() {
		return totalFaltas;
	}

	public void setTotalFaltas(int totalFaltas) {
		this.totalFaltas = totalFaltas;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public String getNota1() {
		return nota1;
	}

	public void setNota1(String nota1) {
		this.nota1 = nota1;
	}

	public String getNota2() {
		return nota2;
	}

	public void setNota2(String nota2) {
		this.nota2 = nota2;
	}

	public String getMediaFinal() {
		return mediaFinal;
	}

	public void setMediaFinal(String mediaFinal) {
		this.mediaFinal = mediaFinal;
	}
}
