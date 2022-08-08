package com.example.demo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.entity.Event;

// @Repository // not necessary
public interface EventRepository extends MongoRepository<Event, String> {
	
//	@Query("{creator: '?0'}")
//	Event findEventByCreator(String creator);
//	
//	@Query("{id: '?0'}")
//	Event findEventById(String id);
	
	// Does this work the same way as using id?
//	@Query(value = "{creator: '?0'}")
//	List<Event> findAll(String creator);
	
//	@Query(value = "{id: '?0'}")
//	List<Event> findAll(String id);

}
