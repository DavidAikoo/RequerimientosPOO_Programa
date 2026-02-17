package org.example.Model;

import java.time.LocalDateTime;

public class Cita {
    private static Long contadorId = 0L;

    private Long id;
    private String nombrePaciente;
    private LocalDateTime fecha;
    private EstadoCita estado;

    public Cita() {
    }

    public Cita(String nombrePaciente, LocalDateTime fecha) {
        this.id = ++contadorId;
        this.nombrePaciente = nombrePaciente;
        this.fecha = fecha;
        this.estado = EstadoCita.PROGRAMADA;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombrePaciente() {
        return nombrePaciente;
    }

    public void setNombrePaciente(String nombrePaciente) {
        this.nombrePaciente = nombrePaciente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public void setEstado(EstadoCita nuevoEstado) {
        // Regla: Una cita cancelada no puede marcarse como atendida
        if (this.estado == EstadoCita.CANCELADA && nuevoEstado == EstadoCita.ATENDIDA) {
            throw new IllegalArgumentException("Una cita cancelada no puede marcarse como atendida");
        }
        this.estado = nuevoEstado;
    }

    @Override
    public String toString() {
        return "Cita{" +
                "id=" + id +
                ", nombrePaciente='" + nombrePaciente + '\'' +
                ", fecha=" + fecha +
                ", estado=" + estado +
                '}';
    }
}

