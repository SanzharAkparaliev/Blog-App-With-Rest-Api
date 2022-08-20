package com.spring.blogappapis.security;

import com.spring.blogappapis.entities.User;
import com.spring.blogappapis.exceptions.ResourceNotFoundException;
import com.spring.blogappapis.repositories.UserRepository;
import net.bytebuddy.implementation.auxiliary.AuxiliaryType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
      User user =  this.userRepository.findByEmail(username).orElseThrow(() -> new ResourceNotFoundException("User "," email"+username,0));
        return user;
    }
}
