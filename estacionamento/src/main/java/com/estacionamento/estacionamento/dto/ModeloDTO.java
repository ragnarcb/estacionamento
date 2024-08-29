package com.estacionamento.estacionamento.dto;

import com.estacionamento.estacionamento.entities.Fabricante;
import com.estacionamento.estacionamento.entities.Tipo;

public class ModeloDTO {
    
    private Long id;
    private String nome;
    private Fabricante fabricante;
    private Tipo tipo;

    public ModeloDTO(Long id, String nome, Fabricante fabricante, Tipo tipo) {
        this.id = id;
        this.nome = nome;
        this.fabricante = fabricante;
        this.tipo = tipo;
    }

    public ModeloDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
}
