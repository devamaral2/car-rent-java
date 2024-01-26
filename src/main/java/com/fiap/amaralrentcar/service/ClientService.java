package com.fiap.amaralrentcar.service;

import com.fiap.amaralrentcar.dtos.ClientDto;
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

    private ClientDto toClientDto (Client client) {
         return new ClientDto(client.email, client.name);
    }

    private Client toClientClass (ClientDto clientDto) {
        return Client
                .builder()
                .email(clientDto.email())
                .name(clientDto.name())
                .build();
    }

    public ClientDto create(ClientDto clientDto) {
        Client savedClient = clientRepository.save(toClientClass(clientDto));
        return toClientDto(savedClient);
    }
}
