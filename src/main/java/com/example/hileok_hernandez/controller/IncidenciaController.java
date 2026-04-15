package com.example.hileok_hernandez.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.hileok_hernandez.model.Incidencia;
import com.example.hileok_hernandez.service.IncidenciaService;

@RestController
@RequestMapping("api/v1/incidencias")
public class IncidenciaController {

    @Autowired
    private IncidenciaService incidenciaService;

    public IncidenciaController(IncidenciaService incidenciaService) {
        this.incidenciaService = incidenciaService;
    }
    
    @PostMapping
    public ResponseEntity<String> postIncidencia(@Valid @RequestBody Incidencia incidencia) {
        try {
            Incidencia i = incidenciaService.create(incidencia);
            return ResponseEntity.ok("Incidencia agregada correctamente");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Datos incompletos: " + e.getMessage());
        }
    }

    
    @GetMapping
    public ResponseEntity<?> getUsuarios() {
        List<Incidencia> lista = incidenciaService.readAll();
        if (lista.isEmpty()) {
            return ResponseEntity.status(404).body("Recursos no encontrados");
        }
        return ResponseEntity.ok(lista);
    }

    // Obtener incidencia por ID
    @GetMapping("/{id}")
    public ResponseEntity<?> getIncidenciaById(@PathVariable int id) {
        Optional<Incidencia> incidencia = incidenciaService.findById(id);
        if (incidencia.isPresent()) {
            return ResponseEntity.ok(incidencia.get());
        }
        return ResponseEntity.status(404).body("Incidencia no encontrada con id " + id);
    }

    // Actualizar incidencia
    @PutMapping("/{id}")
    public ResponseEntity<String> putIncidencia(@PathVariable int id, @Valid @RequestBody Incidencia incidencia) {
        try {
            Incidencia i = incidenciaService.update(id, incidencia);
            if (i != null) {
                return ResponseEntity.ok("Incidencia actualizada correctamente");
            }
            return ResponseEntity.status(404).body("Incidencia no encontrada con id " + id);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Error al actualizar: " + e.getMessage());
        }
    }

    // Eliminar incidencia
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteIncidencia(@PathVariable int id) {
        boolean eliminado = incidenciaService.eliminar(id);
        if (eliminado) {
            return ResponseEntity.ok("Incidencia eliminada correctamente");
        }
        return ResponseEntity.status(404).body("Incidencia no encontrada con id " + id);
    }
}