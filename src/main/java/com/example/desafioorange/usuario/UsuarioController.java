package com.example.desafioorange.usuario;

import com.example.desafioorange.exceptions.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService userService;

    @GetMapping("/{id}")
    public Usuario findByid(@PathVariable("id") Long id) throws UsuarioNotFoundException {
        return userService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario save(@RequestBody Usuario user) {
        return userService.save(user);
    }
}
