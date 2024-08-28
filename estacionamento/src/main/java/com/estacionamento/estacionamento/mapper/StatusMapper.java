package com.estacionamento.estacionamento.mapper;

import com.estacionamento.estacionamento.dto.StatusDTO;
import com.estacionamento.estacionamento.entities.Status;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper {

    public StatusDTO toDTO(Status status) {
        return new StatusDTO(status.getId(), status.getNomeStatus());
    }

    public Status toEntity(StatusDTO statusDTO) {
        return new Status(statusDTO.getId(), statusDTO.getNomeStatus());
    }
}
