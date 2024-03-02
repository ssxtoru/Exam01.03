package com.jdbc.exam.service;

import com.jdbc.exam.dto.CreateParkingPlaceDto;
import com.jdbc.exam.dto.ParkingPlaceDto;
import com.jdbc.exam.enums.ParkingPlaceEnums;

import java.util.List;

public interface ParkingPlaceService {
    List<ParkingPlaceDto> findAll();
    ParkingPlaceDto findParkingLot(Long id);
    List<ParkingPlaceDto>  findParkingLotType(ParkingPlaceEnums placeEnums);
    List<ParkingPlaceDto> findNotReservedLot();
    CreateParkingPlaceDto create(CreateParkingPlaceDto parkingPlaceToCreate);
    void deleteById(Long id);

}
