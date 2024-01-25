package com.fiap.amaralrentcar.entity;

import java.util.UUID;


import jakarta.persistence.*;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;
    public String plate;
    public String status;


    public  Car(String plate) {
        this.plate = plate;
        this.status = "avaliable";
    }

    public Car() {
        this.status = "avaliable";
    }

    public UUID getId() {
        return id;
    }

    public String getPlate() {
        return plate;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
