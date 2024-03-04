package com.jdbc.exam.service.impl;

import com.jdbc.exam.dto.CreateParkingPlaceDto;
import com.jdbc.exam.dto.ParkingPlaceDto;
import com.jdbc.exam.entity.ParkingPlace;
import com.jdbc.exam.enums.ParkingPlaceEnums;
import com.jdbc.exam.enums.ParkingPlaceStatus;
import com.jdbc.exam.repo.ParkingPlaceRepo;
import com.jdbc.exam.service.ParkingPlaceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ParkingPlaceServiceImpl implements ParkingPlaceService {
    private final ParkingPlaceRepo parkingPlaceRepo;
    @Override
    public List<ParkingPlaceDto> findAll() {
        List<ParkingPlace> parkingPlaceEntities = parkingPlaceRepo.findAll();

        List<ParkingPlaceDto> parkingPlaceDtos = new ArrayList<>();
        for(ParkingPlace parkingPlace : parkingPlaceEntities){
            ParkingPlaceDto parkingPlaceDto = ParkingPlaceDto.builder()
                    .id(parkingPlace.getId())
                    .parkingLot(parkingPlace.getParkingLot())
                    .placeEnums(parkingPlace.getPlaceEnums())
                    .status(parkingPlace.getStatus())
                            .build();
            parkingPlaceDtos.add(parkingPlaceDto);
        }
        return parkingPlaceDtos;
    }

    @Override
    public ParkingPlaceDto findParkingLot(Long id) {
        ParkingPlace parkingPlace = parkingPlaceRepo.findById(id).orElseThrow(()->new EntityNotFoundException(""));

        return ParkingPlaceDto.builder()
                .id(parkingPlace.getId())
                .parkingLot(parkingPlace.getParkingLot())
                .placeEnums(parkingPlace.getPlaceEnums())
                .status(parkingPlace.getStatus())
                .build();
    }

    @Override
    public List<ParkingPlaceDto> findParkingLotType(ParkingPlaceEnums placeEnums) {
        List<ParkingPlace> parkingPlaceEntities = parkingPlaceRepo.findParkingPlaceByType(placeEnums);

        List<ParkingPlaceDto> parkingPlaceDtos = new ArrayList<>();
        for(ParkingPlace parkingPlace : parkingPlaceEntities){
            ParkingPlaceDto parkingPlaceDto = ParkingPlaceDto.builder()
                    .id(parkingPlace.getId())
                    .parkingLot(parkingPlace.getParkingLot())
                    .placeEnums(parkingPlace.getPlaceEnums())
                    .status(parkingPlace.getStatus())
                    .build();
            parkingPlaceDtos.add(parkingPlaceDto);
        }
        return parkingPlaceDtos;
    }

    @Override
    public List<ParkingPlaceDto> findNotReservedLot() {
        List<ParkingPlace> parkingPlaces = parkingPlaceRepo.findAllNotReserved();

        List<ParkingPlaceDto> parkingPlaceDtos = new ArrayList<>();
        for(ParkingPlace parkingPlace : parkingPlaces){
            ParkingPlaceDto parkingPlaceDto = ParkingPlaceDto.builder()
                    .id(parkingPlace.getId())
                    .parkingLot(parkingPlace.getParkingLot())
                    .placeEnums(parkingPlace.getPlaceEnums())
                    .status(parkingPlace.getStatus())
                    .build();
            parkingPlaceDtos.add(parkingPlaceDto);
        }
        return parkingPlaceDtos;
    }

    @Override
    public CreateParkingPlaceDto create(CreateParkingPlaceDto parkingPlaceToCreate) throws RuntimeException {
        try{ ParkingPlace parkingPlaceEntity = ParkingPlace.builder()
                .parkingLot(parkingPlaceToCreate.getSpotNumber())
                .placeEnums(parkingPlaceToCreate.getParkingPlaceEnums())
                .status(ParkingPlaceStatus.EMPTY)
                .build();
            parkingPlaceRepo.save(parkingPlaceEntity);
        }catch (Exception e){
            throw new RuntimeException();
        }
        return parkingPlaceToCreate;
    }



    @Override
    public void deleteById(Long id) {
        parkingPlaceRepo.deleteById(id);
    }
}
