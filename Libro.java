import java.util.ArrayList;
import java.util.List;

public class Libro {
    private String titulo;
    private String editorial;
    private String formato;
    private String estado;
    private boolean reservado;
    private List<String> reseñas;
    private String link;

    public Libro(String titulo, String editorial, String formato, String estado) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.formato = formato;
        this.estado = estado;
        this.reservado = false;
        this.reseñas = new ArrayList<>();
        this.link = ""; // Establecer un enlace vacío por defecto
    }

    // Getters y setters para los atributos
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public boolean estaReservado() {
        return reservado;
    }

    public void reservar() {
        reservado = true;
    }

    public void liberar() {
        reservado = false;
    }

    // Métodos para reseñas
    public void agregarReseña(String resena) {
        reseñas.add(resena);
    }

    public List<String> obtenerReseñas() {
        return reseñas;
    }

    // Métodos para enlaces de libros digitales
    public void establecerLink(String link) {
        this.link = link;
    }

    public String obtenerLink() {
        return link;
    }

    public static List<Libro> cargarLibrosDesdeCSV(String archivoCSV) {
        return null;
    }

    public void agregarResena(String resena) {
    }
}
