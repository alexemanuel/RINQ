package com.rinq.service.DTO;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.rinq.models.Aula;

@Service
public class AulaDTO{
	
	private static final SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd");	 
	private Aula aula;
	private String stringData;
			
	public void setAula(Aula aula) {
		this.aula = aula;
	}
	
	public Aula getAula() {
		return aula;
	}

	public void setStringData(String stringData) throws ParseException {
		this.stringData = stringData;
		
		// Convert String Date to Date Object
		Date data = dateFormater.parse(stringData); 
		aula.setData(data);
	}
	
	public String getStringData() {
		return stringData;
	}
}
