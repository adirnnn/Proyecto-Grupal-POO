import java.util.Scanner;

public class CalificarLibroMenu {
    /**
     *
     */
    private Biblioteca biblioteca;

    /**
     * @param biblioteca
     */
    public CalificarLibroMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * @param scanner
     * @param usuario
     */
    public void calificarLibro(Scanner scanner, Usuario usuario) {
        System.out.println("Ingrese el título del libro que desea calificar:");
        String tituloLibro = scanner.nextLine();

        Libro libroACalificar = biblioteca.buscarLibroPorTitulo(tituloLibro);

        if (libroACalificar != null) {
            System.out.println("Ingrese la calificación (1-5):");
            int calificacion = scanner.nextInt();
            scanner.nextLine();

            if (calificacion >= 1 && calificacion <= 5) {
                System.out.println("Ingrese una reseña (opcional):");
                String resena = scanner.nextLine();

                Calificacion nuevaCalificacion = new Calificacion(usuario, libroACalificar, calificacion, resena);
                biblioteca.agregarCalificacion(nuevaCalificacion);

                System.out.println("Calificación agregada exitosamente.");
            } else {
                System.out.println("La calificación debe estar en el rango de 1 a 5.");
            }
        } else {
            System.out.println("No se encontró un libro con el título especificado.");
        }
    }
}