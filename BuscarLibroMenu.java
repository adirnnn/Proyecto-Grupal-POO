import java.util.List;
import java.util.Scanner;

public class BuscarLibroMenu {
    private Biblioteca biblioteca;

    public BuscarLibroMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void buscarLibroPorTitulo(Scanner scanner) {
        System.out.print("Ingrese el título del libro a buscar: ");
        String tituloBusqueda = scanner.nextLine();

        List<Libro> librosEncontrados = biblioteca.buscarLibroPorTitulo(tituloBusqueda);

        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros con ese título.");
        } else {
            System.out.println("Libros Encontrados:");
            for (int i = 0; i < librosEncontrados.size(); i++) {
                System.out.println((i + 1) + ". " + librosEncontrados.get(i).getTitulo());
            }
        }
    }
}
