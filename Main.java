import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Crear la biblioteca
        Biblioteca biblioteca = new Biblioteca();

        // Leer libros desde el archivo CSV usando la clase CSVReader
        List<Libro> librosDesdeCSV = CSVReader.leerLibrosDesdeCSV("libros.csv");
        biblioteca.agregarLibros(librosDesdeCSV);

        // Menú inicial
        int opcion;
        do {
            System.out.println("Menú Inicial:");
            System.out.println("1. Ingresar como estudiante existente");
            System.out.println("2. Crear un nuevo estudiante");
            System.out.println("3. Salir");

            opcion = biblioteca.obtenerEnteroInput("Ingrese su elección: ");

            switch (opcion) {
                case 1:
                    // Simular el ingreso de un estudiante existente
                    Estudiante estudianteExistente = new Estudiante("EstudianteExistente", "existente@example.com");
                    biblioteca.mostrarMenuEstudiante(estudianteExistente);
                    break;
                case 2:
                    // Crear un nuevo estudiante
                    Estudiante nuevoEstudiante = biblioteca.crearNuevoEstudiante();
                    biblioteca.agregarEstudiante(nuevoEstudiante);
                    biblioteca.mostrarMenuEstudiante(nuevoEstudiante);
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 3);
    }
}
