package com.fiap.amaralrentcar.service;

import java.util.ArrayList;
import java.util.List;

import com.fiap.amaralrentcar.entity.CarCreateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fiap.amaralrentcar.entity.Car;
import com.fiap.amaralrentcar.repository.CarRepository;

@Service
public class CarService {
    
    @Autowired
    private CarRepository carRepository;

    public List<Car> GetAllCars(){

        Iterable<Car> carIterable = carRepository.findAll();

        List<Car> result = new ArrayList<Car>();
        carIterable.forEach(result::add);

        return result;
    }

    public Car CreateCar(CarCreateDto carCreateDto) {
        Car car = new Car(carCreateDto.name);
        return carRepository.save(car);

    }

}
