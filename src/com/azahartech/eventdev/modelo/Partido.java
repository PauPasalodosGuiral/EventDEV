package com.azahartech.eventdev.modelo;

import java.time.LocalDate;

public class Partido extends Evento {
    private String equipoVisitante;
    private String equipoLocal;
    private double costeSeguridad;
    private double costeArbitraje;
    private final double GASTOS_FIJOS = 2000;

    public Partido(String nombre, LocalDate fecha, Recinto recinto, double precioEntrada, boolean esBenefico, String equipoVisitante, String equipoLocal, double costeSeguridad, double costeArbitraje) {
        super(nombre, fecha, recinto, precioEntrada, esBenefico);
        this.equipoVisitante = equipoVisitante;
        this.equipoLocal = equipoLocal;
        this.costeSeguridad = costeSeguridad;
        this.costeArbitraje = costeArbitraje;
    }

    @Override
    public double calcularCosteOperativo() {
        return GASTOS_FIJOS + costeSeguridad + costeArbitraje;
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
