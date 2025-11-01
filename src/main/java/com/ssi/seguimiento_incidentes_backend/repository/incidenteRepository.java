package com.ssi.seguimiento_incidentes_backend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ssi.seguimiento_incidentes_backend.model.Incidente;

public interface incidenteRepository extends JpaRepository<Incidente, Long> {
    List<Incidente> findByEstado(String estado);

}
