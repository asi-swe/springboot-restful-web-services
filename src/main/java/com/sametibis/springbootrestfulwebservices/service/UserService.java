package com.sametibis.springbootrestfulwebservices.service;

import com.sametibis.springbootrestfulwebservices.entity.User;

import java.util.List;

public interface UserService {

    User createUser(User user);
    List<User> getAllUser();

    void deleteUser(Long id);
}
