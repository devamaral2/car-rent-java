package com.fiap.amaralrentcar.controller;

import com.fiap.amaralrentcar.entity.Car;
import com.fiap.amaralrentcar.service.CarService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.logging.Logger;


@RestController
public class CarController {
    Logger logger = Logger.getLogger("CarController");
    @Autowired
    private CarService carService;

    @GetMapping("/car")
    public List<Car> GetAllCars() {

        return carService.findAll();
    }
//@PathVariable para pegar o id "/{:id}"

    //    repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("exception"))
//    try {} catch (EntityNotFoundException e) { throw new ControllerNotFoundException("não encontrado")}
    @PostMapping("/car")
    public ResponseEntity<String> create(@RequestBody @Valid Car car) {
        logger.info(car.toString());
        Car createdCar = carService.create(car);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCar.toString());
    }

}
