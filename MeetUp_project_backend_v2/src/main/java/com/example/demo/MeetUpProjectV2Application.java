package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.example.demo.model.Event;
import com.example.demo.repository.EventRepository;

@SpringBootApplication
@EnableMongoRepositories
public class MeetUpProjectV2Application implements CommandLineRunner {
	
	@Autowired
	EventRepository eventRepo;
	
	List<Event> eventsList = new ArrayList<Event>();

	public static void main(String[] args) {
		SpringApplication.run(MeetUpProjectV2Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("-----Create User Events-----");
		
//		createEvent();
		
		System.out.println("-----Show All User Events-----\n");
		
		showAllEvents();
		
		System.out.println("-----Get Event by Creator-----\n");
		
		getEventByCreator("Chang Hee Son");
		
		getEventByCreator("Yibo Chen");
		
		System.out.println("-----Update Event Title-----\n");
		
		updateEventTitleById("1", "Fly to the moon");
		
		getEventByCreator("Jen Tse Kao");
		
		updateEventMessageById("3", "Let's go");
		
		getEventByCreator("Yibo Chen");
		
		System.out.println("-----Delete Event-----\n");
		
//		deleteEventById("4");
	}
	
	// Create 
	void createEvent() {
		System.out.println("Event creation started: ");
		
		eventRepo.save(new Event("1", "Jen Tse Kao", "All you can eat", "hey now", 0, 0, new Date()));
		eventRepo.save(new Event("2", "Chang Hee Son", "Tera Luna", "remember that...", 0, 0, new Date()));
		eventRepo.save(new Event("3", "Yibo Chen", "Road Trip", "what's cooking???", 0, 0, new Date()));
		eventRepo.save(new Event("4", "Zhenghao Xiao", "Fly to the moon~", "mark my word!", 0, 0, new Date()));
		
		System.out.println("Event creation completed!");
	}
	
	// Read
	// 1. show all data
	public void showAllEvents() {
		eventsList = eventRepo.findAll();
		eventsList.forEach(event -> System.out.println(getEventDetails(event)));
	}
	
	// 2. get event by creator
	public void getEventByCreator(String creator) {
		System.out.println("Getting event by creator: " + creator);
		Event event = eventRepo.findEventByCreator(creator);
		System.out.println(getEventDetails(event));
	}
	
	// Update
	public void updateEventTitleById(String id, String title) {
		String newTitle = title;
		
		Event event = eventRepo.findEventById(id);
		
		event.setTitle(newTitle);
		
		Event updatedEvent = eventRepo.save(event);
		
		if (updatedEvent != null) {
			System.out.println("Successfully updated title!");
		}
	}
	
	public void updateEventMessageById(String id, String message) {
		String newMessage = message;
		
		Event event = eventRepo.findEventById(id);
		
		event.setMessage(newMessage);
		
		Event updatedEvent = eventRepo.save(event);
		
		if (updatedEvent != null) {
			System.out.println("Successfully updated message!");
		}
	}
	
	// Delete
	public void deleteEventById(String id) {
		eventRepo.deleteById(id);
		System.out.println("The event with id " + id + " is deleted...");
	}

	public String getEventDetails(Event event) {
		
        System.out.println(
        "Creator: " + event.getCreator() + 
        ", \nTitle: " + event.getTitle() +
        ", \nMessage: " + event.getMessage()
        );
		
		return "";
	}
}
