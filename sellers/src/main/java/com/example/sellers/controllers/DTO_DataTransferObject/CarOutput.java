package com.example.sellers.controllers.DTO_DataTransferObject;

import com.example.sellers.domain.CarStatus;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarOutput {

    @NotNull(message = "Attribute is null.")
    @NotBlank(message = "Attribute is empty.")
    private String brand, model;
    private CarStatus status;

    public CarOutput(String brand, String model, CarStatus status) {
        this.brand = brand;
        this.model = model;
        this.status = status;
    }

    public CarOutput() {
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public CarStatus getStatus() {
        return status;
    }

}
