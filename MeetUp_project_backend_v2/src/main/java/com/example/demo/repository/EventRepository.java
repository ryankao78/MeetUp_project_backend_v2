package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.model.Event;

// @Repository // not necessary
public interface EventRepository extends MongoRepository<Event, String> {
	
	@Query("{creator: '?0'}")
	Event findEventByCreator(String creator);
	
	@Query(value = "{creator: '?0'}")
	List<Event> findAll(String creator);

}
