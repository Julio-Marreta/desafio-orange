package com.example.desafioorange.veiculo;

import com.example.desafioorange.exceptions.AnoDoVeiculoNotFoundException;
import com.example.desafioorange.exceptions.MarcaNotFoundException;
import com.example.desafioorange.exceptions.ModeloNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService service;

    @PostMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Veiculo saveVehicle(@RequestBody Veiculo veiculo, @PathVariable("id") Long id) throws MarcaNotFoundException,
            ModeloNotFoundException, AnoDoVeiculoNotFoundException {
        return service.save(veiculo, id);
    }
}
