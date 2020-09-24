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
import com.rinq.models.Docente;
import com.rinq.models.Discente;
import com.rinq.models.PasswordResetToken;
import com.rinq.models.Usuario;
import com.rinq.repositories.DiscenteRepository;
import com.rinq.repositories.DocenteRepository;
import com.rinq.repositories.PasswordResetTokenRepository;
import com.rinq.repositories.UsuarioRepository;
import com.rinq.services.mail.MailService;
import com.rinq.services.security.PasswordResetTokenService;

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
	@Autowired
	PasswordResetTokenRepository passwordResetTokenRepository;
	@Autowired
	PasswordResetTokenService passwordResetTokenService;
	
	
	@GetMapping("/cadastro")
	public String registerForm(Model model){
		
		model.addAttribute("DTO", new DataTransferObject());
		return "cadastro";
	}
	
	@PostMapping("/cadastro")
	public String registerSubmit(@ModelAttribute DataTransferObject DTO, Model model) throws MessagingException, IOException {
		String newUserRole = DTO.getRole();
		
		if(usuarioRepository.existsByCpf(DTO.getCpf())) {
			return "redirect:/cadastro?error";
		
		}else {
			
			if(newUserRole.equals("docente")) {
				Discente newUser = new Discente(DTO);
				docenteRepository.save(newUser);
			
			}else {
				Docente newUser = new Docente(DTO);
				discenteRepository.save(newUser);
			}
			
			PasswordResetToken passwordResetToken = passwordResetTokenService.createToken(new Usuario(DTO));
			passwordResetTokenRepository.save(passwordResetToken);
			
			mailService.sendMail(DTO.getName(), DTO.getEmail(), "Bem-Vindo ao RINQ", "welcome_email.html", passwordResetToken.getToken());
		}
		
		model.addAttribute("DTO", new DataTransferObject());
		return "cadastro"; 
	}
}