package com.azahartech.eventdev.modelo;

public class DetallePago {
    private String tipoTarjeta;
    private String numeroTarjeta;
    private DetallePago detallePago;

    public DetallePago(String tipoTarjeta, String numeroTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void añadirDetallePago(DetallePago nuevoDetallePago) {
        detallePago = nuevoDetallePago;
    }
    //Sobrecarga de metodo
    public void realizarPago(double costeTotal) {
        System.out.println("Procesando pago por: " + costeTotal + " €");
    }
    public void realizarPago(double costeTotal, String tipoTarjeta) {
        System.out.println("Pago con tarjeta: " + tipoTarjeta);
        this.realizarPago(costeTotal);//reutilizar logica de pago
    }

    public void mostrarInformacion() {
        System.out.println("\n--- DATOS DETALLE DE PAGO ---");
        System.out.printf("Tipo Tarjeta: %s%n", tipoTarjeta);
        System.out.printf("Numero Tarjeta: %s%n", numeroTarjeta);
    }
}
