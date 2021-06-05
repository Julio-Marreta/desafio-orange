package com.example.desafioorange.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Nenhum veículo desse ano encontrado.")
public class AnoDoVeiculoNotFoundException extends Exception{

    public AnoDoVeiculoNotFoundException(){
        super();
    }
}
