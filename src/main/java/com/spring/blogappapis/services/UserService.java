package com.spring.blogappapis.services;

import com.spring.blogappapis.payloads.UserDto;

import java.util.List;


public interface UserService {
    UserDto createUser(UserDto user);
    UserDto updateUser(UserDto user,Long userId);
    UserDto getUserById(Long userId);
    List<UserDto> getAllUsers();
    void deleteUser(Long userId);
}
