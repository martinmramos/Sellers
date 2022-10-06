package com.example.sellers.repositories;

import com.example.sellers.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, String> {
    boolean existsByNumPlate(String numPlate);

    boolean existsByDni(String dni);

    boolean existsByNumPlateAndDni(String numPlate, String dni);
}
