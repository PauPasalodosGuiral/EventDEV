package com.azahartech.eventdev.modelo;
import java.time.LocalDate;
import java.util.UUID;

public abstract class Evento {
    private String nombre;
    private LocalDate fecha;
    private Recinto recinto;
    private double precioEntrada;
    private boolean esBenefico;
    private String id;

    public Evento(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, boolean esBenefico) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.recinto = recinto;
        this.precioEntrada = precioEntrada;
        this.esBenefico = esBenefico;
        this.id = "EVT-" + fecha.getYear() + "-" + UUID.randomUUID().toString().substring(0,3).toUpperCase();
    }

    public boolean getEsBenefico() {
        return esBenefico;
    }

    public String getId() {
        return id;
    }

    public void setEsBenefico(boolean esBenefico) {
        this.esBenefico = esBenefico;
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

    public final String obtenerCodigoReferencia() {
        String codigo = "REF-" + id +
                "-NOM-" +
                nombre;
        return codigo;
    }


    public abstract double calcularCosteOperativo();

    public final double calcularPrecioVentaRecomendado() {
        double resultado;
        double  margenBeneficio = 0.20;//20%
        resultado = calcularCosteOperativo() / getRecinto().getAforoMaximo();
        resultado = resultado + (resultado * margenBeneficio);
        return resultado;
    }

    public void mostrarInformacion() {
        System.out.println("\n--- DATOS DEL EVENTO ---");
        System.out.printf("Nombre del Evento: %s%n", nombre);
        System.out.printf("Precio Entrada: %.2f €%n", precioEntrada);
        System.out.printf("Fecha: %s%n", fecha);
        System.out.printf("Es benefico: %s%n", esBenefico);

        recinto.mostrarInformacion();
    }
}
