package com.fiap.amaralrentcar.controller;

import com.fiap.amaralrentcar.controller.Exception.ControllerNotFoundException;
import com.fiap.amaralrentcar.controller.Exception.ValidationTrigger;
import com.fiap.amaralrentcar.dtos.CarDto;
import com.fiap.amaralrentcar.dtos.CarStatusChangeDto;
import com.fiap.amaralrentcar.dtos.CarStatusChangeResponse;
import com.fiap.amaralrentcar.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;


@RestController("/car")
public class CarController {
    Logger logger = Logger.getLogger("CarController");
    @Autowired
    private CarService carService;

    @GetMapping("/")
//    Este metodo entrega uma lista com todos os carros que não estão sendo alugados e que também não estão reservvados por clientes
    public List<CarDto> findAvailableCars() {
        return carService.findAvailableCars();
    }

    @PutMapping("/change-status/{id}")
//    Este metodo reserva um carro toda vez que algum usuário escolhe um carro para iniciar uma compra e também remove o mesmo caso o tempo de sessão expire ou o usuário finalize a sessão
    public CarStatusChangeResponse changeStatus(@PathVariable UUID id, @Valid CarStatusChangeDto carStatusChangeDto, BindingResult bindingResult) {
        new ValidationTrigger(bindingResult).verify();
        try {
            return carService.changeStatus(id, carStatusChangeDto);
        } catch (Exception e) {
            throw new ControllerNotFoundException(e.getMessage());
        }
    }

    @PostMapping("/")
    public ResponseEntity<CarDto> create(@RequestBody @Valid CarDto car, BindingResult bindingResult) {
        new ValidationTrigger(bindingResult).verify();
        CarDto createdCar = carService.create(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar);
    }

}
