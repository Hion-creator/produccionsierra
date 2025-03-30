package com.example.produccion.controller;

import com.example.produccion.dto.SolicitudDTO;
import com.example.produccion.model.Solicitud;
import com.example.produccion.service.SolicitudService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/solicitudes")
public class SolicitudController {

    private final SolicitudService solicitudService;

    public SolicitudController(SolicitudService solicitudService) {
        this.solicitudService = solicitudService;
    }

    @PostMapping
    public ResponseEntity<?> registrarSolicitud(@Validated @RequestBody SolicitudDTO solicitudDTO) {
        try {
            Solicitud solicitud = solicitudService.registrarSolicitud(solicitudDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(solicitud);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al registrar la solicitud");
        }
    }
    
    @GetMapping
    public ResponseEntity<List<Solicitud>> consultarSolicitudes() {
        return ResponseEntity.ok(solicitudService.consultarSolicitudes());
    }
}



