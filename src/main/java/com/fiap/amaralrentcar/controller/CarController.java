package com.fiap.amaralrentcar.controller;

import java.util.List;
import java.util.logging.Logger;

import com.fiap.amaralrentcar.entity.CarCreateDto;
import com.fiap.amaralrentcar.service.CarService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.fiap.amaralrentcar.entity.Car;


@RestController
public class CarController {
    Logger logger = Logger.getLogger("CarController");
    @Autowired
    private CarService carService;

    @GetMapping("/car")
    public List<Car> GetAllCars() {

        return carService.GetAllCars();
    }
//@PathVariable para pegar o id "/{:id}"

//    repo.findById(id).orElseThrow(() -> new ControllerNotFoundException("exception"))
//    try {} catch (EntityNotFoundException e) { throw new ControllerNotFoundException("não encontrado")}
    @PostMapping("/car")
    public Car CarCreate(@RequestBody CarCreateDto carToCreate) {
        Car car = carService.CreateCar(carToCreate);
        logger.info("abacate");
        return car;
    }

}
