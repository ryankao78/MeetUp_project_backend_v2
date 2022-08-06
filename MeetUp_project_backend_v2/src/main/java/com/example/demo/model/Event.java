package com.example.demo.model;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("postmessaages")
public class Event {

	@Id
	private String id;

	private String creator;
	private String title;
	private String message;
//	private String[] tags;
//	private String selectedFile;
	private int joinCount;
	private int rejectCount;
	private Date createdAt;

	public Event(String id, String creator, String title, String message, int joinCount,
			int rejectCount, Date createdAt) {
		super();
		this.id = id;
		this.creator = creator;
		this.title = title;
		this.message = message;
//		this.tags = tags;
//		this.selectedFile;
		this.joinCount = joinCount;
		this.rejectCount = rejectCount;
		this.createdAt = createdAt;
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

//	public String[] getTags() {
//		return tags;
//	}
//
//	public void setTags(String[] tags) {
//		this.tags = tags;
//	}
	
//	public String getSelectedFile() {
//	return selectedFile;
//	}
//
//	public void setSelectedFile(String selectedFile) {
//		this.selectedFile = selectedFile;
//	}

	public long getJoinCount() {
		return joinCount;
	}

	public void setJoinCount(int joinCount) {
		this.joinCount = joinCount;
	}

	public long getRejectCount() {
		return rejectCount;
	}

	public void setRejectCount(int rejectCount) {
		this.rejectCount = rejectCount;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
