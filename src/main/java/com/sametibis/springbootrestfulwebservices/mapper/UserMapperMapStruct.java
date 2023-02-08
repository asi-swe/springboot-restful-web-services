package com.sametibis.springbootrestfulwebservices.mapper;

import com.sametibis.springbootrestfulwebservices.dto.UserDto;
import com.sametibis.springbootrestfulwebservices.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserMapperMapStruct {
    UserMapperMapStruct MAPPER = Mappers.getMapper(UserMapperMapStruct.class);
    User mapToUser(UserDto userDto);
    UserDto mapToUserDto(User user);

}
