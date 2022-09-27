package com.example.sellers.controllers;

import com.example.sellers.controllers.JSONSellers.SellerInput;
import com.example.sellers.controllers.JSONSellers.SellerOutput;
import com.example.sellers.controllers.JSONSellers.SellerUpdate;
import com.example.sellers.domain.Concessionaire;
import com.example.sellers.domain.personalExceptions.ExceptionInvalidParameter;
import com.example.sellers.domain.Seller;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
public class SellerController {

    @GetMapping("/sellers")
    public ResponseEntity<List<SellerOutput>> getSeller() {
        if (Concessionaire.getListSellers().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        List<SellerOutput> outputList = new ArrayList<>();
        for (Seller seller : Concessionaire.getListSellers().values()) {
            outputList.add(new SellerOutput(seller.getName(), seller.getDni(), seller.getPhone()));
        }
        return ResponseEntity.ok(outputList);
    }

    @PostMapping("/sellers")
    public ResponseEntity<String> addSeller(@Valid @RequestBody SellerInput seller) {
        try {
            Concessionaire.addSeller(seller.toDomain());
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/sellers/{dni}")
    public ResponseEntity<String> updateSeller(@PathVariable String dni, @Valid @RequestBody SellerUpdate seller) {
        try {
            Concessionaire.updateSeller(seller.toDomain(dni));
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/sellers/{dni}")
    public ResponseEntity<String> deleteSeller(@PathVariable String dni) {
        try {
            Concessionaire.deleteSeller(dni);
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.accepted().build();
    }
}

