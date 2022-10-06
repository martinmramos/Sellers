package com.example.sellers.controllers;

import com.example.sellers.domain.Booking;
import com.example.sellers.domain.personalExceptions.*;
import com.example.sellers.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    private BookingRepository bookingRepository;

    @PostMapping("/bookings/clients/{dni}/cars/{numPlate}")
    public ResponseEntity<String> bookCar(@PathVariable String dni, @PathVariable String numPlate) {
        try {
            if (!bookingRepository.existsByNumPlate(numPlate)) {
                bookingRepository.save(new Booking(numPlate, dni));
            } else throw new BookingExistsException("Coche ya reservado.");
        } catch (BookingExistsException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception e1) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/bookings/clients/{dni}/cars/{numPlate}")
    public ResponseEntity<String> deleteBookCar(@PathVariable String dni, @PathVariable String numPlate) {
        try {
            if (!bookingRepository.existsByNumPlateAndDni(numPlate, dni))
                throw new BookingNotFoundException("No existe la reserva.");
            bookingRepository.deleteById(numPlate);
        } catch (BookingNotFoundException e) {
            return ResponseEntity.noContent().build();
        } catch (Exception e1) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
