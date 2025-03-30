package com.example.produccion.model;

import java.util.Date;

public class Solicitud {

    private String id;
    private String productoId;
    private String descripcion;
    private String observacion;
    private Integer cantidadSolicitada;
    private Date fechaCreacion;
    private String estado; // Ejemplo: "Inicial", "Procesado"

    public Solicitud() {
        // Constructor vacío requerido para Firestore
    }

    public Solicitud(String productoId, String descripcion, String observacion, Integer cantidadSolicitada) {
        this.productoId = productoId;
        this.descripcion = descripcion;
        this.observacion = observacion;
        this.cantidadSolicitada = cantidadSolicitada;
        this.fechaCreacion = new Date();
        this.estado = "Inicial";
    }

    // Getters y setters

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
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
    public Date getFechaCreacion() {
        return fechaCreacion;
    }
    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
}


