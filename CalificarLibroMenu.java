import java.util.Scanner;

public class CalificarLibroMenu {
    private Biblioteca biblioteca;

    public CalificarLibroMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void calificarLibro(Scanner scanner, Usuario usuario) {
        System.out.print("Ingrese el título del libro que desea calificar: ");
        String tituloLibro = scanner.nextLine();

        Libro libro = biblioteca.buscarLibroPorTitulo(tituloLibro);

        if (libro != null) {
            System.out.print("Ingrese la calificación (1-5): ");
            int calificacion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea después de leer la calificación

            if (calificacion >= 1 && calificacion <= 5) {
                System.out.print("Ingrese una reseña (opcional): ");
                String resena = scanner.nextLine();

                // Agregar la calificación y la reseña al libro
                libro.agregarCalificacion(usuario, calificacion, resena);

                System.out.println("Calificación y reseña agregadas con éxito.");
            } else {
                System.out.println("La calificación debe estar en el rango de 1 a 5.");
            }
        } else {
            System.out.println("Libro no encontrado.");
        }
    }
}
