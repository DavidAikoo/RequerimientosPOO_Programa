package org.example.View;

import org.example.Model.Cita;
import java.util.List;

public class CitaView {

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public void mostrarError(String mensaje) {
        System.out.println("ERROR: " + mensaje);
    }

    public void mostrarCitas(List<Cita> citas) {
        System.out.println("========== CITAS REGISTRADAS ==========");
        citas.forEach(cita -> System.out.println(cita));
        System.out.println("========================================");
    }
}

