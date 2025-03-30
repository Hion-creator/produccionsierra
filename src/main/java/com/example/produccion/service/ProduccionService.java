package com.example.produccion.service;

import com.example.produccion.model.Solicitud;
import com.example.produccion.repository.SolicitudRepository;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ProduccionService {

    private final SolicitudRepository solicitudRepository;

    public ProduccionService(SolicitudRepository solicitudRepository) {
        this.solicitudRepository = solicitudRepository;
    }

    public void procesarProduccion(String fechaCorte) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date fechaCorteDate = sdf.parse(fechaCorte);

        List<Solicitud> solicitudes = solicitudRepository.findAll();
        for (Solicitud solicitud : solicitudes) {
            // Procesa solo las solicitudes en estado "Inicial" con fecha anterior a la fecha de corte
            if ("Inicial".equalsIgnoreCase(solicitud.getEstado()) &&
                solicitud.getFechaCreacion().before(fechaCorteDate)) {
                solicitud.setEstado("Procesado");
                solicitudRepository.update(solicitud);
            }
        }
    }
}



