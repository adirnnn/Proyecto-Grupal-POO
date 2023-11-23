import java.util.Scanner;

public class EliminarCuentaMenu {
    private Biblioteca biblioteca;

    public EliminarCuentaMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void eliminarCuenta(Scanner scanner, Usuario usuario) {
        boolean respuestaValida = false;

        while (!respuestaValida) {
            System.out.println("¿Está seguro de que desea eliminar su cuenta? (Sí/No)");
            String respuesta = scanner.nextLine().trim();

            if (respuesta.equalsIgnoreCase("Sí")) {
                biblioteca.eliminarUsuario(usuario);
                System.out.println("Cuenta eliminada exitosamente. Gracias por usar nuestra biblioteca.");
                respuestaValida = true;
            } else if (respuesta.equalsIgnoreCase("No")) {
                System.out.println("Operación cancelada. Volviendo al menú anterior.");
                respuestaValida = true;
            } else {
                System.out.println("Respuesta no válida. Por favor, responda 'Sí' o 'No'.");
            }
        }
    }
}
