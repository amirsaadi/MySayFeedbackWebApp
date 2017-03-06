package com.amir.repository;

import com.amir.model.Topic;
import com.amir.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Amir on 2017-02-24.
 * MySayFeedbackWebApp
 */
public interface TopicRepository extends JpaRepository<Topic,Long> {
	
	
}
