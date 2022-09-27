package com.example.sellers.controllers;

import com.example.sellers.controllers.DTO_DataTransferObject.CarInput;
import com.example.sellers.controllers.DTO_DataTransferObject.CarOutput;
import com.example.sellers.controllers.DTO_DataTransferObject.CarUpdate;
import com.example.sellers.domain.Car;
import com.example.sellers.domain.Concessionaire;
import com.example.sellers.domain.personalExceptions.ExceptionInvalidParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class CarController {

    @GetMapping("/cars")
    public ResponseEntity<List<CarOutput>> getCar() {
        if (Concessionaire.getListCars().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<CarOutput> outputList = new ArrayList<>();
        for (Car car : Concessionaire.getListCars().values()) {
            outputList.add(new CarOutput(car.getBrand(), car.getModel(), car.getStatus()));
        }
        return ResponseEntity.ok(outputList);
    }

    @PostMapping("/cars")
    public ResponseEntity<String> addCar(@Valid @RequestBody CarInput car) {
        try {
            Concessionaire.addCar(car.toDomain());
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/cars/{numPlate}")
    public ResponseEntity<String> updateCar(@PathVariable String numPlate, @Valid @RequestBody CarUpdate car) {
        try {
            Concessionaire.updateCar(car.toDomain(numPlate));
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/cars/{numPlate}")
    public ResponseEntity<String> deleteCar(@PathVariable String numPlate) {
        try {
            Concessionaire.deleteCar(numPlate);
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.accepted().build();
    }
}
