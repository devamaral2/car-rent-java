package com.fiap.amaralrentcar.repository;

import com.fiap.amaralrentcar.entity.Rent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface RentRepository extends JpaRepository<Rent, UUID> {
    @Query("SELECT r FROM Rent r WHERE ((r.car.id = :carId) OR (r.client.id = :clientId)) AND r.endDate IS NULL")
    List<Rent> findActiveRentByCarIdOrClientId(@Param("carId") UUID carId, @Param("clientId") UUID clientId);
}
