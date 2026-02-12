package com.example.e_commerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.e_commerce.model.Item;
import com.example.e_commerce.repository.ItemCompraRepository;
import com.example.e_commerce.repository.ItemRepository;

import com.example.e_commerce.model.ItemCompra;

@RestController
@RequestMapping("/item-compra")
public class ItemCompraController {

    @Autowired
    private ItemCompraRepository itemCompraRepository;

    @Autowired
    private ItemRepository itemRepository;
    
    @GetMapping
    public List<ItemCompra> listaItemCompras() {
        return itemCompraRepository.findAll();
    }

    @PostMapping("{itemId}/{quantidade}")
    public ItemCompra criarItemCompra(@PathVariable Long itemId,
                                      @PathVariable int quantidade) {
        
        Item item = itemRepository.findById(itemId)
                .orElseThrow(() -> new RuntimeException("Item não encontrado"));

        ItemCompra itemCompra = new ItemCompra();
        itemCompra.setItem(item);
        itemCompra.setQuantidade(quantidade);   

        return itemCompraRepository.save(itemCompra);
    }
}