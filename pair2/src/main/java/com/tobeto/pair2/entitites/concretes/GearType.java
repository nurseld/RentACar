package com.tobeto.pair2.entitites.concretes;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum GearType {

    MANUAL("Manual"),
    AUTOMATIC("Automatic");


    private final String gearType;
}