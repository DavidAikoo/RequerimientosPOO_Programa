package org.example.Service;

import org.example.Model.Cita;
import org.example.Model.EstadoCita;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class CitaServiceImpl implements CitaService {

    private List<Cita> citas = new ArrayList<>();

    @Override
    public Cita registrarCita(String nombrePaciente, LocalDateTime fecha) {
        Cita cita = new Cita(nombrePaciente, fecha);
        citas.add(cita);
        return cita;
    }

    @Override
    public List<Cita> listarCitas() {
        return new ArrayList<>(citas);
    }

    @Override
    public boolean cambiarEstado(Long citaId, EstadoCita nuevoEstado) {
        for (Cita cita : citas) {
            if (cita.getId().equals(citaId)) {
                cita.setEstado(nuevoEstado);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminarCita(Long citaId) {
        for (Cita cita : citas) {
            if (cita.getId().equals(citaId)) {
                citas.remove(cita);
                return true;
            }
        }
        return false;
    }
}

