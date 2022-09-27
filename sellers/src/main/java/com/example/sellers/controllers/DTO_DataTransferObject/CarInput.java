package com.example.sellers.controllers.DTO_DataTransferObject;

import com.example.sellers.domain.Car;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarInput extends CarUpdate {
    @NotNull(message = "Attribute is null.")
    @NotBlank(message = "Attribute is empty.")
    private String numPlate;

    public CarInput(String brand, String model, String numPlate) {
        super(brand, model);
        this.numPlate = numPlate;
    }

    public CarInput() {
    }

    public String getNumPlate() {
        return numPlate;
    }

    public void setNumPlate(String numPlate) {
        this.numPlate = numPlate;
    }

    public Car toDomain() {
        return new Car(this.getBrand(), this.getModel(), this.numPlate);
    }
}
