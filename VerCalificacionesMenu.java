import java.util.List;
import java.util.Scanner;

public class VerCalificacionesMenu {
    private Biblioteca biblioteca;

    public VerCalificacionesMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void verCalificaciones(Scanner scanner, Usuario usuario) {
        List<Calificacion> calificacionesUsuario = biblioteca.obtenerCalificaciones(usuario);

        if (calificacionesUsuario.isEmpty()) {
            System.out.println("No has realizado calificaciones aún.");
        } else {
            System.out.println("Tus Calificaciones:");
            for (int i = 0; i < calificacionesUsuario.size(); i++) {
                System.out.println((i + 1) + ". " + calificacionesUsuario.get(i).toString());
            }
        }
    }
}
