package com.ssi.seguimiento_incidentes_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssi.seguimiento_incidentes_backend.model.Incidente;
import com.ssi.seguimiento_incidentes_backend.repository.incidenteRepository;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class incidenteService {
    private final incidenteRepository incidenteRepository;

    public Incidente crearIncidente(Incidente incidente) {
        return incidenteRepository.save(incidente);
    }

    public List<Incidente> obtenerTodosLosIncidentes() {
        return incidenteRepository.findAll();
    }

    public Incidente obtenerIncidentePorId(Long id) {
        return incidenteRepository.findById(id).orElse(null);
    }

    public Incidente actualizarIncidente(Long id, Incidente incidente) { 
        Incidente existente = incidenteRepository.findById(id).orElse(null);
        if (existente != null) {
            existente.setTitulo(incidente.getTitulo());
            existente.setDescripcion(incidente.getDescripcion());
            existente.setSeveridad(incidente.getSeveridad());
            existente.setEstado(incidente.getEstado());
            existente.setFechaActualizacion(incidente.getFechaActualizacion());
            return incidenteRepository.save(existente);
        }
        return null;
    }

    public void eliminarIncidente(Long id) {
        incidenteRepository.deleteById(id);
    }
}
