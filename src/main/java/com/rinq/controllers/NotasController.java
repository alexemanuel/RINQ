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
		String cpf = principal.getName();
		
		if(discenteRepository.existsByCpf(cpf)) {
			Discente discente = discenteRepository.findByCpf(cpf);
			
			boletimDTO.initializeEntradasBoletim(discente);
			boletimDTO.setNomeDiscente(discente.getNome());
			
			model.addAttribute("boletimDTO", boletimDTO);
		}
		return "/boletim";
	}
}
