package com.example.e_commerce.model.item;

import com.example.e_commerce.model.usuario.Usuario;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private double valor;

    @Column(nullable = false)
    private int estoque;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Usuario fornecedor;
}