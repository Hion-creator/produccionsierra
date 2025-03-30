package com.example.produccion.controller;

import com.example.produccion.dto.DespachoDTO;
import com.example.produccion.service.DespachoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/despacho")
public class DespachoController {

    private final DespachoService despachoService;

    public DespachoController(DespachoService despachoService) {
        this.despachoService = despachoService;
    }

    @PostMapping
    public ResponseEntity<?> generarOrdenDespacho(@RequestBody DespachoDTO despachoDTO) {
        try {
            despachoService.generarOrdenDespacho(despachoDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body("Orden de despacho generada exitosamente");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch(Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                                 .body("Error al generar la orden: " + e.getMessage());
        }
    }
}



