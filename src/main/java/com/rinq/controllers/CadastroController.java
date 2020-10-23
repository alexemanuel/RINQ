package com.rinq.controllers;

import java.io.IOException;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rinq.models.Curso;
import com.rinq.models.Discente;
import com.rinq.models.Disciplina;
import com.rinq.models.Docente;
import com.rinq.models.PasswordUpdateToken;
import com.rinq.models.Usuario;
import com.rinq.repositories.CursoRepository;
import com.rinq.repositories.DiscenteRepository;
import com.rinq.repositories.DisciplinaRepository;
import com.rinq.repositories.DocenteRepository;
import com.rinq.repositories.PasswordUpdateTokenRepository;
import com.rinq.repositories.UsuarioRepository;
import com.rinq.service.DTO.CadastroDTO;
import com.rinq.service.matricula.MatriculaGenerator;
import com.rinq.services.mail.MailService;
import com.rinq.services.security.PasswordResetTokenService;

@Controller
public class CadastroController {
	
	@Autowired
	MailService mailService;
	@Autowired
	PasswordResetTokenService passwordResetTokenService;
	@Autowired
	CadastroDTO cadastroDTO;

	@Autowired
	UsuarioRepository usuarioRepository;
	@Autowired
	DocenteRepository docenteRepository;
	@Autowired
	DiscenteRepository discenteRepository;
	@Autowired
	CursoRepository cursoRepository;
	@Autowired
	DisciplinaRepository disciplinaRepository;
	@Autowired
	PasswordUpdateTokenRepository passwordResetTokenRepository;
	
	
	@GetMapping("/cadastro")
	public String showRegisterForm(Model model){
		
		model.addAttribute("DTO", cadastroDTO);		
		return "cadastro";
	}
	
	@PostMapping("/cadastro")
	public String registeUser(@ModelAttribute CadastroDTO DTO, Model model) throws MessagingException, IOException {
		String userFuncao = DTO.getFuncao(); // User's Role (Docente, Discente, Administrador)
		
				
		if(usuarioRepository.existsByCpf(DTO.getCpf())) {
			return "redirect:/cadastro?error";
		
		}else {			
			DTO.setCurso(cursoRepository.findByNome(DTO.getNomeCurso()));
			DTO.setDisciplina(disciplinaRepository.findByNome(DTO.getNomeDisciplina()));
			
			Curso curso = DTO.getCurso();
			
			if(userFuncao.equals("discente")) {
				int discenteNumber = discenteRepository.countByCurso(curso);	
				
				String matricula = MatriculaGenerator.generateMatricula(curso.getNome(), discenteNumber);	
				DTO.setMatricula(matricula);
				
				Discente discente = new Discente(DTO);			
				List<Disciplina> disciplinas = disciplinaRepository.findByCurso(curso);
				
				// Set disciplinas in discente and dicente in disciplinas
				discente.setDisciplinas(disciplinas);
				disciplinas.forEach(disciplina -> disciplina.addDiscente(discente));
				
				discenteRepository.save(discente);
				
			}else {				
				Docente docente = new Docente(DTO);
				docenteRepository.save(docente);
			}
			
			// Create reset/initialize password token, and send it throught email
			PasswordUpdateToken passwordResetToken = passwordResetTokenService.generateToken(new Usuario(DTO));
			passwordResetTokenRepository.save(passwordResetToken);
			
			String nomeUsuario  = DTO.getNome();
			String emailUsuario = DTO.getEmail();
			String tokenString  = passwordResetToken.getTokenString();
			
			mailService.sendMail(nomeUsuario, emailUsuario, "Bem-Vindo ao RINQ", "welcome_email.html", tokenString);
		}
		
		model.addAttribute("DTO", cadastroDTO);
		return "cadastro"; 
	}
}