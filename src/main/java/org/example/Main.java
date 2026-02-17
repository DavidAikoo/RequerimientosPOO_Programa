package org.example;

import org.example.Controller.CitaController;
import org.example.Model.EstadoCita;
import org.example.Service.CitaService;
import org.example.Service.CitaServiceImpl;
import org.example.View.CitaView;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Main {
    private static CitaController citaController;
    private static Scanner scanner;

    public static void main(String[] args) {
        System.out.println("=============== SISTEMA DE CITAS ===============");

        // Inicializar servicio y vista de citas
        CitaService citaService = new CitaServiceImpl();
        CitaView citaView = new CitaView();
        citaController = new CitaController(citaService, citaView);
        scanner = new Scanner(System.in);

        mostrarMenu();
    }

    private static void mostrarMenu() {
        boolean activo = true;
        while (activo) {
            System.out.println("=============== MENÚ PRINCIPAL ===============");
            System.out.println("1. Registrar una nueva cita");
            System.out.println("2. Listar todas las citas");
            System.out.println("3. Cambiar estado de una cita");
            System.out.println("4. Eliminar una cita");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();
            System.out.println();

            switch (opcion) {
                case 1:
                    registrarCita();
                    break;
                case 2:
                    listarCitas();
                    break;
                case 3:
                    cambiarEstadoCita();
                    break;
                case 4:
                    eliminarCita();
                    break;
                case 5:
                    System.out.println("Hasta luego!");
                    activo = false;
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }
        scanner.close();
    }

    private static void registrarCita() {
        System.out.println("--- REGISTRAR NUEVA CITA ---");
        System.out.print("Ingrese el nombre del paciente: ");
        String nombrePaciente = scanner.nextLine().trim();

        if (nombrePaciente.isEmpty()) {
            System.out.println("ERROR: El nombre del paciente no puede estar vacío");
            return;
        }

        System.out.println("Ingrese la fecha y hora de la cita:");
        System.out.print("Año (ej: 2026): ");
        int anio = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Mes (1-12): ");
        int mes = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Día (1-31): ");
        int dia = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Hora (0-23): ");
        int hora = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Minuto (0-59): ");
        int minuto = scanner.nextInt();
        scanner.nextLine();

        LocalDateTime fecha = LocalDateTime.of(anio, mes, dia, hora, minuto);
        citaController.registrarCita(nombrePaciente, fecha);
    }

    private static void listarCitas() {
        System.out.println("--- LISTAR CITAS ---");
        citaController.listarCitas();
    }

    private static void cambiarEstadoCita() {
        System.out.println("--- CAMBIAR ESTADO DE CITA ---");
        System.out.print("Ingrese el ID de la cita: ");
        Long citaId = scanner.nextLong();
        scanner.nextLine();

        System.out.println("Estados disponibles:");
        System.out.println("1. PROGRAMADA");
        System.out.println("2. CANCELADA");
        System.out.println("3. ATENDIDA");
        System.out.print("Seleccione el nuevo estado: ");

        int opcionEstado = scanner.nextInt();
        scanner.nextLine();
        EstadoCita nuevoEstado = null;

        switch (opcionEstado) {
            case 1:
                nuevoEstado = EstadoCita.PROGRAMADA;
                break;
            case 2:
                nuevoEstado = EstadoCita.CANCELADA;
                break;
            case 3:
                nuevoEstado = EstadoCita.ATENDIDA;
                break;
            default:
                System.out.println("Estado no válido");
                return;
        }

        citaController.cambiarEstado(citaId, nuevoEstado);
    }

    private static void eliminarCita() {
        System.out.println("--- ELIMINAR CITA ---");
        System.out.print("Ingrese el ID de la cita a eliminar: ");
        Long citaId = scanner.nextLong();
        scanner.nextLine();
        citaController.eliminarCita(citaId);
    }

}