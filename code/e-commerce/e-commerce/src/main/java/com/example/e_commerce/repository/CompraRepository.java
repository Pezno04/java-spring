package com.example.e_commerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.e_commerce.model.Compra;
import java.util.List;

public interface CompraRepository extends JpaRepository<Compra, Long> {

    List<Compra> findByUsuarioId(long id);

    @Query("""
        SELECT DISTINCT c
        FROM Compra c
        JOIN c.itensCompraLista ic
        JOIN ic.item i
        WHERE i.fornecedor.id = :fornecedorId
    """)
    List<Compra> findComprasByFornecedorId(Long fornecedorId);


}
