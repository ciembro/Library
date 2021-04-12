package com.kodilla.library.domain;

import lombok.Getter;

@Getter
public enum BookStatus {
    AVAILABLE,
    BORROWED,
    LOST,
    DAMAGED
}
