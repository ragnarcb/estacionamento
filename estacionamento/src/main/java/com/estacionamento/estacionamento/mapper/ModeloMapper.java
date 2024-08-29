package com.estacionamento.estacionamento.mapper;

import com.estacionamento.estacionamento.dto.ModeloDTO;
import com.estacionamento.estacionamento.entities.Modelo;
import org.springframework.stereotype.Component;

@Component
public class ModeloMapper {

    public ModeloDTO toDto(Modelo modelo) {
        return new ModeloDTO(
                modelo.getId(),
                modelo.getNome(),
                modelo.getFabricante(),
                modelo.getTipo()
        );
    }

    public Modelo toEntity(ModeloDTO modeloDTO) {
        return new Modelo(
                modeloDTO.getId(),
                modeloDTO.getNome(),
                modeloDTO.getFabricante(),
                modeloDTO.getTipo()
        );
    }
}
