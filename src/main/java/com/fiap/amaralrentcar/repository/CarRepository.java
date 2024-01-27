package com.fiap.amaralrentcar.repository;

import com.fiap.amaralrentcar.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CarRepository extends JpaRepository<Car, UUID> {
    @Query(value = "SELECT c FROM Car c WHERE c NOT IN " +
            "(SELECT r.car FROM Rent r WHERE r.endDate IS NULL) " +
            "AND c.status != 'reserved'")
    List<Car> findAvailableCars();
}
