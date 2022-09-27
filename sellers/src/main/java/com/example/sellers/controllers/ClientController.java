package com.example.sellers.controllers;

import com.example.sellers.controllers.JSONClients.ClientInput;
import com.example.sellers.controllers.JSONClients.ClientOutput;
import com.example.sellers.controllers.JSONClients.ClientUpdate;
import com.example.sellers.domain.Client;
import com.example.sellers.domain.Concessionaire;
import com.example.sellers.domain.personalExceptions.ExceptionInvalidParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/clients")
    public ResponseEntity<List<ClientOutput>> getClients() {
        if (Concessionaire.getListClients().isEmpty()){
            return ResponseEntity.notFound().build();
        }
        List <ClientOutput> outputList = new ArrayList<>();
        for (Client client:Concessionaire.getListClients().values()){
            outputList.add(new ClientOutput(client.getName(), client.getDni(), client.getPhone()));
        }
        return ResponseEntity.ok(outputList);
    }

    @PostMapping("/clients")
    public ResponseEntity<String> addClient(@Valid @RequestBody ClientInput client) {
        try {
            Concessionaire.addClient(client.toDomain());
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.status(HttpStatus.PRECONDITION_FAILED).build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/clients/{dni}")
    public ResponseEntity<String> updateClient(@PathVariable String dni, @Valid @RequestBody ClientUpdate client) {
        try {
            Concessionaire.updateClient(client.toDomain(dni));
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).build();
        }
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/clients/{dni}")
    public ResponseEntity<String> deleteClient(@PathVariable String dni) {
        try {
            Concessionaire.deleteClient(dni);
        } catch (ExceptionInvalidParameter e) {
            return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).build();
        }
        return ResponseEntity.accepted().build();
    }
}
