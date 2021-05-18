package com.kodilla.library.service;

import com.kodilla.library.controller.advice.UserNotFoundException;
import com.kodilla.library.domain.User;
import com.kodilla.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor

public class UserDbService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public Optional<User> getUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId);
    }
}
