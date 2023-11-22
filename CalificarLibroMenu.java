import java.util.Scanner;

/**
 * Clase CalificarLibroMenu.
 * 
 * Esta clase representa el menú de calificación de libros.
 */
public class CalificarLibroMenu {
    private Biblioteca biblioteca;

    /**
     * Constructor de la clase CalificarLibroMenu.
     * 
     * @param biblioteca La biblioteca a la que pertenece el menú.
     */
    public CalificarLibroMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * Método para calificar un libro.
     * 
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @param usuario El usuario que realiza la calificación.
     */
    public void calificarLibro(Scanner scanner, Usuario usuario) {
        System.out.println("Ingrese el título del libro que desea calificar:");
        String tituloLibro = scanner.nextLine();

        Libro libroACalificar = biblioteca.buscarLibroPorTitulo(tituloLibro);

        if (libroACalificar != null) {
            int calificacion = obtenerCalificacionValida(scanner);

            if (calificacion != -1) {
                System.out.println("Ingrese una reseña (opcional):");
                String resena = scanner.nextLine();

                Calificacion nuevaCalificacion = new Calificacion(usuario, libroACalificar, calificacion, resena);
                biblioteca.agregarCalificacion(nuevaCalificacion);

                System.out.println("Calificación agregada exitosamente.");
            } else {
                System.out.println("La calificación debe ser un número del 1 al 5.");
            }
        } else {
            System.out.println("El libro ingresado no se encuentra en nuestra biblioteca.");
        }
    }

    /**
     * Método privado para obtener una calificación válida.
     * 
     * @param scanner El objeto Scanner para leer la entrada del usuario.
     * @return La calificación válida ingresada por el usuario.
     */
    private int obtenerCalificacionValida(Scanner scanner) {
        int calificacion = -1;
        boolean calificacionValida = false;

        do {
            System.out.println("Ingrese la calificación (1-5):");
            try {
                calificacion = Integer.parseInt(scanner.nextLine());

                if (calificacion >= 1 && calificacion <= 5) {
                    calificacionValida = true;
                } else {
                    System.out.println("Por favor, ingrese una calificación entre 1 y 5.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un número válido.");
            }
        } while (!calificacionValida);

        return calificacion;
    }
}