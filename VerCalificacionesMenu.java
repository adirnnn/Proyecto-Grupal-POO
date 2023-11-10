import java.util.List;
import java.util.Scanner;

public class VerCalificacionesMenu {
    private Biblioteca biblioteca;

    public VerCalificacionesMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void verCalificaciones(Usuario usuario) {
        List<Calificacion> calificaciones = biblioteca.obtenerCalificaciones(usuario);

        if (calificaciones.isEmpty()) {
            System.out.println("No has dado calificaciones aún.");
        } else {
            System.out.println("Tus Calificaciones:");
            for (Calificacion calificacion : calificaciones) {
                System.out.println("Libro: " + calificacion.getLibro().getTitulo());
                System.out.println("Calificación: " + calificacion.getCalificacion());
                System.out.println("Reseña: " + calificacion.getResena());
                System.out.println("--------------------");
            }
        }
    }
}
