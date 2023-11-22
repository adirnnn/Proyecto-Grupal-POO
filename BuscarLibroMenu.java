import java.util.List;
import java.util.Scanner;

/**
 * Clase BuscarLibroMenu.
 * 
 * Esta clase representa un menú para buscar libros en una biblioteca.
 */
public class BuscarLibroMenu {
    /**
     * Constructor de la clase BuscarLibroMenu.
     * 
     * @param biblioteca La biblioteca en la que se realizará la búsqueda de libros.
     */
    public BuscarLibroMenu(Biblioteca biblioteca) {
    }

    /**
     * Método para buscar un libro en la biblioteca.
     * 
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
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

    /**
     * Método privado para mostrar los detalles de un libro.
     * 
     * @param libro El libro del que se mostrarán los detalles.
     */
    private void mostrarDetallesLibro(Libro libro) {
        System.out.println("Detalles del Libro:");
        System.out.println(libro.toString());
    }

    /**
     * Método privado para obtener un número entero de la entrada del usuario.
     * 
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     * @return El número entero obtenido.
     */
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