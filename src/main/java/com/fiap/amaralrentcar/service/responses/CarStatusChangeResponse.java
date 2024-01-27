package com.fiap.amaralrentcar.service.responses;

public class CarStatusChangeResponse {
    public String message;
    public String status;

    public CarStatusChangeResponse(String status) {
        this.status = status;
        if (status == "available") {
            this.message = "Este carro agora está disponível para ser alugado";
        } else {
            this.message = "Um cliente acrescentou este carro na sua lista de compras";
        }
    }
}
