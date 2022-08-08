package com.example.demo.dto;

public class EventDTO {

	private String id;
	private String creator;
	private String title;
	private String message;

	public EventDTO(String id, String creator, String title, String message) {
		super();
		this.id = id;
		this.creator = creator;
		this.title = title;
		this.message = message;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
