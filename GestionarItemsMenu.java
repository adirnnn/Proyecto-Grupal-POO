import java.util.List;
import java.util.Scanner;

public class GestionarItemsMenu {
    private Biblioteca biblioteca;

    public GestionarItemsMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void verItemsDisponibles() {
        List<Item> itemsDisponibles = biblioteca.obtenerItemsDisponibles();

        if (itemsDisponibles.isEmpty()) {
            System.out.println("No hay ítems disponibles en este momento.");
        } else {
            System.out.println("Ítems Disponibles:");
            for (int i = 0; i < itemsDisponibles.size(); i++) {
                System.out.println((i + 1) + ". " + itemsDisponibles.get(i).getNombre());
            }
        }
    }

    public void agregarNuevoItem(Scanner scanner) {
        System.out.print("Ingrese el nombre del nuevo ítem: ");
        String nombreItem = scanner.nextLine();
        Item nuevoItem = new Item(nombreItem);

        biblioteca.agregarItem(nuevoItem);
        System.out.println("Ítem agregado con éxito.");
    }
}
