package com.estacionamento.estacionamento.dto;

public class FabricanteDTO {
    private Long id;
    private String nome;
    private String email;
    private String pais;
    private Long statusId;

    public FabricanteDTO() {
    }

    public FabricanteDTO(Long id, String nome, String email, String pais, Long statusId) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.pais = pais;
        this.statusId = statusId;
    }

    // Getters e Setters
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Long getStatusId() {
        return statusId;
    }

    public void setStatusId(Long statusId) {
        this.statusId = statusId;
    }
}
