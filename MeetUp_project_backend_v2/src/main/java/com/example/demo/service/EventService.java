package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.EventDTO;
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
	
	public Event insertEvent(EventDTO eventDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Event event = modelMapper.map(eventDTO, Event.class);
		return eRepo.insert(event);
	}
	
	
	public Event updateEvent(EventDTO eventDTO) {
		ModelMapper modelMapper = new ModelMapper();
		Event event = modelMapper.map(eventDTO, Event.class);
		return eRepo.save(event);
	}
	
	public String deleteEventById(String id) {
		eRepo.deleteById(id);
		return id;
	}
}
