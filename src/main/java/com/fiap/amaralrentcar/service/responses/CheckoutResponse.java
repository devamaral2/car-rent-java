package com.fiap.amaralrentcar.service.responses;

import com.fiap.amaralrentcar.entity.Rent;

public class CheckoutResponse {
    public String message;
    public String status;

    public CheckoutResponse(Rent rent) {
        if (rent.getExpectedEndDate().isBefore(rent.getEndDate())) {
            this.status = "late";
            this.message = "Este carro foi entregue fora da data esperada";
        } else {
            this.status = "ok";
            this.message = "Tudo certo! O cliente entregou o carro em dia";
        }
    }
}
