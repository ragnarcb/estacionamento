package com.estacionamento.estacionamento.service;

import com.estacionamento.estacionamento.dto.TipoDTO;
import com.estacionamento.estacionamento.entities.Tipo;
import com.estacionamento.estacionamento.repository.TipoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TipoService {

    @Autowired
    private TipoRepository tipoRepository;

    public List<TipoDTO> findAll() {
        return tipoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public TipoDTO findById(Long id) {
        return tipoRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public TipoDTO save(TipoDTO tipoDTO) {
        Tipo tipo = convertToEntity(tipoDTO);
        return convertToDTO(tipoRepository.save(tipo));
    }

    public TipoDTO update(Long id, TipoDTO tipoDTO) {
        if (tipoRepository.existsById(id)) {
            tipoDTO.setId(id);
            Tipo tipo = convertToEntity(tipoDTO);
            return convertToDTO(tipoRepository.save(tipo));
        }
        return null;
    }

    public void delete(Long id) {
        tipoRepository.deleteById(id);
    }

    private TipoDTO convertToDTO(Tipo tipo) {
        return new TipoDTO(tipo.getId(), tipo.getNome());
    }

    private Tipo convertToEntity(TipoDTO tipoDTO) {
        return new Tipo(tipoDTO.getId(), tipoDTO.getNome());
    }
}
