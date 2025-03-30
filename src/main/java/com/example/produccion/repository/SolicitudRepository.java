package com.example.produccion.repository;

import com.example.produccion.model.Solicitud;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;
import com.google.cloud.firestore.Firestore;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Repository
public class SolicitudRepository {

    /**
     * Guarda una nueva solicitud en Firestore.
     */
    public Solicitud save(Solicitud solicitud) {
        Firestore db = FirestoreClient.getFirestore();
        // Genera un ID simple; en producción se puede usar otro mecanismo (UUID, etc.)
        String id = String.valueOf(System.currentTimeMillis());
        solicitud.setId(id);
        ApiFuture<WriteResult> future = db.collection("solicitudes").document(id).set(solicitud);
        try {
            future.get(); // Espera a que se complete la escritura
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return solicitud;
    }

    /**
     * Actualiza una solicitud existente en Firestore.
     */
    public Solicitud update(Solicitud solicitud) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> future = db.collection("solicitudes").document(solicitud.getId()).set(solicitud);
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return solicitud;
    }

    /**
     * Recupera todas las solicitudes almacenadas en la colección "solicitudes".
     */
    public List<Solicitud> findAll() {
        Firestore db = FirestoreClient.getFirestore();
        List<Solicitud> solicitudes = new ArrayList<>();
        ApiFuture<QuerySnapshot> future = db.collection("solicitudes").get();
        try {
            QuerySnapshot querySnapshot = future.get();
            for (QueryDocumentSnapshot document : querySnapshot.getDocuments()) {
                Solicitud solicitud = document.toObject(Solicitud.class);
                solicitud.setId(document.getId());
                solicitudes.add(solicitud);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return solicitudes;
    }

    /**
     * Busca una solicitud por su ID.
     */
    public Solicitud findById(String id) {
        Firestore db = FirestoreClient.getFirestore();
        ApiFuture<DocumentSnapshot> future = db.collection("solicitudes").document(id).get();
        try {
            DocumentSnapshot document = future.get();
            if (document.exists()) {
                Solicitud solicitud = document.toObject(Solicitud.class);
                solicitud.setId(document.getId());
                return solicitud;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}




