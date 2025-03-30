package com.example.produccion.controller;

import com.example.produccion.service.ProduccionService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/produccion")
public class ProduccionController {

    private final ProduccionService produccionService;

    public ProduccionController(ProduccionService produccionService) {
        this.produccionService = produccionService;
    }

    @PostMapping("/procesar")
    public ResponseEntity<?> procesarProduccion(@RequestParam("fechaCorte") String fechaCorte) {
        try {
            produccionService.procesarProduccion(fechaCorte);
            return ResponseEntity.ok("Proceso de producción iniciado exitosamente");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error en el proceso de producción: " + e.getMessage());
        }
    }
}



