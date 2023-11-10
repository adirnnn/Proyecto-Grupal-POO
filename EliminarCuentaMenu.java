import java.util.Scanner;

public class EliminarCuentaMenu {
    /**
     *
     */
    private Biblioteca biblioteca;

    /**
     * @param biblioteca
     */
    public EliminarCuentaMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * @param scanner
     * @param usuario
     */
    public void eliminarCuenta(Scanner scanner, Usuario usuario) {
        System.out.println("¿Está seguro de que desea eliminar su cuenta? (Sí/No)");
        String respuesta = scanner.nextLine();

        if (respuesta.equalsIgnoreCase("Sí")) {
            biblioteca.eliminarUsuario(usuario);
            System.out.println("Cuenta eliminada exitosamente. Gracias por usar nuestra biblioteca.");
        } else {
            System.out.println("Operación cancelada. Volviendo al menú anterior.");
        }
    }
}