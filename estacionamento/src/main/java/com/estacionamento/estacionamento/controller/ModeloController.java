package com.estacionamento.estacionamento.controller;

import com.estacionamento.estacionamento.dto.ModeloDTO;
import com.estacionamento.estacionamento.service.ModeloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/modelos")
public class ModeloController {

    @Autowired
    private ModeloService modeloService;

    @GetMapping
    public List<ModeloDTO> getAllModelos() {
        return modeloService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ModeloDTO> getModeloById(@PathVariable Long id) {
        ModeloDTO modeloDTO = modeloService.findById(id);
        return modeloDTO != null ? ResponseEntity.ok(modeloDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ModeloDTO createModelo(@RequestBody ModeloDTO modeloDTO) {
        return modeloService.save(modeloDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ModeloDTO> updateModelo(@PathVariable Long id, @RequestBody ModeloDTO modeloDTO) {
        ModeloDTO updatedModelo = modeloService.update(id, modeloDTO);
        return updatedModelo != null ? ResponseEntity.ok(updatedModelo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModelo(@PathVariable Long id) {
        modeloService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
