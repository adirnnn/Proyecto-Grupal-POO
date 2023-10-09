import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Item> items;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.items = new ArrayList<>();
    }

    // Métodos para agregar libros, items y otras operaciones

    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }

    public void agregarItem(Item item) {
        items.add(item);
    }

    // Otros métodos según las necesidades de tu proyecto

    @Override
    public String toString() {
        return "Biblioteca{" +
                "libros=" + libros +
                ", items=" + items +
                '}';
    }
}