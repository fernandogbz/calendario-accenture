package com.accenture.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/a")
	public String desplegarInicio() {
		
		return "index.jsp";
	}
}
