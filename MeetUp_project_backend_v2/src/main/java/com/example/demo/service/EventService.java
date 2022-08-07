package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	private EventRepository eRepo;
	
	public List<Event> getAllEvents() {
		return eRepo.findAll();
	}
	
	public Event getEventById(String id) {
		Optional<Event> event = eRepo.findById(id);
		return event.get();
	}
}
