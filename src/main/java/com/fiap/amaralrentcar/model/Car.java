package com.fiap.amaralrentcar.model;

import java.util.UUID;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Car {

    @Id
    public UUID id;
    
    public String name;


    public  Car(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public Car() {
        this.id = UUID.randomUUID();
    }
}
