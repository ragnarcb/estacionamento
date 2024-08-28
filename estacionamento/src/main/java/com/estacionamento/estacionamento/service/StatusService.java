package com.estacionamento.estacionamento.service;

import com.estacionamento.estacionamento.dto.StatusDTO;
import com.estacionamento.estacionamento.entities.Status;
import com.estacionamento.estacionamento.mapper.StatusMapper;
import com.estacionamento.estacionamento.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StatusService {

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private StatusMapper statusMapper;

    public List<StatusDTO> findAll() {
        return statusRepository.findAll().stream()
                .map(statusMapper::toDTO)
                .toList();
    }

    public StatusDTO findById(Long id) {
        Optional<Status> status = statusRepository.findById(id);
        return status.map(statusMapper::toDTO).orElse(null);
    }

    public StatusDTO save(StatusDTO statusDTO) {
        Status status = statusMapper.toEntity(statusDTO);
        status = statusRepository.save(status);
        return statusMapper.toDTO(status);
    }

    public void delete(Long id) {
        statusRepository.deleteById(id);
    }
}
