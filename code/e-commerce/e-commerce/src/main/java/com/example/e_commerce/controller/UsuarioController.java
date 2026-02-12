package com.example.e_commerce.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;
import com.example.e_commerce.model.Usuario;
import com.example.e_commerce.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // listar todos os usuários
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // cria um novo usuário
    @PostMapping
    public Usuario criarUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

}
