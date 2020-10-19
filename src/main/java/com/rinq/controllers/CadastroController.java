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
import com.rinq.models.PasswordResetToken;
import com.rinq.models.Usuario;
import com.rinq.repositories.CursoRepository;
import com.rinq.repositories.DiscenteRepository;
import com.rinq.repositories.DisciplinaRepository;
import com.rinq.repositories.DocenteRepository;
import com.rinq.repositories.PasswordResetTokenRepository;
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
	PasswordResetTokenRepository passwordResetTokenRepository;
	
	
	@GetMapping("/cadastro")
	public String showRegisterForm(Model model){
		
		model.addAttribute("DTO", cadastroDTO);		
		return "cadastro";
	}
	
	@PostMapping("/cadastro")
	public String registeUser(@ModelAttribute CadastroDTO cadastroDTO, Model model) throws MessagingException, IOException {
		String userFuncao = cadastroDTO.getFuncao(); // User's Role (Docente, Discente, Administrador)
		
		if(usuarioRepository.existsByCpf(cadastroDTO.getCpf())) {
			return "redirect:/cadastro?error";
		
		}else {			
			cadastroDTO.setCurso(cursoRepository.findByNome(cadastroDTO.getNomeCurso()));
			cadastroDTO.setDisciplina(disciplinaRepository.findByNome(cadastroDTO.getNomeDisciplina()));
			
			Curso curso = cadastroDTO.getCurso();
			
			if(userFuncao.equals("discente")) {
				int discenteNumber = discenteRepository.countByCurso(curso);
				String matricula = MatriculaGenerator.generateMatricula(curso.getNome(), discenteNumber);
				
				Discente discente = new Discente(cadastroDTO, matricula);			
				
				List<Disciplina> disciplinas = disciplinaRepository.findByCurso(curso);
				
				// Set disciplinas in discente and dicente in disciplinas
				discente.setDisciplinas(disciplinas);
				disciplinas.forEach(disciplina -> disciplina.addDiscente(discente));
				
				discenteRepository.save(discente);
				
			}else {				
				Docente docente = new Docente(cadastroDTO);
				docenteRepository.save(docente);
			}
			
			// Create reset/initialize password token, and send it throught email
			PasswordResetToken passwordResetToken = passwordResetTokenService.createToken(new Usuario(cadastroDTO));
			passwordResetTokenRepository.save(passwordResetToken);
			
			mailService.sendMail(cadastroDTO.getNome(), cadastroDTO.getEmail(), "Bem-Vindo ao RINQ", "welcome_email.html", passwordResetToken.getToken());
		}
		
		model.addAttribute("DTO", cadastroDTO);
		return "cadastro"; 
	}
}