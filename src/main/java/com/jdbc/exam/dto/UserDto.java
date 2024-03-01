package com.jdbc.exam.dto;

import com.jdbc.exam.entity.ParkingPlace;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {
    private Integer id;
    private String name;
    private String surname;
    private List<ParkingPlace> parkingPlaces;
}
