import java.util.Scanner;

/**
 * Clase EliminarCuentaMenu.
 * 
 * Esta clase representa el menú de eliminación de cuenta de usuario.
 */
public class EliminarCuentaMenu {
    private Biblioteca biblioteca;

    /**
     * Constructor de la clase EliminarCuentaMenu.
     * 
     * @param biblioteca La biblioteca a la que pertenece el usuario.
     */
    public EliminarCuentaMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * Método para eliminar la cuenta de usuario.
     * 
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @param usuario El usuario que desea eliminar su cuenta.
     */
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