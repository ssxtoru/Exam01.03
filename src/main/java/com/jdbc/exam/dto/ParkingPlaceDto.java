package com.jdbc.exam.dto;

import com.jdbc.exam.enums.ParkingPlaceEnums;
import com.jdbc.exam.enums.ParkingPlaceStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParkingPlaceDto {
    private Integer id;
    private Integer parkingLot;
    private ParkingPlaceEnums placeEnums;
    private ParkingPlaceStatus status;
}
