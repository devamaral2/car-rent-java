package com.fiap.amaralrentcar.service;

import com.fiap.amaralrentcar.entity.Car;
import com.fiap.amaralrentcar.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> findAll() {

        Iterable<Car> carIterable = carRepository.findAll();

        List<Car> result = new ArrayList<Car>();
        carIterable.forEach(result::add);
        return result;

//        var cars = carRepository.findAll();
//
//        return cars.stream().map(this::toCarDto).collect(Collectors.toList());
    }

//    private CarCreateDto toCarDto(Car car) {
//        return new CarCreateDto.CarCreateDtoBuilder().plate('x3pto').build()
//        )
//    }

    public Car create(Car car) {
        return carRepository.save(car);

    }

}
