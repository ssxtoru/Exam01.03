package com.jdbc.exam.controller;

import com.jdbc.exam.dto.ParkingPlaceDto;
import com.jdbc.exam.enums.ParkingPlaceEnums;
import com.jdbc.exam.service.impl.ParkingPlaceServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("parking-spots/")
public class ParkingPlaceController {
    private final ParkingPlaceServiceImpl service;

    @PostMapping("create")
    public ParkingPlaceDto createParkingPlace(ParkingPlaceDto parkingPlaceDto){
        return service.createParkingPlace(parkingPlaceDto);
    }

    @GetMapping("findAll")
    public List<ParkingPlaceDto> findAll(){
        return service.findAll();
    }

    @GetMapping("findById/{id}")
    public ParkingPlaceDto findById(@PathVariable Long id){
        return service.findParkingLot(id);
    }

    @GetMapping("findNotReservedPlaces")
    public List<ParkingPlaceDto> findNotReservedPlaces(){
        return service.findNotReservedLot();
    }

    @GetMapping("findPlacesByParkingType")
    public List<ParkingPlaceDto> findPlacesByParkingType(ParkingPlaceEnums parkingType){
        return service.findParkingLotType(parkingType);
    }

    @DeleteMapping("delete")
    public void deleteById(@RequestParam Long id){
        service.deleteById(id);
    }
}
