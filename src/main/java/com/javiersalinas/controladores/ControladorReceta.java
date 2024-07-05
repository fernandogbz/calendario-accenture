package com.javiersalinas.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class ControladorReceta {
	
	@GetMapping("/recetas")
	public String desplegarRecetas(Model modelo,
									HttpSession sesion) {
		// Cargar lista de recetas al modelo
		if(sesion.getAttribute("id_usuario") == null) {
			return "redirect:/login";
		}
		return "recetas.jsp";
	}
}
