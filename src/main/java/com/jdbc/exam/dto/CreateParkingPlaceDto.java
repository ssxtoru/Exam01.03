package com.jdbc.exam.dto;

import com.jdbc.exam.enums.ParkingPlaceEnums;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateParkingPlaceDto {
    private Long id;
    private String spotNumber;
    private ParkingPlaceEnums parkingPlaceEnums;
}
