package com.fiap.amaralrentcar.repository;

import java.util.List;
import java.util.UUID;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.fiap.amaralrentcar.entity.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
    @Query(value = "SELECT c FROM Car c WHERE c NOT IN " +
            "(SELECT r.car FROM Rent r WHERE r.startDate <= CURRENT_TIMESTAMP AND r.endDate >= CURRENT_TIMESTAMP) " +
            "AND c.status != 'reserved'")
    List<Car> findAvailableCars();
}
