package com.example.e_commerce.model;

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

    private String nome;
    private double valor;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "fornecedor_id", nullable = false)
    private Usuario fornecedor;
}