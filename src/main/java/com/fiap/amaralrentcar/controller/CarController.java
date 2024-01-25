package com.fiap.amaralrentcar.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.fiap.amaralrentcar.model.CarCreateDto;
import com.fiap.amaralrentcar.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.amaralrentcar.model.Car;


@RestController
public class CarController {
    Logger logger = Logger.getLogger("CarController");
    @Autowired
    private CarService carService;

    @GetMapping("/car")
    public List<Car> GetAllCars() {

        return carService.GetAllCars();
    }

    @PostMapping("/car")
    public Car CarCreate(@RequestBody CarCreateDto carToCreate) {
        Car car = carService.CreateCar(carToCreate);
        logger.info("abacate");
        return car;
    }

}
