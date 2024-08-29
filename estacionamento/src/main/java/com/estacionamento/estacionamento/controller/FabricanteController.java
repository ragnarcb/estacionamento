package com.estacionamento.estacionamento.controller;

import com.estacionamento.estacionamento.dto.FabricanteDTO;
import com.estacionamento.estacionamento.service.FabricanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fabricantes")
public class FabricanteController {

    @Autowired
    private FabricanteService fabricanteService;

    @GetMapping
    public List<FabricanteDTO> getAllFabricantes() {
        return fabricanteService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FabricanteDTO> getFabricanteById(@PathVariable Long id) {
        FabricanteDTO fabricanteDTO = fabricanteService.findById(id);
        return fabricanteDTO != null ? ResponseEntity.ok(fabricanteDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public FabricanteDTO createFabricante(@RequestBody FabricanteDTO fabricanteDTO) {
        return fabricanteService.save(fabricanteDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FabricanteDTO> updateFabricante(@PathVariable Long id, @RequestBody FabricanteDTO fabricanteDTO) {
        FabricanteDTO updatedFabricante = fabricanteService.update(id, fabricanteDTO);
        return updatedFabricante != null ? ResponseEntity.ok(updatedFabricante) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFabricante(@PathVariable Long id) {
        fabricanteService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
