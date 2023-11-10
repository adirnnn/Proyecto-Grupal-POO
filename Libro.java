public class Libro {
    private String titulo;
    private String editorial;
    private boolean esVirtual;
    private String link;

    public Libro(String titulo, String editorial, boolean esVirtual, String link) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.esVirtual = esVirtual;
        this.link = link;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getEditorial() {
        return editorial;
    }

    public boolean esVirtual() {
        return esVirtual;
    }

    public String getLink() {
        return link;
    }
}