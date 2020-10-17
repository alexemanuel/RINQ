package com.rinq.service.matricula;

import java.util.Calendar;

public class MatriculaGenerator {
	
	private static final String templateMatricula = "%d%sPL%04d";
	
	public static String generateMatricula(String course, int code) {
		int year = getYear();
		int semester = getSemester();
		
		return String.format(templateMatricula, year, semester, code);
	}
	
	private static int getYear() {
		return Calendar.getInstance().get(Calendar.YEAR);		
	}
	
	private static int getSemester() {
		return Calendar.getInstance().get(Calendar.MONTH) < 6 ? 1 : 2;
	}
}
