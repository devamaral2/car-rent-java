package com.fiap.amaralrentcar.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "rents")
@Getter
@Setter
@Builder
@RequiredArgsConstructor
@AllArgsConstructor
public class Rent {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @Column(name = "start_date")
    public LocalDateTime startDate;

    @Column(name = "expected_end_date")
    public LocalDateTime expectedEndDate;

    @Column(name = "end_date")
    public LocalDateTime endDate;

    @ManyToOne
    @JoinColumn(name = "car_id")
    public Car car;

    @ManyToOne
    @JoinColumn(name = "client_id")
    public Client client;

}
