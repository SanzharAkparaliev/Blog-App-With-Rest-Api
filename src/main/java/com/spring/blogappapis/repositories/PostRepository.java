package com.spring.blogappapis.repositories;

import com.spring.blogappapis.entities.Category;
import com.spring.blogappapis.entities.Post;
import com.spring.blogappapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Long> {
    List<Post> findAllByUser(User user);
    List<Post> findAllByCategory(Category category);
}
