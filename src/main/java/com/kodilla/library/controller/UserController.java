package com.kodilla.library.controller;

import com.kodilla.library.domain.User;
import com.kodilla.library.domain.UserDto;
import com.kodilla.library.mapper.UserMapper;
import com.kodilla.library.service.UserDbService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/user")
@RequiredArgsConstructor
public class UserController {

    private final UserMapper userMapper;
    private final UserDbService userDbService;

    @PostMapping(value = "addUser", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void addUser(@RequestBody UserDto userDto){
        User user = userMapper.mapToUser(userDto);
        userDbService.save(user);
    }
}
