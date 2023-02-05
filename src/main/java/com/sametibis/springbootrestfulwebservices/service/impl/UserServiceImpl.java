package com.sametibis.springbootrestfulwebservices.service.impl;

import com.sametibis.springbootrestfulwebservices.dto.UserDto;
import com.sametibis.springbootrestfulwebservices.entity.User;
import com.sametibis.springbootrestfulwebservices.mapper.UserMapper;
import com.sametibis.springbootrestfulwebservices.repository.UserRepository;
import com.sametibis.springbootrestfulwebservices.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDto createUser(UserDto userDto) {
        // Convert UserDTO into User JPA Entity
        // User user = UserMapper.mapToUser(userDto); -- custom mapper
        User user = modelMapper.map(userDto, User.class);

        // Save User JPA Entity to DB
        User savedUser = userRepository.save(user);

        // Convert saved User JPA Entity into UserDTO to give response to client
        // UserDto savedUserDto = UserMapper.mapToUserDto(savedUser); -- custom mapper
        UserDto savedUserDto = modelMapper.map(savedUser, UserDto.class);

        return savedUserDto;
    }

    @Override
    public List<UserDto> getAllUser() {
        List<User> users = userRepository.findAll();
        List<UserDto> usersDto = users.stream().map(user -> modelMapper.map(user, UserDto.class)).collect(Collectors.toList());
        return usersDto;
    }

    @Override
    public Optional<UserDto> getUserById(Long id) {
        User user = userRepository.findById(id).get();
        return Optional.of(modelMapper.map(user, UserDto.class));
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
        User updatedUser = userRepository.save(existUser);
        UserDto updatedUserDto = modelMapper.map(updatedUser, UserDto.class);
        return updatedUserDto;
    }

    @Override
    public Optional<UserDto> findByEmail(String email) {
        Optional<User> user =  userRepository.findUserByEmail(email);
        UserDto userDto = modelMapper.map(user, UserDto.class);
        return Optional.of(userDto);
    }
}
