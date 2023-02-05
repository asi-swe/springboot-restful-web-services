package com.sametibis.springbootrestfulwebservices.service;

import com.sametibis.springbootrestfulwebservices.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {

    UserDto createUser(UserDto userDTO);
    List<UserDto> getAllUser();
    Optional<UserDto> getUserById(Long id);
    void deleteUser(Long id);
    UserDto updateUser(UserDto userDto);
    Optional<UserDto> findByEmail(String email);
}
