package com.jdbc.exam.controller;

import com.jdbc.exam.dto.CreateParkingInteractionDto;
import com.jdbc.exam.service.impl.ParkingInteractionServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("interactions/")
public class ParkingInteractionController {
    private final ParkingInteractionServiceImpl service;


    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "Reservation created successfully ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed to add reservation to database")
    })
    @Operation(summary = "This road creates reservation")
    @PostMapping("reservePlace")
    public ResponseEntity<String> reservePlace(@RequestBody CreateParkingInteractionDto reservePlace){
        try{
            return new ResponseEntity<>(service.reservePlace(reservePlace), HttpStatus.CREATED);
        }catch (RuntimeException runtimeException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Reservation confirmed successfully ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(
                    responseCode = "404",
                    description = "Failed to confirm reservation")
    })
    @Operation(summary = "This road confirms reservation")
    @PutMapping("confirmReservationByOrderId")
    public ResponseEntity<String> confirmReservationByOrderId(@RequestParam Long orderId){
        try {
            return new ResponseEntity<>(service.confirmReservationByOrderId(orderId), HttpStatus.OK);
        }catch (EntityNotFoundException notFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "201",
                    description = "You have taken place successfully ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(
                    responseCode = "400",
                    description = "Failed to take place")
    })
    @Operation(summary = "This road is using for taking parking place")
    @PostMapping("takePlace")
    public ResponseEntity<String> takePlace(@RequestBody CreateParkingInteractionDto takePlace){
        try {
            return new ResponseEntity<>(service.takePlace(takePlace), HttpStatus.CREATED);
        }catch (RuntimeException runtimeException){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "You have released the place successfully ",
                    content = {@Content(mediaType = "application/json",
                            schema = @Schema(implementation = String.class))}),
            @ApiResponse(
                    responseCode = "404",
                    description = "Failed to release a place")
    })
    @Operation(summary = "This road releases parking place")
    @PutMapping("releaseParkingPlaceByOrderId")
    public ResponseEntity<String> releaseParkingPlace(@RequestParam Long orderId){
        try{
            return new ResponseEntity<>(service.releaseParkingPlace(orderId), HttpStatus.OK);
        }catch (EntityNotFoundException notFoundException){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
