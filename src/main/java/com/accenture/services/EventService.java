package com.accenture.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accenture.models.Event;
import com.accenture.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	public final EventRepository eventRepository;
	
	public EventService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;
	}
	
	public List<Event> obtainAllEvents() {
		return this.eventRepository.findAll();
	}
}
