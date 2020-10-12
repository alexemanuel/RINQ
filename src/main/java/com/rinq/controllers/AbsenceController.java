package com.rinq.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rinq.models.Curso;
import com.rinq.models.Discente;
import com.rinq.models.Docente;
import com.rinq.repositories.DiscenteRepository;
import com.rinq.repositories.DocenteRepository;
import com.rinq.repositories.UsuarioRepository;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


@Controller
public class AbsenceController {

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	DocenteRepository docenteRepository;
	@Autowired
	DiscenteRepository discenteRepository;
	
	@GetMapping("/chamada")
	public String absenceVision(Model model, Principal principal) {
		String cpf = principal.getName();
		
		if(docenteRepository.existsByCpf(cpf)){
			Docente docente = docenteRepository.findByCpf(cpf);
			Curso course = docente.getCurso();
			
			
			
//			Aula2 aula  = new Aula2();
			
			List<Discente> students = discenteRepository.findByCursoOrderByNome(course);
			
//			model.addAttribute("aula", aula);
			model.addAttribute("students", students);
		}
		return "chamada";
	}
	
//	
//	@PostMapping("/chamada")
//	public String registerAbsences(Aula2 aula) throws ParseException {
//		System.out.println(aula.getData());
//		
//		Date date = new SimpleDateFormat("yyyy-MM-dd").parse(aula.getData());
//		System.out.println(date);
//		
//		return "redirect:/home";
//	}
}
