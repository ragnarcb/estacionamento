package com.estacionamento.estacionamento.service;

import com.estacionamento.estacionamento.dto.VeiculoDTO;
import com.estacionamento.estacionamento.entities.Veiculo;
import com.estacionamento.estacionamento.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<VeiculoDTO> findAll() {
        return veiculoRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public VeiculoDTO findById(Long id) {
        return veiculoRepository.findById(id)
                .map(this::convertToDTO)
                .orElse(null);
    }

    public VeiculoDTO save(VeiculoDTO veiculoDTO) {
        Veiculo veiculo = convertToEntity(veiculoDTO);
        veiculo = veiculoRepository.save(veiculo);
        return convertToDTO(veiculo);
    }

    public VeiculoDTO update(Long id, VeiculoDTO veiculoDTO) {
        if (!veiculoRepository.existsById(id)) {
            return null;
        }
        Veiculo veiculo = convertToEntity(veiculoDTO);
        veiculo.setId(id);
        veiculo = veiculoRepository.save(veiculo);
        return convertToDTO(veiculo);
    }

    public void delete(Long id) {
        veiculoRepository.deleteById(id);
    }

    private VeiculoDTO convertToDTO(Veiculo veiculo) {
        return new VeiculoDTO(veiculo.getId(), veiculo.getPlaca(), veiculo.getCor(), veiculo.getModelo());
    }

    private Veiculo convertToEntity(VeiculoDTO veiculoDTO) {
        return new Veiculo(veiculoDTO.getId(), veiculoDTO.getPlaca(), veiculoDTO.getCor(), veiculoDTO.getModelo());
    }
}
