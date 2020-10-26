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
import com.rinq.repositories.NotasRepository;
import com.rinq.service.DTO.BoletimDTO;
import com.rinq.service.DTO.NotasDTO;
import com.rinq.service.DTO.NotasDTO;

@Controller
public class NotasController {
	
	@Autowired
	BoletimDTO boletimDTO;
	@Autowired
	NotasDTO notasDTO;
	
	@Autowired
	DiscenteRepository discenteRepository;
	@Autowired
	DocenteRepository docenteRepository;
	@Autowired
	FaltaRepository faltaRespository;
	@Autowired
	DisciplinaRepository disciplinaRepository;
	@Autowired
	NotasRepository notasRepository;

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
	public String showDisciplineDiscentes(Principal principal, Model model) {		
		Docente docente = docenteRepository.findByLogin(principal.getName());
		Disciplina disciplina = docente.getDisciplina();
		
		List<Discente> discentes = disciplina.getDiscentes();
		model.addAttribute("discentes", discentes);
		
		return "/alunos";
	}
	
	@GetMapping("/notas/{matricula}")
	public String showDiscenteGrades(@PathVariable("matricula") String matricula, Model model, Principal principal) {
		
		Discente discente = discenteRepository.findByMatricula(matricula);
		Docente docente = docenteRepository.findByLogin(principal.getName());
		Disciplina disciplina = docente.getDisciplina();

		Notas notas = notasRepository.findByDiscenteAndDisciplina(discente, disciplina);
		
		if(notas == null) {
			notas = new Notas(discente, disciplina);
		}
		
		notasDTO.initializeNotasDTO(notas);
		model.addAttribute("DTO", notasDTO);
		
		return "notas_discente";
	}
	
	@PostMapping("/notas/{matricula}")
	public String updateDiscenteGrades(NotasDTO DTO, Principal principal) {
		Discente discente = DTO.getDiscente();
		Disciplina disciplina = DTO.getDisciplina();

		notasRepository.deleteByDiscenteAndDisciplina(discente, disciplina);

		Notas notas = DTO.getNotas();
		notasRepository.save(notas);
		
		return "redirect:/home";
	}
}
