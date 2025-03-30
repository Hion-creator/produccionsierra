package com.example.produccion.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class DespachoDTO {

    @NotBlank(message = "El código de solicitud no puede estar vacío")
    private String codigoSolicitud;
    
    @NotNull(message = "La cantidad de productos no puede estar vacía")
    private Integer cantidadProductos;
    
    @NotBlank(message = "El usuario no puede estar vacío")
    private String usuario;

    // Getters y setters

    public String getCodigoSolicitud() {
        return codigoSolicitud;
    }
    public void setCodigoSolicitud(String codigoSolicitud) {
        this.codigoSolicitud = codigoSolicitud;
    }
    public Integer getCantidadProductos() {
        return cantidadProductos;
    }
    public void setCantidadProductos(Integer cantidadProductos) {
        this.cantidadProductos = cantidadProductos;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}


