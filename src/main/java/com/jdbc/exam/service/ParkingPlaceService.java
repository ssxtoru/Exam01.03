package com.jdbc.exam.service;

import com.jdbc.exam.dto.ParkingPlaceDto;
import com.jdbc.exam.enums.ParkingPlaceEnums;

import java.util.List;

public interface ParkingPlaceService {
    List<ParkingPlaceDto> findAll();
    ParkingPlaceDto findParkingLot(Long id);
    List<ParkingPlaceDto>  findParkingLotType(ParkingPlaceEnums placeEnums);
    List<ParkingPlaceDto> findNotReservedLot();
    ParkingPlaceDto createParkingPlace(ParkingPlaceDto parkingPlaceDto);
    void deleteById(Long id);

}
