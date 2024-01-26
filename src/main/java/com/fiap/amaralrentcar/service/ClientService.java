package com.fiap.amaralrentcar.service;

import com.fiap.amaralrentcar.dtos.ClientCreateDto;
import com.fiap.amaralrentcar.entity.Client;
import com.fiap.amaralrentcar.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

@Service
public class ClientService {
    Logger logger = Logger.getLogger("ClientService");

    @Autowired
    private ClientRepository clientRepository;

    public List<Client> findAll() {

        Iterable<Client> clientIterable = clientRepository.findAll();

        List<Client> result = new ArrayList<Client>();
        clientIterable.forEach(result::add);
        return result;

//        var cars = clientRepository.findAll();
//
//        return cars.stream().map(this::toCarDto).collect(Collectors.toList());
    }

//    private CarCreateDto toCarDto(Client car) {
//        return new CarCreateDto.CarCreateDtoBuilder().plate('x3pto').build()
//        )
//    }

    public Client create(ClientCreateDto clientCreateDto) {
        Client client = Client
                .builder()
                .email(clientCreateDto.email())
                .name(clientCreateDto.name())
                .build();

        return clientRepository.save(client);

    }
}
