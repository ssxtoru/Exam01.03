package com.jdbc.exam.dto;

import com.jdbc.exam.entity.ParkingPlace;
import com.jdbc.exam.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreateParkingInteractionDto {
    private User user;
    private ParkingPlace parkingPlace;
}
