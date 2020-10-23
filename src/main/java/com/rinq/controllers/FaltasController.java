package com.rinq.controllers;

import java.security.Principal;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rinq.models.Aula;
import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Docente;
import com.rinq.models.Falta;
import com.rinq.repositories.AulaRepository;
import com.rinq.repositories.DiscenteRepository;
import com.rinq.repositories.DisciplinaRepository;
import com.rinq.repositories.DocenteRepository;
import com.rinq.repositories.FaltaRepository;
import com.rinq.repositories.UsuarioRepository;
import com.rinq.service.DTO.AulaDTO;
import com.rinq.service.DTO.FaltaDTO;

@Controller
public class FaltasController {

	@Autowired
	AulaDTO aulaDTO;
	@Autowired
	FaltaDTO faltaDTO;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	DocenteRepository docenteRepository;
	@Autowired
	DiscenteRepository discenteRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;
	@Autowired
	AulaRepository aulaRepository;
	@Autowired
	FaltaRepository faltaRepository;
	
	@GetMapping("/chamada")
	public String showDiscenteList(Model model, Principal principal) {
		String cpf = principal.getName();
			
		if(docenteRepository.existsByCpf(cpf)){
			Docente docente = docenteRepository.findByCpf(cpf);
			Disciplina disciplina = docente.getDisciplina();
			
			List<Discente> discentes = disciplina.getDiscentes();			
			Collections.sort(discentes); // Sort discentes by name attribute
			
			Aula aula = new Aula();
			aula.setDisciplina(disciplina);
			aula.setDocente(docente);
			
			aulaDTO.setAula(aula);
			faltaDTO.initializeFaltaList(discentes, disciplina);
			
			model.addAttribute("discentes", discentes);
			model.addAttribute("faltasDTO", faltaDTO);
			model.addAttribute("aulaDTO", aulaDTO);
		}
		return "chamada";
	}
	
	@PostMapping("/chamada")
	public String absenceManage(AulaDTO aulaDTO, FaltaDTO faltaDTO) {
		List<Falta> faltas = faltaDTO.getFaltas();
		Aula aula = aulaDTO.getAula();
		
		// Set faltas in aula and aula in faltas
		faltas.forEach(falta -> falta.setAula(aula));
		aula.setFaltas(faltas);
		
		aulaRepository.save(aula);
		faltaRepository.saveAll(faltas);
		
		return "redirect:/home";
	}
}
