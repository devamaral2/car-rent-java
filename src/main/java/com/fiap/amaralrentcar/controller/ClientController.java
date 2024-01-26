package com.fiap.amaralrentcar.controller;

import com.fiap.amaralrentcar.controller.Exception.ValidationTrigger;
import com.fiap.amaralrentcar.dtos.ClientDto;
import com.fiap.amaralrentcar.entity.Client;
import com.fiap.amaralrentcar.service.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


@RestController
public class ClientController {
    Logger logger = Logger.getLogger("ClientController");
    @Autowired
    private ClientService clientService;

    @PostMapping("/client")
    public ResponseEntity<ClientDto> create(@RequestBody @Valid ClientDto client, BindingResult bindingResult) {
        new ValidationTrigger(bindingResult).verify();
        return ResponseEntity.status(HttpStatus.CREATED).body(clientService.create(client));
    }

}