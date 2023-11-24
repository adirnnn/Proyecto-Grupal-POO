import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String titulo;
    private String editorial;
    private String formato;
    private String estado;
    private boolean reservado;

    public Libro(String titulo, String editorial, String formato, String estado) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.formato = formato;
        this.estado = estado;
        this.reservado = false;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public String getFormato() {
        return formato;
    }

    public String getEstado() {
        return estado;
    }

    public boolean isReservado() {
        return reservado;
    }

    public void reservar() {
        reservado = true;
    }

    public void liberar() {
        reservado = false;
    }

    // Método estático para cargar libros desde un archivo CSV
    public static List<Libro> cargarLibrosDesdeCSV(String archivoCSV) {
        List<Libro> libros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(",");
                if (partes.length == 4) {
                    String titulo = partes[0].trim();
                    String editorial = partes[1].trim();
                    String formato = partes[2].trim();
                    String estado = partes[3].trim();

                    libros.add(new Libro(titulo, editorial, formato, estado));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return libros;
    }
}
