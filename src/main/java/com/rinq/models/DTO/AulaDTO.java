package com.rinq.models.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.rinq.models.Aula;


public class AulaDTO{
	
	private static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");	 
	private Aula aula;
	private String stringData;
		
	public AulaDTO() {}

	public AulaDTO(Aula aula){	
		this.aula = aula;
	}
	
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	public Aula getAula() {
		return aula;
	}

	public void setStringData(String stringData) throws ParseException {
		this.stringData = stringData;
		
		Date data = dateFormater.parse(stringData); // Convert String Date to Date Object
		aula.setData(data);
	}
	
	public String getStringData() {
		return stringData;
	}
}
