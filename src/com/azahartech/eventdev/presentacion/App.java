package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.servicio.ServicioEvento;
import com.azahartech.eventdev.servicio.ServicioUsuario;
import com.azahartech.eventdev.util.UtilidadValidacion;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import java.util.*;

/**
 * Aplicación de gestion de eventos y usuarios
 *
 * @author Pau
 * @version 1.0.
 */

public class App {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        Usuario usuario1 = new Usuario("pau","pau@gmail.com",null,true);
        Usuario usuario2 = new Usuario("pau","pau@gmail.com",null,true);

        Concierto concierto = new Concierto("Ariana Grande", LocalDate.now(), new Recinto(null,null,100), 100, "los cantantes", true);
        ServicioEvento servicioEvento = new ServicioEvento();

        servicioEvento.registrarEvento(concierto);
        int opcion;
        opcion = -1;



        do {
            try {
                System.out.println("\n---MENÚ DE EVENTDEV---");
                System.out.println("1. Concierto");
                System.out.println("2. Partido");
                System.out.println("3. Registrar Usuario");
                System.out.println("4. Salir");
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        System.out.println(concierto.obtenerCodigoReferencia());

                        break;
                    case 2:

                        break;
                    case 3:
                        ServicioUsuario servicioUsuario = new ServicioUsuario();
                        String email;
                        do {
                            System.out.println("dame tu email");
                            email = teclado.nextLine();
                        } while (!UtilidadValidacion.esEmailValido(email));
                        System.out.println("Email verificado");
                        servicioUsuario.registrarUsuario(usuario1);
                        servicioUsuario.registrarUsuario(usuario2);
                        break;
                    case 4:
                        System.out.println("Saliendo de la aplicación. ¡Hasta pronto!");
                        break;
                    default:
                        System.err.println("Opción no valida.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.err.println("ERROR: Debes introducir un número.");
                teclado.nextLine();//para limpiar el buffer y que no se cree un bucle
            } catch (DateTimeParseException e) {
                System.err.println("ERROR: El formato correcto para la fecha es '0000-00-00'");
            }
        } while (opcion != 4);
        teclado.close();
    }
}