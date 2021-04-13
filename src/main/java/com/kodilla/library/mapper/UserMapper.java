package com.kodilla.library.mapper;

import com.kodilla.library.domain.User;
import com.kodilla.library.domain.UserDto;
import org.springframework.stereotype.Service;

@Service
public class UserMapper {

    public UserDto mapToUserDto(User user){
        return new UserDto(user.getId(),
                user.getFirstName(),
                user.getLastName(),
                user.getJoiningDate(),
                user.getCheckOutList());
    }

    public User mapToUser(UserDto userDto){
        return  new User(userDto.getId(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getJoinedDate(),
                userDto.getCheckOuts());
    }
}
