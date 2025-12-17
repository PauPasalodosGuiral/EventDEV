package com.azahartech.eventdev.presentacion;

import com.azahartech.eventdev.modelo.*;
import com.azahartech.eventdev.servicio.ServicioEvento;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
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

        int opcion;
        opcion = -1;

        //Datos Evento
        String nombreEvento;
        LocalDate fecha;
        double precioEntrada;
        //Datos Concierto
        String bandaPrincipal;
        //Datos Partido
        String equipoLocal;
        String equipoVisitante;

        do {
            try {
                System.out.println("\n---MENÚ DE EVENTDEV---");
                System.out.println("1. Concierto");
                System.out.println("2. Partido");
                System.out.println("3. Login Usuario");
                System.out.println("4. Salir");
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        ServicioEvento servicioEvento = new ServicioEvento();
                        Recinto recinto = new Recinto("bla","hbddf",100);
                        servicioEvento.registrarEvento(new Evento("Evento1",LocalDate.of(2026,01,01),recinto,10));
                        servicioEvento.registrarEvento(new Evento("Evento2",LocalDate.of(2025,01,01),recinto,10));
                        servicioEvento.registrarEvento(new Evento("Evento3",LocalDate.of(2025,12,17),recinto,10));
                        servicioEvento.registrarEvento(new Evento("Evento4",LocalDate.of(2024,01,01),recinto,10));
                        servicioEvento.registrarEvento(new Evento("Evento5",LocalDate.of(2027,01,01),recinto,10));

                        servicioEvento.filtrarPorTipo("Evento3");


                        break;
                    case 2:



                        break;
                    case 3:

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

    /**
     * <p>Simula el funcionamiento de una contraseña fija.</p>
     * <p>
     * Si la contraseña que se introduce en el terminal no es igual
     * a la que hememos delimitado, nos devuelve contraseña incorrecta
     * y tendremos que volver a poner la contraseña por el terminal.
     *
     * <p>Cuando el usuario acierte la clontraseña finaliza el programa</p>
     */

    private static void simularLogin() {
        final String CONTRASEÑA_CORRECTA = "12345";
        String intentoContraseña;
        Scanner teclado = new Scanner(System.in);
        do {
            System.out.println("Introduce la contraseña");
            intentoContraseña = teclado.nextLine();

            if (intentoContraseña.equals(CONTRASEÑA_CORRECTA)) {
                System.out.println("---Acceso Concedido---");
            } else {
                System.err.println("---Contraseña Incorrecta---");
            }
        } while (!intentoContraseña.equals(CONTRASEÑA_CORRECTA));
    }

    /**
     * <p>Primero nos pide que introduzcamos datos</p>
     * <p>Hace los calculos y la lógica de esos datos introducidos</p>
     * <p>Nos muestra el ticket por pantalla del resultado</p>
     */

    private static void ejecutarLogicaDePrecios() {
        Scanner teclado = new Scanner(System.in);
        Locale español = Locale.of("es", "ES");
        Random random = new Random();
        //assert teclado != null : "Error crítico: el Scanner no puede ser nulo.";
        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance();
        //DecimalFormat dfPorcentaje = new DecimalFormat("#.##%");
        DecimalFormat dfId = new DecimalFormat("000000");


        //String idCompra;
        //double descuentoPromocional;
        int filaAsiento;
        int numeroAsiento;
        //Datos Fecha
        int diaNumero;
        int mesNumero;
        int añoNumero;
        //Datos Recinto
        String nombreRecinto;
        String direccion;
        int aforoMaximo;
        int salidasEmergencia;
        double catetoA;
        double catetoB;
        //Datos Evento
        String idEvento;
        String nombreEvento;
        double precioEntrada;
        boolean esBenefico;
        //Datos Usuario
        int edadComprador;
        boolean esEstudiante;
        int suplemento;

        String nombreUsuario;
        String email;
        //Datos Pago
        String tipoTarjeta;
        String numeroTarjeta;
        //Datos Compra
        int cantidadDeEntradasAComprar;
        //Datos Valoración
        int puntuacion;
        String comentario;
        //Datos Validación
        boolean nombreEventoValidacion;
        boolean emailValidacion;
        boolean numeroTarjetaValidacion;
        boolean puntuacionValidacion;
        boolean comentarioValidacion;
        //Datos Fragmentar codigo
        String codigoReserva;
        int primerGuion;
        int segundoGuion;
        int tercerGuion;
        String codigoReservaEstado;
        String codigoReservaCiudad;
        String codigoReservaAño;
        String codigoReservaSerial;
        //Datos fecha
        LocalDate fecha;
        String diaAñoEcrito;
        String mesAñoEcrito;
        int diaDelAño;
        int diasDelAño;
        boolean esBisiesto;
        LocalDate fechaLimiteDevolucion;
        LocalDate fechaInicioVentaGeneral;
        LocalDate fechaEnvioRecordatorio;
        final LocalDate fechaActual;
        boolean eventoEsPasado;
        boolean eventoEsFuturo;
        //boolean eventoEsHoy;
        long cuantosDiasQuedan;
        //Datos calculos
        double ratioSalidasEmergencia;
        double hipotenusa;
        double subtotal;
        double precioFinal;
        //Formatos
        String precioEntradaMoneda;
        //String precioFinalMoneda;
        //String descuentoPromocionalPorcentaje;
        int idCompraString;
        String idCompraDigitos;

        boolean cantidadDeEntradasAComprarValidacion;
        boolean aforoValidacion;
        boolean fechaEventoValidacion;
        boolean compraValida;


        //---TECLADO Recinto
        System.out.println("Nombre Recinto:");
        nombreRecinto = teclado.nextLine();
        System.out.println("Dirección:");
        direccion = teclado.nextLine();

        System.out.println("Aforo Maximo:");
        aforoMaximo = teclado.nextInt();

        teclado.nextLine();

        System.out.println("Salidas de emergencia(número):");
        salidasEmergencia = teclado.nextInt();

        teclado.nextLine();

        System.out.println("Cuanto mide de largo(numero):");
        catetoA = teclado.nextDouble();

        teclado.nextLine();

        System.out.println("Cuanto mide de ancho(numero)");
        catetoB = teclado.nextDouble();

        teclado.nextLine();

        //---TECLADO Evento
        System.out.println("Nombre Evento:");
        nombreEvento = teclado.nextLine();

        System.out.println("Precio Entrada:");
        precioEntrada = teclado.nextDouble();

        teclado.nextLine();

        System.out.println("Es Benefico(true/false):");
        esBenefico = teclado.nextBoolean();

        teclado.nextLine();

        //---TECLADO Ususario
        System.out.println("Nombre Usuario:");
        nombreUsuario = teclado.nextLine();

        System.out.println("Email:");
        email = teclado.nextLine();

        System.out.println("Cual es tu edad:");
        edadComprador = teclado.nextInt();

        teclado.nextLine();

        System.out.println("Es estudiante(true/false):");
        esEstudiante = teclado.nextBoolean();

        teclado.nextLine();

        //---TECLADO Pago
        System.out.println("Tipo Tarjeta:");
        tipoTarjeta = teclado.nextLine();

        System.out.println("Numero Tarjeta:");
        numeroTarjeta = teclado.nextLine();

        //---TECLADO Compra
        System.out.println("Cantidad Entradas:");
        cantidadDeEntradasAComprar = teclado.nextInt();

        teclado.nextLine();

        //---TECLADO Valoración
        System.out.println("Puntuación(1-5):");
        puntuacion = teclado.nextInt();

        teclado.nextLine();

        System.out.println("Comentario:");
        comentario = teclado.nextLine();

        //---TECLADO Fecha
        System.out.println("Que año es(número)");
        añoNumero = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Que mes es(número)");
        mesNumero = teclado.nextInt();
        teclado.nextLine();

        System.out.println("Que dia es(número)");
        diaNumero = teclado.nextInt();
        teclado.nextLine();

        //NORMALIZACION

        //Nombres en blanco
        nombreRecinto = nombreRecinto.trim();

        nombreEvento = nombreEvento.trim();

        nombreUsuario = nombreUsuario.trim();

        email = email.trim();

        //Primera Mayuscula y el resto minuscula

        nombreRecinto = nombreRecinto.substring(0, 1).toUpperCase() + nombreRecinto.substring(1).toLowerCase();

        nombreEvento = nombreEvento.substring(0, 1).toUpperCase() + nombreEvento.substring(1).toLowerCase();

        //Todo a minusculas
        email = email.toLowerCase();

        tipoTarjeta = tipoTarjeta.toLowerCase();

        //REGLAS VALIDACION

        //V1
        nombreEventoValidacion = nombreEvento.length() >= 5;

        //V2
        emailValidacion = email.contains("@") && !email.startsWith("@");

        //V3
        numeroTarjetaValidacion = numeroTarjeta.length() == 16;

        //V4
        puntuacionValidacion = (puntuacion >= 1) && (puntuacion <= 5);

        //V5
        comentarioValidacion = !comentario.isEmpty();


        //PARSING

        codigoReserva = "CONFIRMADO-MAD-2024-12345";

        //---Buscamos los guiones
        primerGuion = codigoReserva.indexOf("-");
        segundoGuion = codigoReserva.indexOf("-", primerGuion + 1);
        tercerGuion = codigoReserva.lastIndexOf("-");

        //---Delimitamos con .substring()
        codigoReservaEstado = codigoReserva.substring(0, primerGuion);
        codigoReservaCiudad = codigoReserva.substring(primerGuion + 1, segundoGuion);
        codigoReservaAño = codigoReserva.substring(segundoGuion + 1, tercerGuion);
        codigoReservaSerial = codigoReserva.substring(tercerGuion + 1);

        //Nombre dia mes
        fecha = LocalDate.of(añoNumero, mesNumero, diaNumero);

        diaAñoEcrito = fecha.getDayOfWeek().getDisplayName(TextStyle.FULL, español);
        mesAñoEcrito = fecha.getMonth().getDisplayName(TextStyle.FULL, español);

        diaDelAño = fecha.getDayOfYear();

        diasDelAño = fecha.lengthOfYear();

        esBisiesto = diasDelAño == 366;

        //LOGICA TEMPORAL, COMPARACIONES
        //Calculo fechas clave
        fechaLimiteDevolucion = fecha.minusDays(7);
        fechaInicioVentaGeneral = fecha.minusMonths(3);
        fechaEnvioRecordatorio = fecha.minusDays(2);

        //Logica estado temporal
        fechaActual = LocalDate.now();

        eventoEsPasado = fechaActual.isAfter(fecha);
        eventoEsFuturo = fechaActual.isBefore(fecha);
        //eventoEsHoy= fechaActual.isEqual(fecha);

        //Calculo de duracion
        cuantosDiasQuedan = ChronoUnit.DAYS.between(fechaActual, fecha);

        //idCompra = UUID.randomUUID().toString();
        idEvento = UUID.randomUUID().toString();
        //Random Logica


        filaAsiento = random.nextInt(1, 25);

        numeroAsiento = random.nextInt(1, 40);

        //Calculos personas por salida

        ratioSalidasEmergencia = (double) Math.round(((double) aforoMaximo / salidasEmergencia) * 100) / 100;

        hipotenusa = (double) Math.round((Math.sqrt(Math.pow(catetoA, 2) + Math.pow(catetoB, 2))) * 100) / 100;

        //Calculos de random descuento

        subtotal = precioEntrada * cantidadDeEntradasAComprar;

        assert subtotal >= 0 : "Error de lógica: el precio base no puede ser negativo.";

        //precioFinal = (double) Math.round((subtotal - subtotal * descuentoPromocional) * 100) / 100;

        //FORMATO
        //€
        precioEntradaMoneda = formatoMoneda.format(precioEntrada);
        //precioFinalMoneda = formatoMoneda.format(precioFinal);
        //%
        //descuentoPromocionalPorcentaje = dfPorcentaje.format(descuentoPromocional);
        //X numero de digitos
        idCompraString = random.nextInt(0, 999999);
        idCompraDigitos = dfId.format(idCompraString);
        //validación IF
        cantidadDeEntradasAComprarValidacion = cantidadDeEntradasAComprar > 0;
        aforoValidacion = aforoMaximo >= cantidadDeEntradasAComprar;
        fechaEventoValidacion = fechaActual.isBefore(fecha);
        compraValida = (cantidadDeEntradasAComprarValidacion && aforoValidacion && fechaEventoValidacion);


        //Bucle asistentes de la cantidad de entradas a comprar
        for (int i = 1; i < cantidadDeEntradasAComprar + 1; i++) {
            System.out.println("Introduce el nombre del asistente " + i + " de " + cantidadDeEntradasAComprar);
            System.out.printf("Asistente %s registrado\n", teclado.nextLine());
        }
        //PRINT LOGICA
        if (compraValida) {

            //PRINT
            System.out.println("\n--- DATOS DEL RECINTO ---");
            System.out.printf("El nombre del recinto es: %s%n", nombreRecinto);
            System.out.printf("La dirección es: %s%n", direccion);
            System.out.printf("El aforo máximo es: %d%n", aforoMaximo);
            System.out.printf("La diagonal(h) de el area de el evento es de %f metros%n", hipotenusa);
            System.out.printf("Ratio de %f  personas por salida de emergemcia%n%n", ratioSalidasEmergencia);

            System.out.println("--- DATOS DEL EVENTO ---");
            System.out.printf("El nombre del evento es: %s.%n", nombreEvento);
            System.out.printf("ID del Evento: %s%n", idEvento);
            System.out.printf("El precio de la entrada es de %s%n", precioEntradaMoneda);
            System.out.printf("Es Benefico? %b.%n%n", esBenefico);

            System.out.println("--- DATOS DEL USUARIO ---");
            System.out.printf("El nombre de usuario es: %s%n", nombreUsuario);
            System.out.printf("El email es: %s%n%n", email);

            System.out.println("--- DATOS DE PAGO ---");
            System.out.printf("Tipo tarjeta: %s%n", tipoTarjeta);
            System.out.printf("Numero tarjeta: %s%n", numeroTarjeta);

            System.out.println("--- DATOS DE COMPRA ---");
            System.out.printf("Cantidad entradas: %d%n%n", cantidadDeEntradasAComprar);

            System.out.println("--- DATOS DE VALORACIÓN ---");
            System.out.printf("Puntuación:  %d%n", puntuacion);
            System.out.printf("Comentario: %s%n%n", comentario);

            System.out.println("--- INFORME DE VALIDACIÓN ---");
            System.out.printf("Nombre de evento válido: %b%n", nombreEventoValidacion);
            System.out.printf("Formato de email válido: %b%n", emailValidacion);
            System.out.printf("Longitud de tarjeta válida: %b%n", numeroTarjetaValidacion);
            System.out.printf("Puntuación válida: %b%n", puntuacionValidacion);
            System.out.printf("Comentario válido: %b%n%n", comentarioValidacion);

            System.out.println("--- DATOS CÓDIGO RESERVA ---");
            System.out.printf("Estado: %s%n", codigoReservaEstado);
            System.out.printf("Ciudad: %s%n", codigoReservaCiudad);
            System.out.printf("Año: %s%n", codigoReservaAño);
            System.out.printf("Serial: %s%n%n", codigoReservaSerial);

            System.out.println("---CALCULOS FECHA---");
            System.out.printf("La fecha es: %s%n%n", fecha);
            System.out.printf("El dia escrito es: %s%n", diaAñoEcrito);
            System.out.printf("El mes escrito es: %s%n", mesAñoEcrito);
            System.out.printf("El dia del año es: %d%n", diaDelAño);
            System.out.printf("Es año bisiesto: %b%n%n", esBisiesto);

            System.out.println("---FECHAS CLAVE---");
            System.out.printf("La fecha límite de devolución es el: %s%n%n", fechaLimiteDevolucion);
            System.out.printf("La fecha de inicio de venta general es el: %s%n%n", fechaInicioVentaGeneral);
            System.out.printf("La fecha de envío de recordatorio es el: %s%n%n", fechaEnvioRecordatorio);

            //Logica de estado temporal PRINT
            System.out.println("---CALCULO FECHAS DURACIÓN---");
            if (eventoEsPasado) {
                System.out.println("El evento ya ha pasado.\n");
            } else if (eventoEsFuturo) {
                System.out.println("El evento es en el futuro.");
                System.out.printf("-Quedan %d dias.%n%n", cuantosDiasQuedan);
            } else {
                System.out.println("¡El evento es hoy!\n");
            }
            //------------------
            System.out.println("---DATOS RANDOM---");
            System.out.printf("ID COMPRA: %s%n", idCompraDigitos);
            //System.out.printf("Descuento pormocional: %s%n", descuentoPromocionalPorcentaje);
            System.out.printf("Fila: %d%n", filaAsiento);
            System.out.printf("Asiento: %d%n%n", numeroAsiento);

            System.out.println("---CALCULO PRECIO FINAL---");
            if (edadComprador < 12) {
                precioFinal = subtotal - (subtotal * 0.50);
                System.out.println("Aplicado descuento infantil (50%).");
            } else if (edadComprador >= 65) {
                precioFinal = subtotal - (subtotal * 0.30);
                System.out.println("Aplicado descuento jubilado (30%).");
            } else if (esEstudiante) {
                precioFinal = subtotal - (subtotal * 0.20);
                System.out.println("Aplicado descuento estudiante (20%).");
            } else {
                precioFinal = subtotal;
            }

            if (diaAñoEcrito.equals("sabado") || diaAñoEcrito.equals("domingo")) {
                if (subtotal > 100) {
                    suplemento = 20;
                    precioFinal += 20;
                } else {
                    suplemento = 10;
                    precioFinal += 10;
                }
                System.out.println("Añadido suplemento de fin de semana: " + suplemento + " EUR");
            }

            System.out.printf("Subtotal: %.2f €%n", subtotal);
            System.out.printf("Precio Final: %s%n%n", precioFinal);

        } else {
            System.err.println("---[ERROR]: LA OPERACIÓN NO SE PUDO COMPLETAR---\n");
        }
    }
}
