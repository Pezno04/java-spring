package com.example.e_commerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.e_commerce.model.Item;
import com.example.e_commerce.repository.ItemRepository;
import com.example.e_commerce.model.Usuario;
import com.example.e_commerce.repository.UsuarioRepository;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    // listar todos os itens
    @GetMapping
    public List<Item> listarItens() {
        return itemRepository.findAll();
    }

    // criar um novo item
    @PostMapping("/{nome}/{valor}/{quantidade}/{fornecedorId}")
    public Item criarItem(@PathVariable String nome,
                          @PathVariable double valor,
                          @PathVariable int quantidade,
                          @PathVariable Long fornecedorId) {

        // Verifica se o fornecedor existe e é realmente fornecedor
        Usuario fornecedor = usuarioRepository.findById(fornecedorId)
                .orElseThrow(() -> new RuntimeException("Fornecedor não encontrado"));

        if (fornecedor.getTipoUsuario() != null && !fornecedor.getTipoUsuario().toString().equals("FORNECEDOR")) {
            throw new RuntimeException("O usuário informado não é um fornecedor");
        }

        Item item = new Item();
        item.setNome(nome);
        item.setValor(valor);
        item.setQuantidade(quantidade);
        item.setFornecedor(fornecedor);

        return itemRepository.save(item);
    }

    // listar itens de um fornecedor específico
    @GetMapping("/{fornecedorId}")
    public List<Item> listarItensPorFornecedor(@PathVariable Long fornecedorId) {
        return itemRepository.findByFornecedorId(fornecedorId);
    }
}
