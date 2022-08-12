package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.dto.EventDTO;
import com.example.demo.entity.Event;
import com.example.demo.service.EventService;

@RestController
public class EventController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EventController.class);
	
	@Autowired
	private EventService eService;
	
	@CrossOrigin
	@GetMapping(path = "/getAllEvents")
	public ResponseEntity<?> getAllEvents() {
		List<Event> eventList = eService.getAllEvents();
		return ResponseEntity.ok(eventList);
	}
	
	@CrossOrigin
	@GetMapping(path = "/getEvent/{id}")
	public ResponseEntity<?> getEventById(@PathVariable("id") String id) {
		try {
		Event event = eService.getEventById(id);
		return ResponseEntity.ok(event);
		} catch (RuntimeException RE) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found", RE);
		}
	}
	
	@CrossOrigin
	@PostMapping(path = "/insertEvent")
	public ResponseEntity<?> createEvent(@RequestBody EventDTO eventDTO) {
		LOGGER.info("EventController createEvent(): ");
		Event event = eService.insertEvent(eventDTO);
		return ResponseEntity.ok(event);
	}
	
	@CrossOrigin
	@PutMapping(path = "/updateEvent")
	public ResponseEntity<?> updateEvent(@RequestBody EventDTO eventDTO) {
		LOGGER.info("EventController updateEvent(): ");
		Event event = eService.updateEvent(eventDTO);
		return ResponseEntity.ok(event);
	}
	
	@CrossOrigin
	@DeleteMapping(path = "/deleteEvent/{id}")
	public ResponseEntity<?> deleteEventById(@PathVariable("id") String id) {
		LOGGER.info("EventController deleteEventById(): ");
		String result = eService.deleteEventById(id);
		return ResponseEntity.ok(result);
	}
}
