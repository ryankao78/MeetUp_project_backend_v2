package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Event;
import com.example.demo.service.EventService;

@RestController
public class EventController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eService;
	
	@GetMapping(path = "/getAllEvents")
	public ResponseEntity<?> getAllEvents() {
		List<Event> eventList = eService.getAllEvents();
		return ResponseEntity.ok(eventList);
	}
	
	@GetMapping(path = "/getEvent/{id}")
	public ResponseEntity<?> getEventById(@PathVariable("id") String id) {
		try {
		Event event = eService.getEventById(id);
		return ResponseEntity.ok(event);
		} catch (RuntimeException RE) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found", RE);
		}
	}
}
