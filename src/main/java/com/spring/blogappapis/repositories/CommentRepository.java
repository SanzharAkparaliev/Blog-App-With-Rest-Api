package com.spring.blogappapis.repositories;

import com.spring.blogappapis.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
}
