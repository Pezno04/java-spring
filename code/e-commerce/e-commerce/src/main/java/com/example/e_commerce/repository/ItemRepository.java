package com.example.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.e_commerce.model.Item;
import java.util.List;

public interface ItemRepository extends JpaRepository<Item, Long> {
    // buscar itens por fornecedor
    List<Item> findByFornecedorId(Long fornecedorId);
}