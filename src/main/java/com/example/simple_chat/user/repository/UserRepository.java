package com.example.simple_chat.user.repository;

import com.example.simple_chat.user.entity.Status;
import com.example.simple_chat.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAllByStatus(Status status);

    User findByUsername(String username);
}
