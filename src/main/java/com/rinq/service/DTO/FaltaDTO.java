package com.rinq.service.DTO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Falta;

@Service
public class FaltaDTO {
	
	private List<Falta> faltas;
	
	public List<Falta> getFaltas() {
		return faltas;
	}

	public void setFaltas(List<Falta> faltas) {
		this.faltas = faltas;
	}
	
	public void addFalta(Falta falta) {
		faltas.add(falta);
	}
	
	public void initializeFaltaList(List<Discente> discentes, Disciplina disciplina) {
		faltas = new ArrayList<Falta>();
		
		for(Discente discente: discentes) {
			Falta falta = new Falta();
			
			falta.setDiscente(discente);
			falta.setDisciplina(disciplina);
			
			faltas.add(falta);
		}
	}
}
