package com.fiap.amaralrentcar.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "rents")
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    public LocalDateTime startDate;

    public LocalDateTime expectedEndDate;

    public LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    public Car car;

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client client;

}
