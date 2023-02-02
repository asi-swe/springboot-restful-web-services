package com.sametibis.springbootrestfulwebservices.service.impl;

import com.sametibis.springbootrestfulwebservices.dto.UserDto;
import com.sametibis.springbootrestfulwebservices.entity.User;
import com.sametibis.springbootrestfulwebservices.mapper.UserMapper;
import com.sametibis.springbootrestfulwebservices.repository.UserRepository;
import com.sametibis.springbootrestfulwebservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDTO into User JPA Entity
        User user = UserMapper.mapToUser(userDto);

        // Save User JPA Entity to DB
        User savedUser = userRepository.save(user);

        // Convert saved User JPA Entity into UserDTO to give response to client
        UserDto savedUserDto = UserMapper.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserDto> getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return Optional.of(UserMapper.mapToUserDto(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
        User existUser = userRepository.findById(user.getId()).get();
        existUser.setFirstName(user.getFirstName());
        existUser.setLastName(user.getLastName());
        existUser.setEmail(user.getEmail());
        User updatedUser = userRepository.save(existUser);
        return updatedUser;
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }
}
