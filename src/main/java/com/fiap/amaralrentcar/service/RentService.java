package com.fiap.amaralrentcar.service;

import com.fiap.amaralrentcar.dtos.CheckoutDto;
import com.fiap.amaralrentcar.dtos.RentDto;
import com.fiap.amaralrentcar.entity.Car;
import com.fiap.amaralrentcar.entity.Client;
import com.fiap.amaralrentcar.entity.Rent;
import com.fiap.amaralrentcar.repository.CarRepository;
import com.fiap.amaralrentcar.repository.ClientRepository;
import com.fiap.amaralrentcar.repository.RentRepository;
import com.fiap.amaralrentcar.service.responses.CheckoutResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class RentService {
    Logger logger = Logger.getLogger("CarController");

    @Autowired
    private RentRepository rentRepository;

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private ClientRepository clientRepository;

    private Rent toRentClass(RentDto rentDto) throws Exception {
        Optional<Car> car = carRepository.findById(rentDto.carId());
        if (car.isEmpty()) {
            throw new Exception("Não existe um car com esta referência no banco de dados");
        }
        Optional<Client> client = clientRepository.findById(rentDto.clientId());
        if (client.isEmpty()) {
            throw new Exception("Não existe um client com esta referência no banco de dados");
        }

        return Rent
                .builder()
                .startDate(rentDto.startDate())
                .expectedEndDate(rentDto.expectedEndDate())
                .car(car.get())
                .client(client.get())
                .build();
    }

    private RentDto toRentDto(Rent rent) {
        return new RentDto(
                rent.getStartDate(),
                rent.getExpectedEndDate(),
                rent.getCar().getId(),
                rent.getClient().getId()
        );
    }

    public List<RentDto> findAll() {
        var rents = rentRepository.findAll();
        return rents.stream().map(this::toRentDto).collect(Collectors.toList());
    }

    public CheckoutResponse checkout(UUID id, CheckoutDto checkoutDto) throws Exception {
        Optional<Rent> optionalRent = rentRepository.findById(id);
        if (optionalRent.isPresent()) {
            Rent rent = optionalRent.get();
            if (rent.getEndDate() != null) {
                throw new Exception("Esta rent já está fechada");
            }
            rent.setEndDate(checkoutDto.endDate());
            Car car = rent.getCar();
            car.setKm(checkoutDto.km());
            carRepository.save(car);
            rentRepository.save(rent);
            return new CheckoutResponse(rent);
        } else {
            throw new Exception("Não existe um aluguel com esta referência no banco de dados");
        }

    }

    public RentDto insertRecord(RentDto rentDto) throws Exception {
        LocalDateTime localTime = LocalDateTime.now();
        Rent rentToSave = toRentClass(rentDto);
        if (rentDto.startDate().isAfter(rentDto.expectedEndDate())) {
            throw new Exception("A data startDate deve ser anterior a data expectedEndDate");
        }
        List<Rent> rents = rentRepository.findActiveRentByCarIdOrClientId(rentDto.carId(), rentDto.clientId());
        if (!rents.isEmpty()) {
            throw new Exception("Já existe um aluguel ativo para este carro ou cliente");
        }
        Rent rent = rentRepository.save(rentToSave);
        return toRentDto(rent);
    }

}
