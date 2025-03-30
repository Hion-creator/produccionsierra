package com.example.produccion.service;

import com.example.produccion.dto.DespachoDTO;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.Date;

@Service
public class DespachoService {

    public void generarOrdenDespacho(DespachoDTO despachoDTO) {
        if (despachoDTO.getCantidadProductos() <= 0) {
            throw new IllegalArgumentException("La cantidad certificada debe ser mayor a 0");
        }
        Firestore db = FirestoreClient.getFirestore();
        // Genera un ID simple para el despacho
        String id = String.valueOf(System.currentTimeMillis());
        Map<String, Object> despacho = new HashMap<>();
        despacho.put("codigoSolicitud", despachoDTO.getCodigoSolicitud());
        despacho.put("cantidadProductos", despachoDTO.getCantidadProductos());
        despacho.put("usuario", despachoDTO.getUsuario());
        despacho.put("fecha", new Date().toString());

        ApiFuture<WriteResult> future = db.collection("despachos").document(id).set(despacho);
        try {
            future.get(); // Espera a que se complete la escritura
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            throw new RuntimeException("Error al generar la orden de despacho");
        }
    }
}


