package com.estacionamento.estacionamento.service;

import com.estacionamento.estacionamento.dto.FabricanteDTO;
import com.estacionamento.estacionamento.entities.Fabricante;
import com.estacionamento.estacionamento.entities.Status;
import com.estacionamento.estacionamento.mapper.FabricanteMapper;
import com.estacionamento.estacionamento.repository.FabricanteRepository;
import com.estacionamento.estacionamento.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FabricanteService {

    @Autowired
    private FabricanteRepository fabricanteRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private FabricanteMapper fabricanteMapper;

    public List<FabricanteDTO> findAll() {
        return fabricanteRepository.findAll().stream()
                .map(fabricanteMapper::toDTO)
                .toList();
    }

    public FabricanteDTO findById(Long id) {
        Optional<Fabricante> fabricante = fabricanteRepository.findById(id);
        return fabricante.map(fabricanteMapper::toDTO).orElse(null);
    }

    public FabricanteDTO save(FabricanteDTO fabricanteDTO) {
        Status status = statusRepository.findById(fabricanteDTO.getStatusId()).orElse(null);
        Fabricante fabricante = fabricanteMapper.toEntity(fabricanteDTO, status);
        fabricante = fabricanteRepository.save(fabricante);
        return fabricanteMapper.toDTO(fabricante);
    }

    public FabricanteDTO update(Long id, FabricanteDTO fabricanteDTO) {
        Optional<Fabricante> existingFabricanteOpt = fabricanteRepository.findById(id);
        if (existingFabricanteOpt.isPresent()) {
            Fabricante existingFabricante = existingFabricanteOpt.get();
            
            // Atualizar os campos que são permitidos.
            if (fabricanteDTO.getNome() != null) {
                existingFabricante.setNome(fabricanteDTO.getNome());
            }
            if (fabricanteDTO.getEmail() != null) {
                existingFabricante.setEmail(fabricanteDTO.getEmail());
            }
            if (fabricanteDTO.getPais() != null) {
                existingFabricante.setPais(fabricanteDTO.getPais());
            }
            if (fabricanteDTO.getStatusId() != null) {
                Status status = statusRepository.findById(fabricanteDTO.getStatusId()).orElse(null);
                existingFabricante.setStatus(status);
            }
            
    
            Fabricante updatedFabricante = fabricanteRepository.save(existingFabricante);
            return fabricanteMapper.toDTO(updatedFabricante);
        } else {
            return null;  // Ou lance uma exceção personalizada
        }
    }

    public void delete(Long id) {
        fabricanteRepository.deleteById(id);
    }
}
