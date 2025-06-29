package com.example.simple_chat.user.service;

import com.example.simple_chat.user.entity.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    void saveUser(User user);

    void disconnect(User user);

    List<User> findAllConnectedUsers();

    User findByUsername(String username);

}
