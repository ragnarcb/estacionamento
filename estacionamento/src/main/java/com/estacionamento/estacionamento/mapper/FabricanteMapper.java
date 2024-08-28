package com.estacionamento.estacionamento.mapper;

import com.estacionamento.estacionamento.dto.FabricanteDTO;
import com.estacionamento.estacionamento.entities.Fabricante;
import com.estacionamento.estacionamento.entities.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FabricanteMapper {

    @Autowired
    private StatusMapper statusMapper;

    public FabricanteDTO toDTO(Fabricante fabricante) {
        return new FabricanteDTO(fabricante.getId(), fabricante.getNome(), fabricante.getEmail(), fabricante.getPais(), fabricante.getStatus().getId());
    }

    public Fabricante toEntity(FabricanteDTO fabricanteDTO, Status status) {
        return new Fabricante(fabricanteDTO.getId(), fabricanteDTO.getNome(), fabricanteDTO.getEmail(), fabricanteDTO.getPais(), status);
    }
}
