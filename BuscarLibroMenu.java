import java.util.List;
import java.util.Scanner;

public class BuscarLibroMenu {
    public BuscarLibroMenu(Biblioteca biblioteca) {
    }

    public void buscarLibro(Scanner scanner) {
        System.out.println("Ingrese el título o parte del título del libro que desea buscar:");
        String tituloBusqueda = scanner.nextLine();

        List<Libro> librosEncontrados = Biblioteca.buscarLibros(tituloBusqueda);

        if (librosEncontrados.isEmpty()) {
            System.out.println("No se encontraron libros con el título especificado.");
        } else {
            System.out.println("Libros Encontrados:");
            for (int i = 0; i < librosEncontrados.size(); i++) {
                System.out.println((i + 1) + ". " + librosEncontrados.get(i).toString());
            }

            System.out.print("Seleccione el número del libro que desea ver detalles (0 para volver): ");
            int seleccion = obtenerEnteroInput(scanner);

            if (seleccion >= 1 && seleccion <= librosEncontrados.size()) {
                mostrarDetallesLibro(librosEncontrados.get(seleccion - 1));
            } else if (seleccion == 0) {
                System.out.println("Volviendo al menú anterior.");
            } else {
                System.out.println("Selección no válida.");
            }
        }
    }

    private void mostrarDetallesLibro(Libro libro) {
        System.out.println("Detalles del Libro:");
        System.out.println(libro.toString());
    }

    private int obtenerEnteroInput(Scanner scanner) {
        int resultado = 0;
        boolean entradaValida = false;
        do {
            try {
                resultado = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        } while (!entradaValida);
        return resultado;
    }
}
