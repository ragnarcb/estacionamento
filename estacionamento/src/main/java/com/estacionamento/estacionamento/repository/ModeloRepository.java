package com.estacionamento.estacionamento.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estacionamento.estacionamento.entities.Modelo;

@Repository
public interface ModeloRepository extends JpaRepository<Modelo, Long> {
    
    // @Query("SELECT m FROM Modelo m WHERE m.fabricante.pais = :pais")
    // List<Modelo> findModelosByFabricantePais(String pais);

    @Query(value = "CALL modelo_fabricante(:pais)", nativeQuery = true)
    List<Modelo> findModelosByFabricantePais(String pais);
}
