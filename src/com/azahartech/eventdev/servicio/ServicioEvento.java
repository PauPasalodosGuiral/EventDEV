package com.azahartech.eventdev.servicio;

import com.azahartech.eventdev.datos.RepositorioGenerico;
import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.util.UtilidadValidacion;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.HashMap;


public class ServicioEvento {
    private Evento eventoDePrueba;
    private Usuario usuarioDePrueba;
    //private Evento[] carteleraDestacados;
    //private ArrayList<Evento> listaEventos;
    //private RepositorioGenerico<Evento> repositorio = new RepositorioGenerico<>();
    private HashMap<String, Evento> mapaEventos = new HashMap<>();

    public Evento partido1;
    public Evento partido2;

    public Evento concierto1;
    public Evento concierto2;

    private Recinto recinto1 = new Recinto("estdio","Castellon", 1000);

    public ServicioEvento() {
        Recinto recintoDePrueba = new Recinto("mercandona", "Calle Mayor", 100);
        DetallePago detallePagoDePrueba = new DetallePago("credito","1122334455667788");
        //this.eventoDePrueba = new Evento("Comprar", LocalDate.of(2025, 12, 01), recintoDePrueba, 10);
        //this.usuarioDePrueba = new Usuario("pau","pau@gmail.com", detallePagoDePrueba);
        //carteleraDestacados = new Evento[5];
        //this.listaEventos = new ArrayList<>();
        partido1 = new Partido("Barça-Madrid", LocalDate.now(), recinto1,100,false, "Barça", "Madrid",1000,200);
        partido2 = new Partido("Vila-Castellon", LocalDate.now(), recinto1,100,false, "Vila", "castellon",1000,200);
        concierto1 = new Concierto("MiloJ",LocalDate.now(),recinto1,100,"Drums",false,1000);
        concierto2 = new Concierto("BonJouvi",LocalDate.now(),recinto1,100,"Drums",false,1000);

        mapaEventos.put(partido1.getId(), partido1);
        mapaEventos.put(partido2.getId(), partido2);
        mapaEventos.put(concierto1.getId(), concierto1);
        mapaEventos.put(concierto2.getId(), concierto2);

    }

    public void generarInformeFinanciero() {
        mapaEventos.values().forEach(evento ->
                System.out.printf(
                        "Evento: %s%n" +
                                "\tCoste operativo: %10.2f EUR%n" +
                                "\tPrecio sugerido: %10.2f EUR%n%n",
                        evento.getNombreEvento(),
                        evento.calcularCosteOperativo(),
                        evento.calcularPrecioVentaRecomendado()
                ));
    }



    public long contarEventosPorAforo(int aforoMinimo) {
        return mapaEventos.values().stream()
                .filter(evento -> evento.getRecinto().getAforoMaximo() > aforoMinimo).count();
    }

    public void registrarEvento(Evento evento) {
        if (UtilidadValidacion.esCodigoEventoValido(evento.getId())) {
            mapaEventos.put(evento.getId(), evento);
        } else {
            System.err.println("ID NO VALIDADA");
        }
    }

    public void mostrarCatalogo() {
        for (Evento evento : mapaEventos.values()) {
            evento.mostrarInformacion();
        }
    }

    public Evento buscarEventoPorId(String id) {
        return mapaEventos.get(id);
    }

    public void eliminarEvento(String id) {
        mapaEventos.remove(id);
    }

    public ArrayList<Evento> obtenerEventosConAforoMayorA(int capacidad) {

        ArrayList<Evento> listaResultado = new ArrayList<>();
                mapaEventos.values().stream()
                        .filter(evento -> evento.getRecinto().getAforoMaximo() > capacidad)
                        .forEach(evento -> listaResultado.add(evento));
         return listaResultado;
    }

    public long contarEventosBeneficos() {
        return mapaEventos.values().stream()
                .filter(evento -> evento.getEsBenefico() == true)
                .count();
    }
    /*public void eliminarEventosPasados() {
            Iterator<Evento> iterator = this.listaEventos.iterator();
            while (iterator.hasNext()) {
                Evento eventoActual =  iterator.next();
                if (eventoActual.getFechaEvento().isBefore(LocalDate.now())) {
                    iterator.remove();
                    System.out.println("Eliminado evento caducado: [" + eventoActual.getNombreEvento() +"].");
                }
            }
        }*/
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
