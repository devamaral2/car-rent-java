package com.fiap.amaralrentcar.service;

import com.fiap.amaralrentcar.dtos.CarDto;
import com.fiap.amaralrentcar.dtos.CarStatusChangeDto;
import com.fiap.amaralrentcar.entity.Car;
import com.fiap.amaralrentcar.repository.CarRepository;
import com.fiap.amaralrentcar.service.responses.CarStatusChangeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class CarService {
    Logger logger = Logger.getLogger("CarController");

    @Autowired
    private CarRepository carRepository;

    public List<CarDto> findAvailableCars() {
        var cars = carRepository.findAvailableCars();
        return cars.stream().map(this::toCarDto).collect(Collectors.toList());
    }

    public CarStatusChangeResponse changeStatus(UUID id, CarStatusChangeDto carStatusChangeDto) throws Exception {
        Optional<Car> car = carRepository.findById(id);
        if (car.isPresent()) {
            Car carToUpdate = car.get();
            carToUpdate.setStatus(carStatusChangeDto.status());
            carRepository.save(carToUpdate);
            return new CarStatusChangeResponse(carStatusChangeDto.status());
        } else {
            throw new Exception("Não existe um carro com esta referência no banco de dados");
        }

    }

    private Car toCarClass(CarDto carDto) {
        return Car.builder()
                .plate(carDto.plate())
                .status(carDto.status())
                .model(carDto.model())
                .year(carDto.year())
                .color(carDto.color())
                .km(carDto.km())
                .imageUrl((carDto.imageUrl()))
                .carType(carDto.carType())
                .price(carDto.price())
                .power(carDto.power())
                .numberOfPassengers(carDto.numberOfPassengers())
                .trunkCapacity(carDto.trunkCapacity())
                .build();
    }

    private CarDto toCarDto(Car car) {
        return new CarDto(
                car.getPlate(),
                car.getStatus(),
                car.getModel(),
                car.getYear(),
                car.getColor(),
                car.getKm(),
                car.getImageUrl(),
                car.getCarType(),
                car.getPrice(),
                car.getPower(),
                car.getNumberOfPassengers(),
                car.getFuelConsumption(),
                car.getTrunkCapacity());
    }

    public CarDto create(CarDto car) {
        Car carCreated = carRepository.save(toCarClass(car));
        logger.info(carCreated.toString());
        return toCarDto(carCreated);
    }

}
