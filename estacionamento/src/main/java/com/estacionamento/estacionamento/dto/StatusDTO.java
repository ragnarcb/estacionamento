package com.estacionamento.estacionamento.dto;

public class StatusDTO {
    private Long id;
    private String nomeStatus;

    public StatusDTO() {
    }

    public StatusDTO(Long id, String nomeStatus) {
        this.id = id;
        this.nomeStatus = nomeStatus;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeStatus() {
        return nomeStatus;
    }

    public void setNomeStatus(String nomeStatus) {
        this.nomeStatus = nomeStatus;
    }
}
