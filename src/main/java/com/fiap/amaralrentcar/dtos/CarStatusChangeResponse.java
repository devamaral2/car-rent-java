package com.fiap.amaralrentcar.dtos;

import com.fiap.amaralrentcar.entity.StatusEnum;


public class CarStatusChangeResponse {
    private final String message;
    private final StatusEnum status;

    public CarStatusChangeResponse(StatusEnum status) {
        this.status = status;
        if (status == StatusEnum.AVAILABLE) {
            this.message = "Este carro agora está disponível para ser alugado";
        } else {
            this.message = "Um cliente acrescentou este carro na sua lista de compras";
        }
    }
}
