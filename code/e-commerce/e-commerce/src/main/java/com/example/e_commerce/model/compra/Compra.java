package com.example.e_commerce.model.compra;

import com.example.e_commerce.model.item_compra.ItemCompra;
import com.example.e_commerce.model.usuario.Usuario;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.GenerationType;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;

import java.time.LocalDateTime;

import java.util.List;

import lombok.Data;

@Entity
@Data
public class Compra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    @Column(nullable = false)
    private double valorTotal;e

    @Column(nullable = false)
    private LocalDateTime dataAbertura;

    private LocalDateTime dataFinalizacao;

    @Enumerated(EnumType.STRING)
    private StatusCompra status;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL)   
    private List<ItemCompra> itensCompraLista;
}