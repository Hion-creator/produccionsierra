package com.example.produccion.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class SolicitudDTO {
    
    @NotBlank(message = "El parámetro 'ID del producto' no puede estar vacío")
    private String productoId;
    
    @NotBlank(message = "El parámetro 'Descripción' no puede estar vacío")
    private String descripcion;
    
    @NotBlank(message = "El parámetro 'Observación' no puede estar vacío")
    private String observacion;
    
    @NotNull(message = "El parámetro 'Cantidad solicitada' no puede estar vacío")
    @Min(value = 1, message = "La cantidad debe ser un entero positivo")
    private Integer cantidadSolicitada;

    // Getters y setters

    public String getProductoId() {
        return productoId;
    }
    public void setProductoId(String productoId) {
        this.productoId = productoId;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getObservacion() {
        return observacion;
    }
    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
    public Integer getCantidadSolicitada() {
        return cantidadSolicitada;
    }
    public void setCantidadSolicitada(Integer cantidadSolicitada) {
        this.cantidadSolicitada = cantidadSolicitada;
    }
}


