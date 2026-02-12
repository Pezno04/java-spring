package com.example.e_commerce.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.Column;

import lombok.Data;

@Entity
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    @Column(unique = true)
    private String email;

    private String senha;

    @Enumerated(EnumType.STRING)
    private TipoUsuario tipoUsuario;
}