package com.rinq.service.matricula;

import java.util.Calendar;

public class MatriculaGenerator {
	
	private static final String templateMatricula = "%d%sPL%04d";
	
	public static String generateMatricula(String course, int semester, int code) {
		int year = Calendar.getInstance().get(Calendar.YEAR);		
		return String.format(templateMatricula, year, semester, code);
	}
}
