package com.rinq.controllers;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rinq.models.DataTransferObject;
import com.rinq.models.Discente;
import com.rinq.models.Docente;
import com.rinq.repositories.DiscenteRepository;
import com.rinq.repositories.DocenteRepository;
import com.rinq.repositories.UsuarioRepository;
import com.rinq.services.mail.MailService;

@Controller
public class RegisterController {
	
	@Autowired
	MailService mailService;

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	DocenteRepository docenteRepository;
	@Autowired
	DiscenteRepository discenteRepository;
	
	
	@GetMapping("/cadastro")
	public String registerForm(Model model){
		
		model.addAttribute("DTO", new DataTransferObject());
		return "cadastro";
	}
	
	@PostMapping("/cadastro")
	public String registerSubmit(@ModelAttribute DataTransferObject DTO, Model model) throws MessagingException, IOException {
		String newUserRole = DTO.getRole();
		
		if(usuarioRepository.existsByCpf(DTO.getCpf())) {
			System.out.println("Já existe");
		
		}else {
			
			if(newUserRole.equals("Docente")) {
				Docente newUser = new Docente(DTO);
				docenteRepository.save(newUser);
			
			}else {
				Discente newUser = new Discente(DTO);
				discenteRepository.save(newUser);
			}
			
			mailService.sendWelcomeEmail(DTO.getName(), DTO.getEmail());
			System.out.println("Entrou");
		}
		
		model.addAttribute("DTO", new DataTransferObject());
		
		return "cadastro"; 
	}
}