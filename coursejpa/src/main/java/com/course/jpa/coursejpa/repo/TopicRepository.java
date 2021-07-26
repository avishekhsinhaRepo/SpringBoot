package com.course.jpa.coursejpa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.course.jpa.coursejpa.entities.Topic;

public interface TopicRepository extends JpaRepository<Topic, String>{

}
