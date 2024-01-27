package com.fiap.amaralrentcar.controller;

import com.fiap.amaralrentcar.controller.exception.BadRequestException;
import com.fiap.amaralrentcar.controller.exception.ControllerNotFoundException;
import com.fiap.amaralrentcar.controller.exception.ValidationTrigger;
import com.fiap.amaralrentcar.dtos.CheckoutDto;
import com.fiap.amaralrentcar.dtos.RentDto;
import com.fiap.amaralrentcar.service.RentService;
import com.fiap.amaralrentcar.service.responses.CheckoutResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;

@RestController
public class RentController {
    Logger logger = Logger.getLogger("ClientController");
    @Autowired
    private RentService rentService;

    @GetMapping("/rent")
    public List<RentDto> checkout() {
        return rentService.findAll();
    }

    @PatchMapping("/rent/checkout/{id}")
    public CheckoutResponse checkout(
            @PathVariable UUID id,
            @RequestBody @Valid CheckoutDto checkoutDto,
            BindingResult bindingResult) {
        new ValidationTrigger(bindingResult).verify();
        try {
            return rentService.checkout(id, checkoutDto);
        } catch (Exception e) {
            throw new ControllerNotFoundException(e.getMessage());
        }
    }

    @PostMapping("/rent")
    public ResponseEntity<RentDto> insertRecord(@RequestBody @Valid RentDto rent, BindingResult bindingResult) throws Exception {
        new ValidationTrigger(bindingResult).verify();
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(rentService.insertRecord(rent));
        } catch (Exception e) {
            throw new BadRequestException(e.getMessage());
        }
    }

}