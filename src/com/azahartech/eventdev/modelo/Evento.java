package com.azahartech.eventdev.modelo;
import java.time.LocalDate;

public class Evento {
    private String nombre;
    private LocalDate fecha;
    private Recinto recinto;
    private double precioEntrada;

    public Evento(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.recinto = recinto;
        this.precioEntrada = precioEntrada;
    }

    public String getNombreEvento() {
        return nombre;
    }
    public LocalDate getFechaEvento() {
        return fecha;
    }
    public Recinto getRecinto() {
        return recinto;
    }
    public double getPrecioEntrada() {
        return  precioEntrada;
    }
    public  void registrarVenta(int cantidad){
        System.out.println("Se ha registrado una nueva venta");
    }

    public void mostrarInformacion() {
        System.out.println("\n--- DATOS DEL EVENTO ---");
        System.out.printf("Nombre del Evento: %s%n", nombre);
        System.out.printf("Precio Entrada: %.2f €%n", precioEntrada);
        System.out.printf("Fecha: %s%n", fecha);
        recinto.mostrarInformacion();
    }
}
