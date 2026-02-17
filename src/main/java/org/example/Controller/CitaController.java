package org.example.Controller;

import org.example.Model.Cita;
import org.example.Model.EstadoCita;
import org.example.Service.CitaService;
import org.example.View.CitaView;
import java.time.LocalDateTime;
import java.util.List;

public class CitaController {

    private CitaService service;
    private CitaView view;

    public CitaController(CitaService service, CitaView view) {
        this.service = service;
        this.view = view;
    }

    public Cita registrarCita(String nombrePaciente, LocalDateTime fecha) {
        Cita cita = service.registrarCita(nombrePaciente, fecha);
        view.mostrarMensaje("Cita registrada exitosamente: " + cita);
        return cita;
    }

    public void listarCitas() {
        List<Cita> citas = service.listarCitas();
        if (citas.isEmpty()) {
            view.mostrarMensaje("No hay citas registradas");
        } else {
            view.mostrarCitas(citas);
        }
    }

    public void cambiarEstado(Long citaId, EstadoCita nuevoEstado) {
        boolean exito = service.cambiarEstado(citaId, nuevoEstado);
        if (exito) {
            view.mostrarMensaje("Estado de la cita " + citaId + " actualizado a: " + nuevoEstado);
        } else {
            view.mostrarError("Cita no encontrada con id: " + citaId);
        }
    }

    public void eliminarCita(Long citaId) {
        boolean exito = service.eliminarCita(citaId);
        if (exito) {
            view.mostrarMensaje("Cita " + citaId + " eliminada exitosamente");
        } else {
            view.mostrarError("Cita no encontrada con id: " + citaId);
        }
    }
}

