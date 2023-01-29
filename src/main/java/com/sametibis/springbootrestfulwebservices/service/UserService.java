package com.sametibis.springbootrestfulwebservices.service;

import com.sametibis.springbootrestfulwebservices.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User createUser(User user);
    List<User> getAllUser();
    Optional<User> getUserById(Long id);
    void deleteUser(Long id);
    User updateUser(User user);
    Optional<User> findByEmail(String email);
}
