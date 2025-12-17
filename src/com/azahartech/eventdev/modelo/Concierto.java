package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Concierto extends Evento {
    private String bandaPrincipal;

    public Concierto(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String bandaPrincipal) {
        super(nombre, fecha, recinto, precioEntrada);
        this.bandaPrincipal = bandaPrincipal;
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
