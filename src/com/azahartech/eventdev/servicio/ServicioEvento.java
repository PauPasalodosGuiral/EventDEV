package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.modelo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;


public class ServicioEvento {
    private Evento eventoDePrueba;
    private Usuario usuarioDePrueba;
    //private Evento[] carteleraDestacados;
    private ArrayList<Evento> listaEventos;


    public ServicioEvento() {
        Recinto recintoDePrueba = new Recinto("mercandona", "Calle Mayor", 100);
        DetallePago detallePagoDePrueba = new DetallePago("credito","1122334455667788");
        this.eventoDePrueba = new Evento("Comprar", LocalDate.of(2025, 12, 01), recintoDePrueba, 10);
        this.usuarioDePrueba = new Usuario("pau","pau@gmail.com", detallePagoDePrueba);
        //carteleraDestacados = new Evento[5];
        this.listaEventos = new ArrayList<>();
    }
    public void registrarEvento(Evento evento) {
        listaEventos.add(evento);
    }
    public void eliminarEventosPasados() {
        Iterator<Evento> iterator = this.listaEventos.iterator();
        while (iterator.hasNext()) {
            Evento eventoActual =  iterator.next();
            if (eventoActual.getFechaEvento().isBefore(LocalDate.now())) {
                iterator.remove();
                System.out.println("Eliminado evento caducado: [" + eventoActual.getNombreEvento() +"].");
            }
        }

    }
    public void mostrarTodoElCatalogo() {
        for (Evento listaEvento : listaEventos) {
            listaEvento.mostrarInformacion();
        }
    }

    public ArrayList<Evento> filtrarPorTipo(String nombreBuscado) {
        ArrayList<Evento> resultado = new ArrayList<>();
        for (Evento evento : this.listaEventos) {
            if (nombreBuscado.equals(evento.getNombreEvento())) {
                resultado.add(evento);
            }
        }
        return resultado;
    }

    public void mostrarEventosFiltrados(ArrayList<Evento> eventosFiltrados) {
        for (Evento eventosFiltrado : eventosFiltrados) {
            eventosFiltrado.mostrarInformacion();
        }
    }


/*
    public boolean añadirdestacado(Evento evento, int posicion) {
        posicion = posicion -1;

            if (posicion >= 0 && posicion <= 4) {
                carteleraDestacados[posicion]= evento;
                return true;
            }
            return false;
    }

    public void mostrarCartelera() {
        for (int i = 0; i < carteleraDestacados.length; i++) {
            if (carteleraDestacados[i] == null) {
                System.out.println("Espacio disponible");
            } else {
                carteleraDestacados[i].mostrarInformacion();
            }
        }
    }

    public Evento buscarDestacadoMasCaro() {
        if (carteleraDestacados == null) {
            return null;
        }
        Evento eventoMasCaro = null;
        for (int i = 0; i < carteleraDestacados.length; i++) {
            Evento evento = carteleraDestacados[i];
            if (evento != null ) {
                if (eventoMasCaro == null || evento.getPrecioEntrada() > eventoMasCaro.getPrecioEntrada()) {
                    eventoMasCaro = evento;
                }
            }
        }
        return eventoMasCaro;
    }
*/
    public Tique realizarCompra(int cantidad) {
        double costeTotal = eventoDePrueba.getPrecioEntrada() * cantidad;
        Tique tique = new Tique(eventoDePrueba,usuarioDePrueba);
        System.out.println("El coste total es: " + costeTotal);
        //Realizar pago del usuario
        this.usuarioDePrueba.getDetallePago().realizarPago(costeTotal, this.usuarioDePrueba.getDetallePago().getTipoTarjeta());
        //Evento registra una venta
        this.eventoDePrueba.registrarVenta(cantidad);
        return tique;
    }
}
