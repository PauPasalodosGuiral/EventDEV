package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Concierto extends Evento {
    private String bandaPrincipal;
    private double costeMontaje;
    private final double GASTOS_FIJOS = 2000;

    public Concierto(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String bandaPrincipal, boolean esBenefico, double costeMontaje) {
        super(nombre, fecha, recinto, precioEntrada, esBenefico);
        this.bandaPrincipal = bandaPrincipal;
        this.costeMontaje = costeMontaje;
    }

    @Override
    public double calcularCosteOperativo() {
        return GASTOS_FIJOS + costeMontaje;
    }

    public String getBandaPrincipal() {
        return bandaPrincipal;
    }
    public void setBandaPrincipal(String nuevoBandaPrincipal) {
        this.bandaPrincipal = nuevoBandaPrincipal;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("\n---DATOS DE CONCIERTO---");
        System.out.printf("Banda principal: %s%n", bandaPrincipal);
    }
}
