package com.rinq.service.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Falta;
import com.rinq.models.Notas;
import com.rinq.repositories.FaltaRepository;
import com.rinq.repositories.NotasRepository;

@Service
public class BoletimDTO {

	@Autowired
	NotasRepository provaRepository;
	@Autowired
	FaltaRepository faltaRepository;

	private List<EntradaBoletimDTO> entradasBoletim;
	private String nomeDiscente;
	private float mediaDisciplinas;
	private float rendimentoGlobal;
	private float coeficienteRendimento;
	
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

	public float getMediaDisciplinas() {
		return mediaDisciplinas;
	}

	public void setMediaDisciplinas(float mediaDisciplinas) {
		this.mediaDisciplinas = mediaDisciplinas;
	}

	public float getCoeficienteRendimento() {
		return coeficienteRendimento;
	}

	public void setCoeficienteRendimento(float coeficienteRendimento) {
		this.coeficienteRendimento = coeficienteRendimento;
	}

	public float getRendimentoGlobal() {
		return rendimentoGlobal;
	}

	public void setRendimentoGlobal(float rendimentoGlobal) {
		this.rendimentoGlobal = rendimentoGlobal;
	}
	
	public void initializeEntradasBoletim(Discente discente) {
		entradasBoletim = new ArrayList<EntradaBoletimDTO>();
		List<Disciplina> disciplinas = discente.getDisciplinas();
				
		for(Disciplina disciplina: disciplinas) {
			String nomeDisciplina = disciplina.getNome();
			int cargaHorariaDisciplina = disciplina.getCargaHoraria();
			
			String nota1 = "";
			String nota2 = "";
			String mediaFinal = "";
					
			Notas notas = provaRepository.findByDiscenteAndDisciplina(discente, disciplina);
			
			if(notas != null) {
				nota1 = (notas.getMediaSemestre1() != null) ? Float.toString(notas.getMediaSemestre1()) : "";
				nota2 = (notas.getMediaSemestre2() != null) ? Float.toString(notas.getMediaSemestre2()) : "";
				mediaFinal = (notas.getMediaFinal() != null) ? Float.toString(notas.getMediaFinal()) : "";
			}
						
			List<Falta> faltas = faltaRepository.findByDiscenteAndDisciplina(discente, disciplina);
			int totalFaltas = countTotalFaltas(faltas);
						
			EntradaBoletimDTO entradaBoletim = new EntradaBoletimDTO(nomeDisciplina, cargaHorariaDisciplina, nota1, nota2, mediaFinal, totalFaltas);			
			entradasBoletim.add(entradaBoletim);				
		}
	}
	
	public void calculateMediaDisciplinas() {
		
		float mediaDisciplinas = 0;
		float numMediasAvaliable = 0;
		int sumMedias = 0;
		
		for(EntradaBoletimDTO entradaBoletim : entradasBoletim) {	
			String mediaFinal = entradaBoletim.getMediaFinal();
			
			if(mediaFinal != "") {
				sumMedias += Float.parseFloat(mediaFinal);
				numMediasAvaliable ++;
			}
		}	
		if(numMediasAvaliable > 0) {
			mediaDisciplinas = sumMedias / numMediasAvaliable;
		}
		
		setMediaDisciplinas(mediaDisciplinas);
	}
	
	public void calculateCoeficienteRendimento() {
		
		float coeficienteRendimento = 0;
		float sumProdMediaCargaHoraria = 0;
		int sumCargaHorarias = 0;
		
		for(EntradaBoletimDTO entradaBoletim: entradasBoletim) {
			String mediaFinal = entradaBoletim.getMediaFinal();
			
			if(mediaFinal != "") {
				sumProdMediaCargaHoraria += Float.parseFloat(mediaFinal) * entradaBoletim.getCargaHorariaDisciplina();
				sumCargaHorarias += entradaBoletim.getCargaHorariaDisciplina();
			}
		}	
		if(sumProdMediaCargaHoraria > 0) {
			coeficienteRendimento = sumProdMediaCargaHoraria / sumCargaHorarias;
		}
		
		setCoeficienteRendimento(coeficienteRendimento);
	}
	
	private int countTotalFaltas(List<Falta> faltas) {
		int totalFaltas = 0;
		
		for(Falta falta: faltas) {
			totalFaltas += falta.getQuantidadeFaltas();
		}
		return totalFaltas;
	}
}


class EntradaBoletimDTO {

	private String nomeDisciplina;
	private int cargaHorariaDisciplina;
	private String nota1, nota2, mediaFinal;
	private int totalFaltas;

	public EntradaBoletimDTO(String nomeDisciplina, int cargaHorariaDisciplina, String nota1, String nota2, String mediaFinal, int totalFaltas) {
		this.nomeDisciplina = nomeDisciplina;
		this.cargaHorariaDisciplina = cargaHorariaDisciplina;
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

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public int getCargaHorariaDisciplina() {
		return cargaHorariaDisciplina;
	}

	public void setCargaHorariaDisciplina(int cargaHorariaDisciplina) {
		this.cargaHorariaDisciplina = cargaHorariaDisciplina;
	}
}
