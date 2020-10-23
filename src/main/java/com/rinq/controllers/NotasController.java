package com.rinq.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Docente;
import com.rinq.models.Notas;
import com.rinq.repositories.DiscenteRepository;
import com.rinq.repositories.DisciplinaRepository;
import com.rinq.repositories.DocenteRepository;
import com.rinq.repositories.FaltaRepository;
import com.rinq.repositories.ProvaRepository;
import com.rinq.service.DTO.BoletimDTO;

@Controller
public class NotasController {
	
	@Autowired
	BoletimDTO boletimDTO;
	
	@Autowired
	DiscenteRepository discenteRepository;
	@Autowired
	DocenteRepository docenteRepository;
	@Autowired
	FaltaRepository faltaRespository;
	@Autowired
	DisciplinaRepository disciplinaRepository;
	@Autowired
	ProvaRepository provaRepository;

	@GetMapping("/boletim")
	public String showBoletim(Model model, Principal principal) {
		String login = principal.getName();
		
		if(discenteRepository.existsByLogin(login)) {
			Discente discente = discenteRepository.findByLogin(login);
			
			boletimDTO.initializeEntradasBoletim(discente);
			boletimDTO.setNomeDiscente(discente.getNome());
			boletimDTO.calculateCoeficienteRendimento();
			boletimDTO.calculateMediaDisciplinas();
			
			model.addAttribute("DTO", boletimDTO);
		}
		return "/boletim";
	}
	
	@GetMapping("/notas")
	public String redirectToDisciplineDiscentesList(Principal principal) {		
		Docente docente = docenteRepository.findByLogin(principal.getName());
		Disciplina disciplina = docente.getDisciplina();
		
		return String.format("redirect:/notas/%s", disciplina);
	}
	
	@GetMapping("/notas/{disciplina}")
	public String showDisciplineDiscentes(@PathVariable("disciplina") String nomeDisciplina, Model model) {
		Disciplina disciplina = disciplinaRepository.findByNome(nomeDisciplina);
		List<Discente> discentes = disciplina.getDiscentes();
		
		model.addAttribute("discentes", discentes);
		
		return "/alunos";
	}
	
	@GetMapping("/notas/{disciplina}/{matricula}")
	public String showDiscenteGrades(@PathVariable("disciplina") String nomeDisciplina, @PathVariable("matricula") String matricula, Model model) {
		Disciplina disciplina = disciplinaRepository.findByNome(nomeDisciplina);
		Discente discente = discenteRepository.findByMatricula(matricula);
		
		Notas notas = provaRepository.findByDiscenteAndDisciplina(discente, disciplina);	
		
		model.addAttribute("notas", notas);
		
		return "";
	}
	
	@PostMapping("/notas/{disciplina}/{matricula}")
	public String updateDiscenteGrades(Notas notas) {
		Discente discente = notas.getDiscente();
		discenteRepository.save(discente);
		
		return "redirect:/home";
	}
}
