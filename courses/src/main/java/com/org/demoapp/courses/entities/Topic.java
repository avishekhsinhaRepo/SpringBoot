package com.org.demoapp.courses.entities;

public class Topic {

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
