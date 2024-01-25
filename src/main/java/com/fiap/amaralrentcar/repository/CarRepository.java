package com.fiap.amaralrentcar.repository;

import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fiap.amaralrentcar.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
}
