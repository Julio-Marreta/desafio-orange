package com.example.desafioorange.usuario;

import com.example.desafioorange.exceptions.UsuarioNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository userRepository;

    public Usuario findById(Long id) throws UsuarioNotFoundException {
        return userRepository.findById(id).orElseThrow(UsuarioNotFoundException::new);
    }

    public Usuario save(Usuario user) {
        return userRepository.save(user);
    }
}
