package com.ssi.seguimiento_incidentes_backend.controller;


import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssi.seguimiento_incidentes_backend.model.Incidente;
import com.ssi.seguimiento_incidentes_backend.service.incidenteService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/incidentes")
@RequiredArgsConstructor
public class incidenteController {
    private final incidenteService incidenteService;

    // Crear incidente
    @PostMapping
    public ResponseEntity<Incidente> crearIncidente(@RequestBody Incidente incidente) {
        Incidente creado = incidenteService.crearIncidente(incidente);
        return ResponseEntity.status(HttpStatus.CREATED).body(creado);
    }

    // Obtener todos los incidentes
    @GetMapping
    public ResponseEntity<List<Incidente>> obtenerTodosLosIncidentes() {
        List<Incidente> incidentes = incidenteService.obtenerTodosLosIncidentes();
        return ResponseEntity.ok(incidentes);
    }

    // Obtener incidente por ID
    @GetMapping("/{id}")
    public ResponseEntity<Incidente> obtenerIncidentePorId(@PathVariable Long id) {
        Incidente incidente = incidenteService.obtenerIncidentePorId(id);
        return ResponseEntity.ok(incidente);
    }

    // Actualizar incidente
    @PutMapping("/{id}")
    public ResponseEntity<Incidente> actualizarIncidente(@PathVariable Long id, @RequestBody Incidente incidente) {
        Incidente actualizado = incidenteService.actualizarIncidente(id, incidente);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar incidente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarIncidente(@PathVariable Long id) {
        incidenteService.eliminarIncidente(id);
        return ResponseEntity.noContent().build();
    }

}
