package com.sametibis.springbootrestfulwebservices.service.impl;

import com.sametibis.springbootrestfulwebservices.dto.UserDto;
import com.sametibis.springbootrestfulwebservices.entity.User;
import com.sametibis.springbootrestfulwebservices.mapper.UserMapperMapStruct;
import com.sametibis.springbootrestfulwebservices.repository.UserRepository;
import com.sametibis.springbootrestfulwebservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDTO into User JPA Entity

        User user = UserMapperMapStruct.MAPPER.mapToUser(userDto);

        // Save User JPA Entity to DB
        User savedUser = userRepository.save(user);

        // Convert saved User JPA Entity into UserDTO to give response to client
        UserDto savedUserDto = UserMapperMapStruct.MAPPER.mapToUserDto(savedUser);
        return savedUserDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = users.stream().map(user -> UserMapperMapStruct.MAPPER.mapToUserDto(user)).collect(Collectors.toList());
        return usersDto;
    }

    @Override
    public Optional<UserDto> getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return Optional.of(UserMapperMapStruct.MAPPER.mapToUserDto(user));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDto updateUser(UserDto userDto) {
        User existUser = userRepository.findById(userDto.getId()).get();
        existUser.setFirstName(userDto.getFirstName());
        existUser.setLastName(userDto.getLastName());
        existUser.setEmail(userDto.getEmail());
        // save it to the DB
        User updatedUser = userRepository.save(existUser);
        UserDto updatedUserDto = UserMapperMapStruct.MAPPER.mapToUserDto(updatedUser);
        return updatedUserDto;
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        Optional<User> user = userRepository.findUserByEmail(email);
        UserDto userDto = UserMapperMapStruct.MAPPER.mapToUserDto(user.get());
        return Optional.of(userDto);
    }
}
