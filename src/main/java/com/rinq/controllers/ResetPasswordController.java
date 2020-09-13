package com.rinq.controllers;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rinq.models.PasswordResetToken;
import com.rinq.models.Usuario;
import com.rinq.repositories.PasswordResetTokenRepository;
import com.rinq.repositories.UsuarioRepository;
import com.rinq.services.mail.MailService;
import com.rinq.services.token.PasswordResetTokenService;

@Controller
public class ResetPasswordController {
	
	@Autowired
	MailService mailService;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PasswordResetTokenRepository passwordResetTokenRepository;
	
	@GetMapping("/esqueci_senha")
	public String showEmailForm(Model model) {
		
		model.addAttribute("email", String.class);
		return "esqueci_senha";
	}
	
	@PostMapping("/esqueci_senha")
	public String checkEmailValidty(String email) throws MessagingException, IOException {
		
		Usuario user = usuarioRepository.findByEmail(email);
		
		if(user == null) {
			return "esqueci_senha";
		}
		
		PasswordResetToken passwordResetToken = PasswordResetTokenService.createToken(user);
		passwordResetTokenRepository.save(passwordResetToken);
		
		mailService.sendMail(user.getName(), email, "Troca de Senha", "reset_password_email.html", passwordResetToken.getToken());
		
		return "redirect:login";
	}
	
	@GetMapping("/trocar_senha")
	public String showChangePasswordPage(@RequestParam("token") String tokenValue) {
		boolean tokenValidty = PasswordResetTokenService.checkTokenValidity(tokenValue);
		
		if(tokenValidty) {
			return "troca_senha";
		}
		return "redirect:login";
	}
}
