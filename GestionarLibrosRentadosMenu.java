import java.util.List;
import java.util.Scanner;

public class GestionarLibrosRentadosMenu {
    private Biblioteca biblioteca;

    public GestionarLibrosRentadosMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void verLibrosRentados(Usuario usuario) {
        List<Libro> librosRentados = biblioteca.obtenerLibrosRentados(usuario);

        if (librosRentados.isEmpty()) {
            System.out.println("No has rentado ningún libro aún.");
        } else {
            System.out.println("Libros Rentados:");
            for (Libro libro : librosRentados) {
                System.out.println("Título: " + libro.getTitulo());
                System.out.println("Tipo: " + (libro.esVirtual() ? "Virtual" : "Físico"));
                System.out.println("--------------------");
            }
        }
    }

    public void rentarLibro(Scanner scanner, Usuario usuario) {
        System.out.print("Ingrese el título del libro que desea rentar: ");
        String tituloLibro = scanner.nextLine();

        Libro libro = biblioteca.buscarLibroPorTitulo(tituloLibro);

        if (libro != null) {
            if (!biblioteca.estaLibroRentado(usuario, libro)) {
                // Realizar la operación de renta
                biblioteca.rentarLibro(usuario, libro);
                System.out.println("Libro rentado con éxito.");
            } else {
                System.out.println("Ya tienes este libro rentado.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }

    public void devolverLibro(Scanner scanner, Usuario usuario) {
        System.out.print("Ingrese el título del libro que desea devolver: ");
        String tituloLibro = scanner.nextLine();

        Libro libro = biblioteca.buscarLibroPorTitulo(tituloLibro);

        if (libro != null) {
            if (biblioteca.estaLibroRentado(usuario, libro)) {
                // Realizar la operación de devolución
                biblioteca.devolverLibro(usuario, libro);
                System.out.println("Libro devuelto con éxito.");
            } else {
                System.out.println("No tienes este libro rentado.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}
