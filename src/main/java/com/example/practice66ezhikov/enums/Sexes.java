package com.example.practice66ezhikov.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Sexes {
    MALE("Мужской"),
    FEMALE("Женский");

    private final String name;
}
