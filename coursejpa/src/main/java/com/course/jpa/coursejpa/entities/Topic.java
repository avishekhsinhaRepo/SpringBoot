package com.course.jpa.coursejpa.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Topic {

	@Id
	private String topicId;
	private String topicName;
	
	
	public Topic() {
		super();
	}
	public Topic(String topicId, String topicName) {
		super();
		this.topicId = topicId;
		this.topicName = topicName;
	}
	public String getTopicId() {
		return topicId;
	}
	public void setTopicId(String topicId) {
		this.topicId = topicId;
	}
	public String getTopicName() {
		return topicName;
	}
	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}

	
	

}
