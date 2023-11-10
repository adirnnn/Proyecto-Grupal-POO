public class Libro {
    /**
     *
     */
    private String titulo;
    /**
     *
     */
    private boolean esVirtual;

    /**
     * @param titulo
     * @param esVirtual
     */
    public Libro(String titulo, boolean esVirtual) {
        this.titulo = titulo;
        this.esVirtual = esVirtual;
    }

    /**
     * @return
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return
     */
    public boolean esVirtual() {
        return esVirtual;
    }

    /**
     * @param esVirtual
     */
    public void setEsVirtual(boolean esVirtual) {
        this.esVirtual = esVirtual;
    }

    @Override
    public String toString() {
        return "Título: " + titulo + ", " + (esVirtual ? "Virtual" : "Físico");
    }
}
