package com.kodilla.library.service;

import com.kodilla.library.repository.CheckOutRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckOutDbService {

    private final CheckOutRepository checkOutRepository;
}
