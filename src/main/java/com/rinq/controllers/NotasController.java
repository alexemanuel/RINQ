package com.rinq.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.rinq.models.Discente;
import com.rinq.repositories.DiscenteRepository;
import com.rinq.repositories.FaltaRepository;
import com.rinq.service.DTO.BoletimDTO;

@Controller
public class NotasController {
	
	@Autowired
	BoletimDTO boletimDTO;
	
	@Autowired
	DiscenteRepository discenteRepository;
	@Autowired
	FaltaRepository faltaRespository;
	
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
}
