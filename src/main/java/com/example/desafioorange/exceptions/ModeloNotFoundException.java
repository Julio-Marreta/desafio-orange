package com.example.desafioorange.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Modelo não encontrado.")
public class ModeloNotFoundException extends Exception{

    public ModeloNotFoundException(){
        super();
    }
}
