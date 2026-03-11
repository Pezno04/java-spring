package com.example.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.e_commerce.model.item_compra.ItemCompra;

public interface ItemCompraRepository extends JpaRepository<ItemCompra, Long> {

}