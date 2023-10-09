import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Libro> biblioteca = new ArrayList<>();
        ArrayList<Item> itemsDisponibles = new ArrayList<>();

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Gestionar");
            System.out.println("2. Estudiante");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (opcion) {
                case 1:
                    System.out.println("Submenu Gestionar:");
                    System.out.println("1. Llenar lista de libros");
                    System.out.println("2. Agregar items disponibles");
                    int submenuGestionar = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (submenuGestionar == 1) {
                        System.out.print("Ingrese el título del libro: ");
                        String titulo = scanner.nextLine();
                        System.out.print("¿Es libro virtual? (true/false): ");
                        boolean esVirtual = scanner.nextBoolean();
                        Libro libro = new Libro(titulo, esVirtual);
                        biblioteca.add(libro);
                        System.out.println("Libro agregado a la biblioteca.");
                    } else if (submenuGestionar == 2) {
                        System.out.print("Ingrese el nombre del item disponible: ");
                        String nombreItem = scanner.nextLine();
                        Item item = new Item(nombreItem);
                        itemsDisponibles.add(item);
                        System.out.println("Item agregado a los disponibles.");
                    }
                    break;
                case 2:
                    System.out.println("Submenu Estudiante:");
                    System.out.println("1. Buscar libros y rentar");
                    int submenuEstudiante = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline character

                    if (submenuEstudiante == 1) {
                        System.out.println("Libros disponibles en la biblioteca:");
                        for (int i = 0; i < biblioteca.size(); i++) {
                            System.out.println((i + 1) + ". " + biblioteca.get(i));
                        }
                        System.out.print("Seleccione el número del libro que desea rentar: ");
                        int seleccion = scanner.nextInt();
                        scanner.nextLine(); // Consume the newline character

                        if (seleccion >= 1 && seleccion <= biblioteca.size()) {
                            Libro libroSeleccionado = biblioteca.get(seleccion - 1);
                            String tipoLibro = libroSeleccionado.esVirtual() ? "virtual" : "físico";
                            System.out.println("Ha rentado el libro: " + libroSeleccionado.getTitulo() + " (" + tipoLibro + ")");
                        } else {
                            System.out.println("Selección no válida.");
                        }
                    }
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