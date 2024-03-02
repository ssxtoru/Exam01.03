package com.jdbc.exam.service;

import com.jdbc.exam.dto.CreateParkingInteractionDto;

public interface ParkingInteractionService {
    String reservePlace(CreateParkingInteractionDto reservePlace);
    String confirmReservationByOrderId(Long orderId);

    String takePlace(CreateParkingInteractionDto takePlace);

    String releaseParkingPlace(Long orderId);
}
