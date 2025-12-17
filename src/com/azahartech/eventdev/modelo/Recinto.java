package com.azahartech.eventdev.modelo;

public class Recinto {
    private String nombre;
    private String direccion;
    private int aforoMaximo;
    private boolean[] asientosVip;

    public Recinto(String nombre, String direccion, int aforoMaximo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.aforoMaximo = aforoMaximo;
        asientosVip = new boolean[10];
        for (int i = 0; i < asientosVip.length;i++) {
            asientosVip[i] = false;
        }

    }
    public void reservarAsientoVip(int numeroAsiento) {
        numeroAsiento -= 1;
        if (numeroAsiento <= 9 && numeroAsiento >= 0 && !asientosVip[numeroAsiento] ) {
            asientosVip[numeroAsiento] = true;
        }
    }
    public int contarAsientosVipLibres() {
        int contador = 0;
            for (int i = 0; i < asientosVip.length;i++) {
                if (!asientosVip[i]) {
                    contador++;
                }
            }
        return contador;
    }
    public String getNombre() {
        return nombre;
    }
    public String getDireccion() {
        return direccion;
    }
    public int getAforoMaximo() {
        return aforoMaximo;
    }
    public void mostrarInformacion() {
        System.out.println("\n--- DATOS DEL RECINTO ---");
        System.out.printf("Nombre del recinto: %s%n", nombre);
        System.out.printf("Dirección: %s%n", direccion);
        System.out.printf("Aforo Maximo: %d%n", aforoMaximo);
        System.out.printf("Numero de asientos vip libres: %s%n", contarAsientosVipLibres());
    }
}