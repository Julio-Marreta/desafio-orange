package com.example.desafioorange.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Marca não encontrada.")
public class MarcaNotFoundException extends Exception{

    public MarcaNotFoundException(){
        super();
    }
}
