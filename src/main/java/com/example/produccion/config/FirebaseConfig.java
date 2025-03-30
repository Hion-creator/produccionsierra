package com.example.produccion.config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initialize() {
        try {
            // Intenta cargar el archivo de credenciales desde el classpath
            InputStream serviceAccount = getClass().getResourceAsStream("/sierrasfirebase.json");
            if (serviceAccount == null) {
                throw new IOException("No se encontró el archivo 'sierras-firebase.json' en el classpath");
            }

            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    // Opcional: si usas Realtime Database, descomenta la siguiente línea y reemplaza con tu URL
                    // .setDatabaseUrl("https://<tu-proyecto>.firebaseio.com")
                    .build();

            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
            System.out.println("Firebase (Firestore) inicializado correctamente");
        } catch (IOException e) {
            // Registra el error detalladamente para ayudar en la depuración
            System.err.println("Error al inicializar Firebase: " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Error en la inicialización de Firebase", e);
        }
    }
}



