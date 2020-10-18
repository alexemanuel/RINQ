package com.rinq.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.rinq.models.Aula;
import com.rinq.models.Curso;
import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Docente;
import com.rinq.models.Falta;
import com.rinq.models.DTO.AulaDTO;
import com.rinq.models.DTO.FaltaDTO;
import com.rinq.repositories.AulaRepository;
import com.rinq.repositories.DiscenteRepository;
import com.rinq.repositories.DisciplinaRepository;
import com.rinq.repositories.DocenteRepository;
import com.rinq.repositories.FaltaRepository;
import com.rinq.repositories.UsuarioRepository;


@Controller
public class FaltasController {

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
			Curso curso = docente.getCurso();	
			Disciplina disciplina = disciplinaRepository.findByNome(docente.getDisciplina());
			
			Aula aula = new Aula();
			aula.setDisciplina(disciplina);
			aula.setDocente(docente);
			
			List<Discente> discentes = discenteRepository.findByCursoOrderByNome(curso);
			
			AulaDTO aulaDTO = new AulaDTO(aula);			
			FaltaDTO faltaDTO = new FaltaDTO(discentes);
			
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
				
		faltas.forEach(falta -> falta.setAula(aula));
		aula.setFaltas(faltas);
		
		aulaRepository.save(aula);
		faltaRepository.saveAll(faltas);
		
		return "redirect:/home";
	}
}
