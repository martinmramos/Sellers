package com.example.sellers.controllers;

import com.example.sellers.controllers.DTO_DataTransferObject.SellerInput;
import com.example.sellers.controllers.DTO_DataTransferObject.SellerOutput;
import com.example.sellers.controllers.DTO_DataTransferObject.SellerUpdate;
import com.example.sellers.domain.Concessionaire;
import com.example.sellers.domain.Seller;
import com.example.sellers.domain.personalExceptions.SellerExistsException;
import com.example.sellers.domain.personalExceptions.SellerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@RestController
public class SellerController {

    @GetMapping("/sellers")
    public ResponseEntity<List<SellerOutput>> getSeller() {
        if (Concessionaire.getListSellers().isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(getDataSellers(Concessionaire.getListSellers()));
    }

    @PostMapping("/sellers")
    public ResponseEntity<String> addSeller(@Valid @RequestBody SellerInput seller) {
        try {
            Concessionaire.addSeller(seller.toDomain());
        } catch (SellerExistsException e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        } catch (Exception e1) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/sellers/{dni}")
    public ResponseEntity<String> updateSeller(@PathVariable String dni, @Valid @RequestBody SellerUpdate seller) {
        try {
            Concessionaire.updateSeller(seller.toDomain(dni));
        } catch (SellerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        } catch (Exception e1) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/sellers/{dni}")
    public ResponseEntity<String> deleteSeller(@PathVariable String dni) {
        try {
            Concessionaire.deleteSeller(dni);
        } catch (SellerNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        } catch (Exception e1) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.accepted().build();
    }

    public List<SellerOutput> getDataSellers(HashMap<String, Seller> listSellers) {
        List<SellerOutput> outputList = new ArrayList<>();
        for (Seller seller : listSellers.values()) {
            outputList.add(SellerOutput.fromDomain(seller));
        }
        return outputList;
    }
}

