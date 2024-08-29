package com.estacionamento.estacionamento.controller;

import com.estacionamento.estacionamento.dto.TipoDTO;
import com.estacionamento.estacionamento.service.TipoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tipos")
public class TipoController {

    @Autowired
    private TipoService tipoService;

    @GetMapping
    public List<TipoDTO> getAllTipos() {
        return tipoService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoDTO> getTipoById(@PathVariable Long id) {
        TipoDTO tipoDTO = tipoService.findById(id);
        return tipoDTO != null ? ResponseEntity.ok(tipoDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public TipoDTO createTipo(@RequestBody TipoDTO tipoDTO) {
        return tipoService.save(tipoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoDTO> updateTipo(@PathVariable Long id, @RequestBody TipoDTO tipoDTO) {
        TipoDTO updatedTipo = tipoService.update(id, tipoDTO);
        return updatedTipo != null ? ResponseEntity.ok(updatedTipo) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTipo(@PathVariable Long id) {
        tipoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
