package com.example.e_commerce.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.e_commerce.model.Compra;
import com.example.e_commerce.repository.CompraRepository;
import com.example.e_commerce.model.ItemCompra;
import com.example.e_commerce.repository.UsuarioRepository;
import com.example.e_commerce.model.Usuario;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/compras")
public class CompraController {

    @Autowired
    private CompraRepository compraRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // lista todas as compras
    @GetMapping
    public List<Compra> listarCompras() {
        return compraRepository.findAll();
    }

    // cria uma nova compra
    @PostMapping
    public Compra criarCompra(@RequestBody Compra compra){
        Usuario usuario = usuarioRepository.findById(compra.getUsuario().getId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        compra.setUsuario(usuario);
        compra.setDataCompra(LocalDateTime.now());

        for (ItemCompra item : compra.getItensCompraLista()) {
            item.setCompra(compra);
        }

        return compraRepository.save(compra);
    }

    // lista compras por usuário
    @GetMapping("/{usuarioId}")
    public List<Compra> listarComprasPorUsuario(@PathVariable Long usuarioId) {
        return compraRepository.findByUsuarioId(usuarioId);
    }
    
}