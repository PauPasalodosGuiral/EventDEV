package com.azahartech.eventdev.modelo;
import java.util.Random;
import java.util.UUID;

public class Usuario {
    private String id;
    private String nombre;
    protected String email;
    private DetallePago detallePago;

    public Usuario(String nombre, String email, DetallePago detallePago) {
        Random random = new Random();
        this.nombre = nombre;
        this.email = email;
        this.detallePago = detallePago;
        id = UUID.randomUUID().toString();
    }

    public String getNombreUsuario() {
        return nombre;
    }
    public String getEmail() {
        return email;
    }
    public String getId() {
        return id;
    }
    public DetallePago getDetallePago() {
        return detallePago;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void mostrarInformacion() {
        System.out.println("\n--- DATOS DEL USUARIO ---");
        System.out.printf("Nombre usuario: %s%n", nombre);
        System.out.printf("Email: %s%n", email);
        System.out.printf("ID: %s%n", id);
    }
}
