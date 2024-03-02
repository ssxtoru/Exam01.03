package com.jdbc.exam.repo;

import com.jdbc.exam.entity.ParkingPlace;
import com.jdbc.exam.entity.User;
import com.jdbc.exam.enums.ParkingPlaceEnums;
import com.jdbc.exam.enums.ParkingPlaceStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParkingPlaceRepo extends JpaRepository<ParkingPlace, Long> {
    @Query("select p from ParkingPlace p " +
            "where p.status = com.jdbc.exam.enums.ParkingPlaceStatus.EMPTY")
    List<ParkingPlace> findAllNotReserved();

    @Query("select p from ParkingPlace p " +
            "where p.placeEnums = :type ")
    List <ParkingPlace> findParkingPlaceByType(@Param("type") ParkingPlaceEnums parkingPlaceEnums);
    @Query("select p from  ParkingPlace p " +
            "where p.status = com.jdbc.exam.enums.ParkingPlaceStatus.EMPTY and p.id = :id")
    ParkingPlace findAvailablePlaceById(@Param("id")Long id);
}
