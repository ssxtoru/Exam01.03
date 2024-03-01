package com.jdbc.exam.entity;

import com.jdbc.exam.enums.ParkingPlaceEnums;
import com.jdbc.exam.enums.ParkingPlaceStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ParkingPlace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer parkingLot;
    private ParkingPlaceEnums placeEnums;
    private ParkingPlaceStatus status;
}
