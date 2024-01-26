package com.fiap.amaralrentcar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "cars")
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    public String plate;

    public StatusEnum status;

    public String model;

    public String year;

    public String color;

    public Integer km;

    public String imageUrl;

    public String carType;

    public Double price;

    public Double power;

    public String numberOfPassengers;

    public Double fuelComsumption;

    public String trunkCapacity;

    @OneToMany(mappedBy = "car")
    public List<Rent> rents;
}
