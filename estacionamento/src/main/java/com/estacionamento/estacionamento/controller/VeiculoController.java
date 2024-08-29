package com.estacionamento.estacionamento.controller;

import com.estacionamento.estacionamento.dto.VeiculoDTO;
import com.estacionamento.estacionamento.service.VeiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @GetMapping
    public List<VeiculoDTO> getAllVeiculos() {
        return veiculoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VeiculoDTO> getVeiculoById(@PathVariable Long id) {
        VeiculoDTO veiculoDTO = veiculoService.findById(id);
        return veiculoDTO != null ? ResponseEntity.ok(veiculoDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public VeiculoDTO createVeiculo(@RequestBody VeiculoDTO veiculoDTO) {
        return veiculoService.save(veiculoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VeiculoDTO> updateVeiculo(@PathVariable Long id, @RequestBody VeiculoDTO veiculoDTO) {
        VeiculoDTO updatedVeiculo = veiculoService.update(id, veiculoDTO);
        return updatedVeiculo != null ? ResponseEntity.ok(updatedVeiculo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVeiculo(@PathVariable Long id) {
        veiculoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
