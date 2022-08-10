package com.spring.blogappapis.repositories;

import com.spring.blogappapis.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
