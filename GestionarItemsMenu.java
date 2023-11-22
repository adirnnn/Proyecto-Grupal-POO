import java.util.List;
import java.util.Scanner;

/**
 * La clase GestionarItemsMenu se encarga de gestionar los ítems de un menú en una biblioteca.
 */
public class GestionarItemsMenu {
    private Biblioteca biblioteca;

    /**
     * Construye una instancia de GestionarItemsMenu con la biblioteca especificada.
     *
     * @param biblioteca La biblioteca a gestionar.
     */
    public GestionarItemsMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * Muestra los ítems disponibles en la biblioteca por pantalla.
     * Si no hay ítems disponibles, muestra un mensaje indicando que no hay ítems en ese momento.
     */
    public void verItemsDisponibles() {
        List<Item> itemsDisponibles = biblioteca.obtenerItemsDisponibles();

        if (itemsDisponibles.isEmpty()) {
            System.out.println("No hay ítems disponibles en este momento.");
        } else {
            System.out.println("Ítems Disponibles:");
            int index = 1;
            for (Item item : itemsDisponibles) {
                System.out.println(index++ + ". " + item.getNombre());
            }
        }
    }

    /**
     * Agrega un nuevo ítem a la biblioteca.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public void agregarNuevoItem(Scanner scanner) {
        System.out.print("Ingrese el nombre del nuevo ítem: ");
        String nombreItem = scanner.nextLine().trim();

        if (!nombreItem.isEmpty()) {
            Item nuevoItem = new Item(nombreItem);
            biblioteca.agregarItem(nuevoItem);
            System.out.println("Ítem agregado con éxito.");
        } else {
            System.out.println("El nombre del ítem no puede estar vacío.");
        }
    }
}