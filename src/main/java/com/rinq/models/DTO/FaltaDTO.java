package com.rinq.models.DTO;

import java.util.ArrayList;
import java.util.List;

import com.rinq.models.Discente;
import com.rinq.models.Falta;

public class FaltaDTO {
	
	private List<Falta> faltas = new ArrayList<Falta>();
	
	public FaltaDTO() {}

	public FaltaDTO(List<Discente> discentes) {
		initializeFaltaList(discentes);
	}
	
	public List<Falta> getFaltas() {
		return faltas;
	}

	public void setFaltas(List<Falta> faltas) {
		this.faltas = faltas;
	}
	
	public void addFalta(Falta falta) {
		faltas.add(falta);
	}
	
	private void initializeFaltaList(List<Discente> discentes) {
				
		for(Discente discente: discentes) {
			Falta falta = new Falta();
			falta.setDiscente(discente);
			
			faltas.add(falta);
		}
	}
}
