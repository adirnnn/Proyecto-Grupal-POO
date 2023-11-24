import java.util.List;

public class CatalogoLibros {
    private List<Libro> libros;

    public CatalogoLibros(String archivoCSV) {
        this.libros = Libro.cargarLibrosDesdeCSV(archivoCSV);
    }

    public void mostrarCatalogo() {
        System.out.println("Catálogo de libros:");
        for (Libro libro : libros) {
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Editorial: " + libro.getEditorial());
            System.out.println("Formato: " + libro.getFormato());
            System.out.println("Estado: " + libro.getEstado());
            System.out.println("Reservado: " + (libro.isReservado() ? "Sí" : "No"));
            System.out.println("------------------------");
        }
    }

    public boolean reservarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.isReservado()) {
                libro.reservar();
                return true; // Reserva exitosa
            }
        }
        return false; // El libro no está disponible o no existe
    }

    // Puedes agregar otros métodos según sea necesario.

    public static void main(String[] args) {
        // Ejemplo de uso
        CatalogoLibros catalogo = new CatalogoLibros("Libro.csv");
        catalogo.mostrarCatalogo();
    }
}
