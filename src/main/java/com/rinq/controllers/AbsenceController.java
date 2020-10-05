package com.rinq.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rinq.models.Curso;
import com.rinq.models.Discente;
import com.rinq.models.Docente;
import com.rinq.repositories.DiscenteRepository;
import com.rinq.repositories.DocenteRepository;
import com.rinq.repositories.UsuarioRepository;

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
			
			List<Discente> students = discenteRepository.findAllByCurso(course);
			model.addAttribute("students", students);
		}
		return "chamada";
	}
}
