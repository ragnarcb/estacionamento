package com.estacionamento.estacionamento.dto;

import com.estacionamento.estacionamento.entities.Modelo;

public class VeiculoDTO {
    
    private Long id;
    private String placa;
    private String cor;
    private Modelo modelo;

    public VeiculoDTO() {
    }

    public VeiculoDTO(Long id, String placa, String cor, Modelo modelo) {
        this.id = id;
        this.placa = placa;
        this.cor = cor;
        this.modelo = modelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Modelo getModelo() {
        return modelo;
    }

    public void setModelo(Modelo modelo) {
        this.modelo = modelo;
    }
}
