package com.example.produccion.service;

import com.example.produccion.dto.SolicitudDTO;
import com.example.produccion.model.Solicitud;
import com.example.produccion.repository.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitudService {

    private final SolicitudRepository solicitudRepository;

    public SolicitudService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public Solicitud registrarSolicitud(SolicitudDTO dto) {
        // Validación adicional (ya realizada en el DTO)
        if (dto.getCantidadSolicitada() <= 0) {
            throw new IllegalArgumentException("La cantidad registrada no puede ser menor o igual a 0");
        }
        Solicitud solicitud = new Solicitud(
                dto.getProductoId(),
                dto.getDescripcion(),
                dto.getObservacion(),
                dto.getCantidadSolicitada()
        );
        return solicitudRepository.save(solicitud);
    }

    public List<Solicitud> consultarSolicitudes() {
        return solicitudRepository.findAll();
    }
}

