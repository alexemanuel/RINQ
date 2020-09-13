package com.rinq.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.rinq.models.Usuario;
import com.rinq.repositories.UsuarioRepository;

@Controller	
public class HomeController {
	
	@Autowired
	UsuarioRepository usuarioReposiory;
	
	@GetMapping({"/", "/home"})
	public String home(Principal principal){
		Usuario authenticatedUser= usuarioReposiory.findByCpf(principal.getName());
		
		return String.format("home_%s", authenticatedUser.getRole().toLowerCase());
	}
}
