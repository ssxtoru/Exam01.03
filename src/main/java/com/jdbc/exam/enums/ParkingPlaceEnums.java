package com.jdbc.exam.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;


@AllArgsConstructor
public enum ParkingPlaceEnums {
    STANDART("standart parking place"),
    FOR_DISABLED("for disabled people parking place"),
    FOR_FAMILY("for family with children parking place"),
    FOR_ELECTROVEHICLES("for EV parking place")
    ;

    String DESCRIPTION;
}