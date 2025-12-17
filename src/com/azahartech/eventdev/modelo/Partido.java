package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Partido extends Evento {
    private String equipoVisitante;
    private String equipoLocal;

    public Partido(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, String equipoVisitante, String equipoLocal) {
        super(nombre, fecha, recinto, precioEntrada);
        this.equipoVisitante = equipoVisitante;
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }
    public void setEquipoVisitante(String nuevoEquipoVisitante) {
        this.equipoVisitante = nuevoEquipoVisitante;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }
    public void setEquipoLocal(String nuevoEquipoLocal) {
        this.equipoVisitante = nuevoEquipoLocal;
    }

    @Override
    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("\n---DATOS DE PARTIDO---");
        System.out.printf("Equipo Local: %s%n", equipoLocal);
        System.out.printf("Equipo Visitante: %s%n", equipoVisitante);
    }
}
