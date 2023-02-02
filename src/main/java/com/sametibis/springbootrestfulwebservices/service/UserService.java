package com.sametibis.springbootrestfulwebservices.service;

import com.sametibis.springbootrestfulwebservices.dto.UserDto;
import com.sametibis.springbootrestfulwebservices.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto createUser(UserDto userDTO);
    List<User> getAllUser();
    Optional<UserDto> getUserById(Long id);
    void deleteUser(Long id);
    User updateUser(User user);
    Optional<User> findByEmail(String email);
}
