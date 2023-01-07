package com.example.practice66ezhikov.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Countries {
    RUSSIA("Россия"),
    USA("США"),
    ITALY("Италия");

    private final String name;
}
