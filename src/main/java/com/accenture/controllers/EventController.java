package com.accenture.controllers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	
	@GetMapping({"", "/", "/events"})
	public String desplegarTareas(Model model) {
		List<Event> events = this.eventService.obtainAllEvents();
		model.addAttribute("events", events);
		return "index.jsp";
	}
	
	@PostMapping("/events")
	public String obtenerPorFechas0(@RequestParam("selectedDate") String selectedDate, Model model) {
		List<Event> coincidentEvents = eventService.obtainByDate(selectedDate);
		model.addAttribute("coincidentEvents", coincidentEvents);
		return "index.jsp";
	}

}
