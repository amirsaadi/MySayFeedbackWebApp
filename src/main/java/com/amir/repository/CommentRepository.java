package com.amir.repository;

import com.amir.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Amir on 2017-02-24.
 * MySayFeedbackWebApp
 */
public interface CommentRepository extends JpaRepository<Comment ,Long>{
}
