public class Libro {
    private String titulo;
    private boolean esVirtual; // Indicates if the book is virtual or physical
    
    public Libro(String titulo, boolean esVirtual) {
        this.titulo = titulo;
        this.esVirtual = esVirtual;
    }
    
    public String getTitulo() {
        return titulo;
    }
    
    public boolean esVirtual() {
        return esVirtual;
    }
    
    // Other methods and properties related to books can be added here
    
    @Override
    public String toString() {
        return "Título: " + titulo + ", " + (esVirtual ? "Virtual" : "Físico");
    }
}