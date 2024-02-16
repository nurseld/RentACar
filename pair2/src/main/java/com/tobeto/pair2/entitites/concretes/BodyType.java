package com.tobeto.pair2.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum BodyType {

    SEDAN("Sedan"),
    HATCHBACK("Hatchback"),
    SUV("SUV");

    private final String bodyType;
}