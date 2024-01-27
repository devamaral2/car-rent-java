package com.fiap.amaralrentcar.controller;

import com.fiap.amaralrentcar.controller.exception.ControllerNotFoundException;
import com.fiap.amaralrentcar.controller.exception.ValidationTrigger;
import com.fiap.amaralrentcar.dtos.CarDto;
import com.fiap.amaralrentcar.dtos.CarStatusChangeDto;
import com.fiap.amaralrentcar.service.CarService;
import com.fiap.amaralrentcar.service.responses.CarStatusChangeResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;


@RestController
public class CarController {
    Logger logger = Logger.getLogger("CarController");
    @Autowired
    private CarService carService;

    @GetMapping("/car")
    public List<CarDto> findAvailableCars() {
        return carService.findAvailableCars();
    }

    @PatchMapping("/car/change-status/{id}")
    public CarStatusChangeResponse changeStatus(
            @PathVariable UUID id,
            @RequestBody @Valid CarStatusChangeDto carStatusChangeDto,
            BindingResult bindingResult) {
        new ValidationTrigger(bindingResult).verify();
        try {
            return carService.changeStatus(id, carStatusChangeDto);
        } catch (Exception e) {
            throw new ControllerNotFoundException(e.getMessage());
        }
    }

    @PostMapping("/car")
    public CarDto create(@RequestBody @Valid CarDto car, BindingResult bindingResult) {
        logger.info("kalsjdalksjdlkajdslkjasdlkjadsjkl");
        new ValidationTrigger(bindingResult).verify();
        return carService.create(car);
    }

}
