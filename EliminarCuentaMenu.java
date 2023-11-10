import java.util.Scanner;

public class EliminarCuentaMenu {
    private Biblioteca biblioteca;

    public EliminarCuentaMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void eliminarCuenta(Scanner scanner, Usuario usuario) {
        System.out.println("¿Estás seguro de que deseas eliminar tu cuenta? (S/N)");
        String confirmacion = scanner.nextLine().toUpperCase();

        if (confirmacion.equals("S")) {
            // Eliminar cuenta del sistema
            biblioteca.eliminarUsuario(usuario);
            System.out.println("Tu cuenta ha sido eliminada. Gracias por usar nuestro servicio.");
            System.exit(0);  // O cualquier otra lógica de salida que desees
        } else {
            System.out.println("Operación cancelada. Tu cuenta permanece activa.");
        }
    }
}
