package com.jdbc.exam.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
public enum ParkingPlaceStatus {
    EMPTY("parking place is empty"),
    RESERVED("parking place is reserved"),
    ENGAGED("parking place is engaged")

            ;

    String DESCRIPTION;
}
