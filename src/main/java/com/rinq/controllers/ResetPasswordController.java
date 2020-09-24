package com.rinq.controllers;

import java.io.IOException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.rinq.models.DataTransferObject;
import com.rinq.models.PasswordResetToken;
import com.rinq.models.Usuario;
import com.rinq.repositories.PasswordResetTokenRepository;
import com.rinq.repositories.UsuarioRepository;
import com.rinq.services.mail.MailService;
import com.rinq.services.security.PasswordResetTokenService;

@Controller
public class ResetPasswordController {
	
	@Autowired
	MailService mailService;
	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	PasswordResetTokenRepository passwordResetTokenRepository;
	@Autowired
	PasswordResetTokenService passwordResetTokenService;
	
	@GetMapping("/esqueci_senha")
	public String showEmailForm(Model model) {
		
		model.addAttribute("DTO", new DataTransferObject());
		return "esqueci_senha";
	}
	
	@PostMapping("/esqueci_senha")
	public String checkEmailValidty(Model model, DataTransferObject DTO) throws MessagingException, IOException {
		String email = DTO.getEmail();
		Usuario user = usuarioRepository.findByEmail(email);
				
		if(user == null) {
			model.addAttribute("DTO", new DataTransferObject());
			return "redirect:/esqueci_senha?error";
		}
		
		PasswordResetToken passwordResetToken = passwordResetTokenService.createToken(user);
		passwordResetTokenRepository.save(passwordResetToken);
				
		mailService.sendMail(user.getName(), email, "Troca de Senha", "reset_password_email.html", passwordResetToken.getToken());
		
		return "redirect:/";
	}
	
	@GetMapping("/trocar_senha")
	public String showChangePasswordPage(@RequestParam("token") String tokenValue, Model model) {

		boolean tokenValidty = passwordResetTokenService.isValidToken(tokenValue);
		
		if(tokenValidty) {
			DataTransferObject DTO = new DataTransferObject();
			PasswordResetToken passwordResetToken = passwordResetTokenRepository.findByToken(tokenValue);
			
			DTO.setToken(passwordResetToken);

			model.addAttribute("DTO", DTO);
			return "trocar_senha";
		}
		
		passwordResetTokenRepository.deleteByToken(tokenValue);		
		return "redirect:/";
	}
	
	@PostMapping("/trocar_senha")
	public String updateUserPassword(DataTransferObject DTO) {
		
		PasswordResetToken token = DTO.getToken();
		String tokenValue = token.getToken();
			
		Usuario user = token.getUser();
		user.setPassword(DTO.getPassword());	
		
		usuarioRepository.save(user);
		passwordResetTokenRepository.deleteByToken(tokenValue);		
		
		return "redirect:/";
	}
	
}

