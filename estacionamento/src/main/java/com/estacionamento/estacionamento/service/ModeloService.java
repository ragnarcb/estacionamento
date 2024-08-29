package com.estacionamento.estacionamento.service;

import com.estacionamento.estacionamento.dto.ModeloDTO;
import com.estacionamento.estacionamento.entities.Modelo;
import com.estacionamento.estacionamento.mapper.ModeloMapper;
import com.estacionamento.estacionamento.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ModeloService {

    @Autowired
    private ModeloRepository modeloRepository;

    @Autowired
    private ModeloMapper modeloMapper;

    public List<ModeloDTO> findAll() {
        return modeloRepository.findAll().stream()
                .map(modeloMapper::toDto)
                .collect(Collectors.toList());
    }

    public ModeloDTO findById(Long id) {
        Optional<Modelo> modelo = modeloRepository.findById(id);
        return modelo.map(modeloMapper::toDto).orElse(null);
    }

    public ModeloDTO save(ModeloDTO modeloDTO) {
        Modelo modelo = modeloMapper.toEntity(modeloDTO);
        Modelo savedModelo = modeloRepository.save(modelo);
        return modeloMapper.toDto(savedModelo);
    }

    public ModeloDTO update(Long id, ModeloDTO modeloDTO) {
        if (modeloRepository.existsById(id)) {
            Modelo modelo = modeloMapper.toEntity(modeloDTO);
            modelo.setId(id); // Ensure ID is set
            Modelo updatedModelo = modeloRepository.save(modelo);
            return modeloMapper.toDto(updatedModelo);
        }
        return null;
    }

    public void delete(Long id) {
        modeloRepository.deleteById(id);
    }
}
