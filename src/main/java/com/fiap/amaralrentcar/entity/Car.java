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
@ToString
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    public String plate;

    public String status;

    public String model;

    public String year;

    public String color;

    public Integer km;

    @Column(name = "image_url")
    public String imageUrl;

    @Column(name = "car_type")
    public String carType;

    public Double price;

    public Double power;

    @Column(name = "number_of_passengers")
    public Integer numberOfPassengers;

    @Column(name = "fuel_consumption")
    public Double fuelConsumption;

    @Column(name = "trunk_capacity")
    public String trunkCapacity;

    @OneToMany(mappedBy = "car")
    public List<Rent> rents;
}
