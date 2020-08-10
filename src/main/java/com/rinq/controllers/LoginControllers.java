package com.rinq.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginControllers {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
