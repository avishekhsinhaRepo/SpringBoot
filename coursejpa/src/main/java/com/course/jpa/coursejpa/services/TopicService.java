package com.course.jpa.coursejpa.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.course.jpa.coursejpa.entities.Topic;
import com.course.jpa.coursejpa.repo.TopicRepository;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;

	private List<Topic> topics = new ArrayList<>(Arrays.asList(new Topic("spring", "Spring Framework"),
			new Topic("java", "Core Java"), new Topic("springboot", "Spring Boot")));

	public List<Topic> getAllTopics() {
		List<Topic> topics = new ArrayList<Topic>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}

	public Topic getTopic(String topicId) {
		return topics.stream().filter(topic -> topic.getTopicId().equals(topicId)).findFirst().get();
	}

	public void addTopic(Topic topic) {
		//topics.add(topic);
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic , String topicId) {
		/*for (int topicIndex = 0; topicIndex < topics.size(); topicIndex++) {
			Topic topic1 = topics.get(topicIndex);
			if (topic1.getTopicId().equals(topicId))
				topics.set(topicIndex, topic);
		}*/
		topicRepository.save(topic);
	}

	public void deleteTopic(String topicId) {
		/*for (int topicIndex = 0; topicIndex < topics.size(); topicIndex++) {
			Topic topic = topics.get(topicIndex);
			if (topic.getTopicId().equals(topicId))
				topics.remove(topicIndex);

		}*/
		topicRepository.deleteById(topicId);
	}
}
