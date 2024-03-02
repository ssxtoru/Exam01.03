package com.jdbc.exam.controller;

import com.jdbc.exam.dto.CreateParkingPlaceDto;
import com.jdbc.exam.dto.ParkingPlaceDto;
import com.jdbc.exam.enums.ParkingPlaceEnums;
import com.jdbc.exam.service.impl.ParkingPlaceServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("parking-spots/")
public class ParkingPlaceController {
    private final ParkingPlaceServiceImpl service;

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "You have created parking place successfully ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = CreateParkingPlaceDto.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed to add place to database")
    })
    @Operation(summary = "This road creates parking place")
    @PostMapping("create")
    public ResponseEntity<CreateParkingPlaceDto> createParkingPlace(@RequestBody CreateParkingPlaceDto parkingPlaceDto){
        try{
            return new ResponseEntity<>(service.create(parkingPlaceDto), HttpStatus.CREATED);
        }catch (RuntimeException runtimeException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
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
