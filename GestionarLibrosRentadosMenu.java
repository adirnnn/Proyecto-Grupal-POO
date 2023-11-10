import java.util.List;
import java.util.Scanner;

public class GestionarLibrosRentadosMenu {
    /**
     *
     */
    private Biblioteca biblioteca;

    /**
     * @param biblioteca
     */
    public GestionarLibrosRentadosMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * @param scanner
     * @param usuario
     */
    public void gestionarLibrosRentados(Scanner scanner, Usuario usuario) {
        List<Libro> librosRentados = biblioteca.obtenerLibrosRentados(usuario);

        if (librosRentados.isEmpty()) {
            System.out.println("No has rentado ningún libro aún.");
        } else {
            System.out.println("Libros Rentados:");
            for (int i = 0; i < librosRentados.size(); i++) {
                System.out.println((i + 1) + ". " + librosRentados.get(i).toString());
            }
        }
    }
}