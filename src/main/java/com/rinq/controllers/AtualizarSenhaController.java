package com.rinq.controllers;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rinq.models.PasswordUpdateToken;
import com.rinq.models.Usuario;
import com.rinq.repositories.PasswordUpdateTokenRepository;
import com.rinq.repositories.UsuarioRepository;
import com.rinq.service.DTO.AtualizarSenhaDTO;
import com.rinq.services.mail.MailService;
import com.rinq.services.security.PasswordResetTokenService;

@Controller
public class AtualizarSenhaController {
	
	@Autowired
	MailService mailService;
	@Autowired
	PasswordResetTokenService passwordResetTokenService;
	
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PasswordUpdateTokenRepository passwordResetTokenRepository;
	
	@GetMapping("/esqueci_senha")
	public String showEmailForm(Model model) {
		
		model.addAttribute("DTO", new AtualizarSenhaDTO());
		return "esqueci_senha";
	}
	
	@PostMapping("/esqueci_senha")
	public String checkEmailValidty(Model model, AtualizarSenhaDTO DTO) throws MessagingException, IOException {
		Usuario usuario = usuarioRepository.findByLogin(DTO.getLogin());
				
		if(usuario == null) {
			model.addAttribute("DTO", new AtualizarSenhaDTO());
			return "redirect:/esqueci_senha?error";
		}
		PasswordUpdateToken passwordResetToken = passwordResetTokenService.generateToken(usuario);
		passwordResetTokenRepository.save(passwordResetToken);
		
		String nomeUsuario  = usuario.getNome();
		String emailUsuario = usuario.getEmail();
		String tokenString  = passwordResetToken.getTokenString();
		
		mailService.sendMail(nomeUsuario, emailUsuario, "Troca de Senha", "reset_password_email.html", tokenString);
		
		return "redirect:/";
	}
	
	@GetMapping("/trocar_senha")
	public String showChangePasswordPage(@RequestParam("token") String tokenString, Model model) {

		boolean tokenValidty = passwordResetTokenService.isValidToken(tokenString);
		
		if(tokenValidty) {
			AtualizarSenhaDTO DTO = new AtualizarSenhaDTO();
			PasswordUpdateToken passwordResetToken = passwordResetTokenRepository.findByTokenString(tokenString);
			
			DTO.setToken(passwordResetToken);
			model.addAttribute("DTO", DTO);
			
			return "trocar_senha";
		}		
		passwordResetTokenRepository.deleteByTokenString(tokenString);		
		return "redirect:/";
	}
	
	@PostMapping("/trocar_senha")
	public String updateUserPassword(AtualizarSenhaDTO DTO) {
		
		PasswordUpdateToken token = DTO.getToken();
		String tokenString = token.getTokenString();
			
		Usuario usuario = token.getUsuario();
		usuario.setSenha(DTO.getPassword());	
		
		usuarioRepository.save(usuario);
		passwordResetTokenRepository.deleteByTokenString(tokenString);		
		
		return "redirect:/";
	}
}

