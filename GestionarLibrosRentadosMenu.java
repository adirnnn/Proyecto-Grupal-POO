import java.util.List;
import java.util.Scanner;

/**
* Menú para gestionar los libros rentados por un usuario en la biblioteca.
*/
 public class GestionarLibrosRentadosMenu {
     private static final Scanner scanner = null;
     private Biblioteca biblioteca;
 
    /**
    * Crea una instancia de GestionarLibrosRentadosMenu con la biblioteca dada.
    *
    * @param  biblioteca     la biblioteca a utilizar (no nula)
    */
    public GestionarLibrosRentadosMenu(Biblioteca biblioteca) {
    this.biblioteca = biblioteca;
    }

    /**
    * Gestiona los libros rentados por un usuario.
    *
    * @param  scanner            el objeto Scanner utilizado para obtener la entrada del usuario (no nulo)
    * @param  usuario            el usuario para el cual se gestionan los libros rentados (no nulo)
    * @return                    nada
    */
    public void gestionarLibrosRentados(Scanner scanner, Usuario usuario) {
        List<Libro> librosRentados = biblioteca.obtenerLibrosRentados(usuario);

        if (librosRentados.isEmpty()) {
            System.out.println("No has rentado ningún libro aún.");
        } else {
            System.out.println("Libros Rentados:");
            int index = 1;
            for (Libro libro : librosRentados) {
                System.out.println(index + ". " + libro.toString());
                index++;
            }

            System.out.println("¿Deseas realizar alguna acción?");
            System.out.println("1. Devolver libro");
            System.out.println("2. Renovar préstamo");
            System.out.println("3. Volver al menú anterior");

            int opcion = obtenerEnteroInput(scanner, "Ingrese el número de la opción: ");

            switch (opcion) {
                case 1:
                    devolverLibro(scanner, usuario, librosRentados);
                    break;
                case 2:
                    renovarPrestamo(usuario, librosRentados);
                    break;
                case 3:
                    System.out.println("Volviendo al menú anterior.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
    * Devuelve un libro prestado por un usuario.
    *
    * @param  scanner            el objeto Scanner utilizado para obtener la entrada del usuario (no nulo)
    * @param  usuario            el usuario que desea devolver el libro (no nulo)
    * @param  librosRentados     la lista de libros rentados por el usuario (no nulo)
    * @return                    nada
    */
    private void devolverLibro(Scanner scanner, Usuario usuario, List<Libro> librosRentados) {
        System.out.println("Ingrese el número del libro a devolver: ");
        int numLibro = obtenerEnteroInput(scanner, "Número de libro: ");

        if (numLibro >= 1 && numLibro <= librosRentados.size()) {
            Libro libroDevuelto = librosRentados.get(numLibro - 1);
            biblioteca.devolverLibro(usuario, libroDevuelto);
            System.out.println("Libro devuelto con éxito.");
        } else {
            System.out.println("Número de libro inválido.");
        }
    }

    /**
    * Renueva el préstamo de un libro específico para un usuario.
    *
    * @param  usuario            el usuario que desea renovar el préstamo (no nulo)
    * @param  librosRentados     la lista de libros rentados por el usuario (no nulo)
    * @return                    nada
    */
    private void renovarPrestamo(Usuario usuario, List<Libro> librosRentados) {
        System.out.println("Ingrese el número del libro a renovar: ");
        int numLibro = obtenerEnteroInput(scanner, "Número de libro: ");

        if (numLibro >= 1 && numLibro <= librosRentados.size()) {
            Libro libroARenovar = librosRentados.get(numLibro - 1);
            
            // Aquí podrías realizar la lógica de renovación del préstamo.
            // Por ejemplo, podrías extender la fecha de devolución, cambiar el estado del préstamo, etc.
            // Aquí hay un ejemplo simple:
            
            boolean renovacionExitosa = biblioteca.renovarPrestamo(usuario, libroARenovar);
            
            if (renovacionExitosa) {
                System.out.println("Libro renovado con éxito.");
            } else {
                System.out.println("No se pudo renovar el préstamo del libro.");
            }
        } else {
            System.out.println("Número de libro inválido.");
        }
    }

    /**
     * Obtiene un número entero ingresado por el usuario utilizando el objeto de escáner proporcionado y muestra el mensaje especificado.
     *
     * @param  scanner  el objeto de escáner a utilizar para obtener la entrada del usuario
     * @param  mensaje  el mensaje que se mostrará al usuario
     * @return          el valor entero ingresado por el usuario
     */
    private int obtenerEnteroInput(Scanner scanner, String mensaje) {
        int resultado = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print(mensaje);
                resultado = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        } while (!entradaValida);
        return resultado;
    }
}
