import java.util.List;

public class CatalogoLibros {
    private static List<Libro> libros;

    public CatalogoLibros(String archivoCSV) {
        CatalogoLibros.libros = Libro.cargarLibrosDesdeCSV(archivoCSV);
    }

    public void mostrarCatalogo() {
        System.out.println("Catálogo de libros:");
        for (Libro libro : libros) {
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Editorial: " + libro.getEditorial());
            System.out.println("Formato: " + libro.getFormato());
            System.out.println("Estado: " + libro.getEstado());
            System.out.println("Reservado: " + (libro.estaReservado() ? "Sí" : "No"));
            System.out.println("------------------------");
        }
    }

    public void mostrarLibrosPorFormato(String formato) {
        System.out.println("Libros en formato '" + formato + "':");
        boolean encontrados = false;
        for (Libro libro : libros) {
            if (libro.getFormato().equalsIgnoreCase(formato)) {
                encontrados = true;
                System.out.println("- " + libro.getTitulo());
            }
        }
        if (!encontrados) {
            System.out.println("No se encontraron libros en formato '" + formato + "'.");
        }
    }

    public void mostrarLibrosPorEditorial(String editorial) {
        System.out.println("Libros de la editorial '" + editorial + "':");
        boolean encontrados = false;
        for (Libro libro : libros) {
            if (libro.getEditorial().equalsIgnoreCase(editorial)) {
                encontrados = true;
                System.out.println("- " + libro.getTitulo());
            }
        }
        if (!encontrados) {
            System.out.println("No se encontraron libros de la editorial '" + editorial + "'.");
        }
    }

    public static boolean reservarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && !libro.estaReservado()) {
                libro.reservar();
                return true; // Reserva exitosa
            }
        }
        return false; // El libro no está disponible o no existe
    }

    public boolean liberarLibro(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.estaReservado()) {
                libro.liberar();
                return true; // Liberación exitosa
            }
        }
        return false; // El libro no está reservado o no existe
    }

    public void agregarResena(String titulo, String resena) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                libro.agregarResena(resena);
                return;
            }
        }
        System.out.println("El libro no existe en el catálogo.");
    }

    public void verificarReserva(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo) && libro.estaReservado()) {
                String link = libro.obtenerLink();
                if (!link.isEmpty()) {
                    System.out.println("El libro está reservado. Enlace: " + link);
                } else {
                    System.out.println("El libro está reservado pero no es digital.");
                }
                return;
            }
        }
        System.out.println("El libro no está reservado o no existe.");
    }

    public static void main(String[] args) {
        CatalogoLibros catalogo = new CatalogoLibros("Libros.csv");
        catalogo.mostrarCatalogo();
        // Puedes llamar a otras funciones aquí para probar la funcionalidad
    }
}
