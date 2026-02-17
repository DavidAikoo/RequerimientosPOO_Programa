package org.example.Service;

import org.example.Model.Cita;
import org.example.Model.EstadoCita;
import java.time.LocalDateTime;
import java.util.List;

public interface CitaService {

    Cita registrarCita(String nombrePaciente, LocalDateTime fecha);

    List<Cita> listarCitas();

    boolean cambiarEstado(Long citaId, EstadoCita nuevoEstado);

    boolean eliminarCita(Long citaId);
}

