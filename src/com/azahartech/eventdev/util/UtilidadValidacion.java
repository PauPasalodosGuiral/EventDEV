package com.azahartech.eventdev.util;

import java.time.LocalDate;

public class UtilidadValidacion {

    public static boolean esEmailValido(String email) {
       String regex = "^(?i)[a-z0-9]+@[a-z]+\\.[a-z]{2,4}$" ;
        return email.matches(regex);
    }
    public static boolean esCodigoEventoValido(String codigo) {
        String regex = "^EVT-\\d{4}-[A-Z]{3}$";
        return codigo.matches(regex);
    }
    public static boolean esTelefonoValido(String numeroTelefono) {
        String regex = "^[679]\\d{8}$";
        return numeroTelefono.matches(regex);
    }

    public static boolean esPuntiacionValida(int puntuacion) {
        return (puntuacion >=1) && (puntuacion <=5);
    }
    public static boolean esFechaFutura(LocalDate fecha) {
        LocalDate fechaActual = LocalDate.now();
        return fechaActual.isBefore(fecha);
    }



}
