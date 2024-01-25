package com.fiap.amaralrentcar.repository;

import java.util.Iterator;
import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fiap.amaralrentcar.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
}
