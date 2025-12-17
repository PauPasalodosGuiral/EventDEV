package com.azahartech.eventdev.modelo;
import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class Tique {
    private String id;
    private Evento evento;
    private Usuario comprador;
    private LocalDate fechaCompra;
    private static int contadorTiquesCreados;

    public Tique(Evento nuevoEvento, Usuario nuevoComprador) {
        Random random =new Random();
        evento = nuevoEvento;
        comprador = nuevoComprador;
        id = UUID.randomUUID().toString();
        fechaCompra = LocalDate.now();
        contadorTiquesCreados++;
    }
    public static int obtenerTotalTiques() {
        System.out.print("\nEl numero de tiques creados es: ");
        return contadorTiquesCreados;
    }

    public void mostrarInformacion() {
        evento.mostrarInformacion();
        comprador.mostrarInformacion();
        System.out.println("\n---DATOS TIQUE---");
        System.out.printf("ID: %s%n", id);
        System.out.printf("Fecha de compra: %s%n", fechaCompra);
        System.out.printf("Usuario: %s%n", comprador.getNombreUsuario());
        System.out.printf("Nombre evento: %s%n",evento.getNombreEvento());
    }
}
