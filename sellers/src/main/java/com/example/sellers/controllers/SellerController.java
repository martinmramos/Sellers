package com.example.sellers.controllers;

import com.example.sellers.domain.Concessionaire;
import com.example.sellers.domain.ExceptionInvalidParameter;
import com.example.sellers.domain.Seller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class SellerController {

    @GetMapping("/sellers")
    public ResponseEntity<List<Seller>> getSeller() {
        return ResponseEntity.ok(Concessionaire.viewSellersList());
    }

    @PostMapping("/sellers")
    public void addSeller(@Valid @RequestBody Seller seller) {
        try {
            Concessionaire.addSeller(seller);
        } catch (ExceptionInvalidParameter e) {
            e.printStackTrace();
        }
    }

    @PutMapping("/sellers/{id}")
    public void updateSeller(@PathVariable String id, @Valid @RequestBody SellerUpdate seller) {
        try {
            Concessionaire.updateSeller(seller.getName(), seller.getAddress(), id, seller.getPhone());
        } catch (ExceptionInvalidParameter e) {
            e.printStackTrace();
        }
    }

    @DeleteMapping("/sellers/{id}")
    public void deleteSeller(@PathVariable String id) {
        try {
            Concessionaire.deleteSeller(id);
        } catch (ExceptionInvalidParameter e) {
            e.printStackTrace();
        }
    }
}

