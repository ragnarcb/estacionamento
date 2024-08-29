package com.estacionamento.estacionamento.controller;

import com.estacionamento.estacionamento.dto.StatusDTO;
import com.estacionamento.estacionamento.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public List<StatusDTO> getAllStatuses() {
        return statusService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StatusDTO> getStatusById(@PathVariable Long id) {
        StatusDTO statusDTO = statusService.findById(id);
        return statusDTO != null ? ResponseEntity.ok(statusDTO) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public StatusDTO createStatus(@RequestBody StatusDTO statusDTO) {
        return statusService.save(statusDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStatus(@PathVariable Long id) {
        statusService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
