package com.azahartech.eventdev.modelo;

public class Comentario {
    private Evento evento;
    private Usuario autor;
    private int puntuacion;
    private String comentario;

    public Comentario(Evento evento, Usuario autor, int puntuacion, String comentario) {
        this.evento = evento;
        this.autor = autor;
        this.comentario = comentario;

       if ((puntuacion >=1) && (puntuacion <=5)) {
           this.puntuacion = puntuacion;
        } else {
           this.puntuacion = 0;
        }
    }

    public Evento getEvento() {
        return evento;
    }
    public Usuario getAutor() {
        return autor;

    }
    public int getPuntuacion() {
        return puntuacion;
    }
    public String getComentario() {
        return comentario;
    }
    public void mostrarInformacion() {
        System.out.println("\n---DATOS VALORACION---");
        System.out.printf("Usuario: %s%n", autor.getNombreUsuario());
        System.out.printf("Nombre evento: %s%n",evento.getNombreEvento());
        System.out.printf("Puntuacion: %d%n", puntuacion);
        System.out.printf("Comentario: %s%n", comentario);
    }
}
