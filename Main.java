import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();

        // Crear algunos libros, items y usuarios para propósitos de demostración
        Libro libro1 = new Libro("Libro 1", true);
        Libro libro2 = new Libro("Libro 2", false);
        Item item1 = new Item("Item 1");
        Usuario usuario1 = new Usuario("Usuario 1", "usuario1@example.com", true);

        biblioteca.agregarLibro(libro1);
        biblioteca.agregarLibro(libro2);
        biblioteca.agregarItem(item1);
        biblioteca.agregarUsuario(usuario1);

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("Menú Principal:");
                System.out.println("1. Gestionar");
                System.out.println("2. Estudiante");
                System.out.println("3. Salir");

                int opcion = scanner.nextInt();
                scanner.nextLine(); // Consume el salto de línea

                switch (opcion) {
                    case 1:
                        gestionarMenu(scanner, biblioteca);
                        break;
                    case 2:
                        estudianteMenu(scanner, biblioteca, usuario1);
                        break;
                    case 3:
                        System.out.println("Saliendo del programa.");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Opción no válida.");
                }
            }
        }
    }

    private static void gestionarMenu(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("Submenú Gestionar:");
        System.out.println("1. Ver ítems disponibles");
        System.out.println("2. Agregar libro");
        System.out.println("3. Agregar ítem");
        int gestionarOpcion = scanner.nextInt();
        scanner.nextLine(); // Consume el salto de línea

        switch (gestionarOpcion) {
            case 1:
                List<Item> itemsDisponibles = biblioteca.obtenerItemsDisponibles();
                System.out.println("Ítems Disponibles:");
                for (int i = 0; i < itemsDisponibles.size(); i++) {
                    System.out.println((i + 1) + ". " + itemsDisponibles.get(i).getNombre());
                }
                break;
            case 2:
                System.out.print("Ingrese el título del nuevo libro: ");
                String tituloLibro = scanner.nextLine();
                System.out.print("¿Es libro virtual? (true/false): ");
                boolean esVirtual = scanner.nextBoolean();
                Libro nuevoLibro = new Libro(tituloLibro, esVirtual);
                biblioteca.agregarLibro(nuevoLibro);
                System.out.println("Libro agregado con éxito.");
                break;
            case 3:
                System.out.print("Ingrese el nombre del nuevo ítem: ");
                String nombreItem = scanner.nextLine();
                Item nuevoItem = new Item(nombreItem);
                biblioteca.agregarItem(nuevoItem);
                System.out.println("Ítem agregado con éxito.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    private static void estudianteMenu(Scanner scanner, Biblioteca biblioteca, Usuario usuario) {
        System.out.println("Submenú Estudiante:");
        System.out.println("1. Ver libros rentados");
        System.out.println("2. Devolver libro");
        System.out.println("3. Buscar libro por título");
        System.out.println("4. Calificar libro");
        System.out.println("5. Ver calificaciones y reseñas dadas");
        int estudianteOpcion = scanner.nextInt();
        scanner.nextLine(); // Consume el salto de línea

        switch (estudianteOpcion) {
            case 1:
                List<Libro> librosRentados = biblioteca.obtenerLibrosRentados(usuario);
                System.out.println("Libros Rentados:");
                for (int i = 0; i < librosRentados.size(); i++) {
                    System.out.println((i + 1) + ". " + librosRentados.get(i).getTitulo());
                }
                break;
            case 2:
                List<Libro> librosRentadosEstudiante = biblioteca.obtenerLibrosRentados(usuario);
                if (librosRentadosEstudiante.isEmpty()) {
                    System.out.println("No tiene libros rentados en este momento.");
                } else {
                    System.out.println("Libros Rentados:");
                    for (int i = 0; i < librosRentadosEstudiante.size(); i++) {
                        System.out.println((i + 1) + ". " + librosRentadosEstudiante.get(i).getTitulo());
                    }

                    System.out.print("\nSeleccione el número del libro que desea devolver (o 0 para salir): ");
                    int seleccion = scanner.nextInt();
                    scanner.nextLine(); // Consumir el salto de línea

                    if (seleccion >= 1 && seleccion <= librosRentadosEstudiante.size()) {
                        Libro libroSeleccionado = librosRentadosEstudiante.get(seleccion - 1);
                        biblioteca.devolverLibro(usuario, libroSeleccionado);
                        System.out.println("Libro devuelto con éxito.");
                    } else if (seleccion == 0) {
                        System.out.println("Operación cancelada. Permanece con los libros rentados.");
                    } else {
                        System.out.println("Selección no válida.");
                    }
                }
                break;
            case 3:
                // Lógica para buscar libro por título
                biblioteca.buscarLibroPorTitulo(scanner);
                break;
            case 4:
                // Lógica para calificar libro
                CalificarLibroMenu calificarLibroMenu = new CalificarLibroMenu(biblioteca);
                calificarLibroMenu.calificarLibro(scanner, usuario);
                break;
            case 5:
                // Lógica para ver calificaciones y reseñas dadas
                VerCalificacionesMenu verCalificacionesMenu = new VerCalificacionesMenu(biblioteca);
                verCalificacionesMenu.verCalificaciones(usuario);
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
