package com.example.sellers.controllers;

import com.example.sellers.domain.Concessionaire;
import com.example.sellers.domain.personalExceptions.ExceptionInvalidParameter;
import com.example.sellers.domain.personalExceptions.StatusIncorrectException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @PostMapping("/bookings/clients/{dni}/cars/{numPlate}")
    public ResponseEntity<String> bookCar(@PathVariable String dni, @PathVariable String numPlate) {
        try {
            Concessionaire.bookCar(dni, numPlate);
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.noContent().build();
        } catch (StatusIncorrectException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @DeleteMapping("/bookings/clients/{dni}/cars/{numPlate}")
    public ResponseEntity<String> deleteBookCar(@PathVariable String dni, @PathVariable String numPlate) {
        try {
            Concessionaire.deleteBookCar(dni, numPlate);
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.noContent().build();
        } catch (StatusIncorrectException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
}
