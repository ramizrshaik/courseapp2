package com.courseapp2.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.coureapp2.domain.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

}
