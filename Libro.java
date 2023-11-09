public class Libro {
    private String titulo;
    private boolean esVirtual;

    public Libro(String titulo, boolean esVirtual) {
        this.titulo = titulo;
        this.esVirtual = esVirtual;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean esVirtual() {
        return esVirtual;
    }

    public void setEsVirtual(boolean esVirtual) {
        this.esVirtual = esVirtual;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", " + (esVirtual ? "Virtual" : "Físico");
    }
}
