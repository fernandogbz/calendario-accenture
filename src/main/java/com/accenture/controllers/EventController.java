package com.accenture.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.accenture.models.Event;
import com.accenture.services.EventService;

@Controller
public class EventController {
	
	// Importar el servicio
	@Autowired
	private final EventService eventService;
	
	public EventController(EventService eventService) {
		this.eventService = eventService;
	}
	
	@GetMapping("")
	public String desplegarTareas(Model model) {
		List<Event> events = this.eventService.obtainAllEvents();
		model.addAttribute("events", events);
		return "index.jsp";
	}
}
