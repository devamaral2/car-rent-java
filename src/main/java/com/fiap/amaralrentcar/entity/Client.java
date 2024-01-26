package com.fiap.amaralrentcar.entity;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "clients")
@Builder
@Getter
@Setter
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public UUID id;

    @NotBlank
    public String email;

    @Nullable
    public String name;

    @OneToMany(mappedBy = "client")
    public List<Rent> rents;
}
