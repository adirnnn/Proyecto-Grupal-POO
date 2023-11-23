import java.util.List;

public class VerCalificacionesMenu {
    private Biblioteca biblioteca;

    public VerCalificacionesMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void verCalificaciones(Usuario usuario) {
        List<Calificacion> calificacionesUsuario = biblioteca.obtenerCalificaciones(usuario);

        if (calificacionesUsuario.isEmpty()) {
            System.out.println("No has realizado calificaciones aún.");
        } else {
            System.out.println("Tus Calificaciones:");
            int index = 1;
            for (Calificacion calificacion : calificacionesUsuario) {
                System.out.println(index++ + ". " + calificacion.toString());
            }
        }
    }
}
