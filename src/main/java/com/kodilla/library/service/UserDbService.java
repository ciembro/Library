package com.kodilla.library.service;

import com.kodilla.library.domain.User;
import com.kodilla.library.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class UserDbService {

    private final UserRepository userRepository;

    public User saveUser(User user){
        return userRepository.save(user);
    }
}
