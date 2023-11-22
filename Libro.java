public class Libro {
    private String titulo;
    private String editorial;
    private boolean esVirtual;
    private String link;
    private boolean rentado;
    private Usuario usuarioRentado;

    public Libro(String titulo, String editorial, boolean esVirtual, String link) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.esVirtual = esVirtual;
        this.link = link;
        this.rentado = false;
        this.usuarioRentado = null;
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

    public boolean estaRentado() {
        return rentado;
    }

    public Usuario getUsuarioRentado() {
        return usuarioRentado;
    }

    public void rentar(Usuario usuario) {
        if (!rentado) {
            rentado = true;
            usuarioRentado = usuario;
        }
    }

    public void devolver() {
        rentado = false;
        usuarioRentado = null;
    }

    public boolean estaRentadoPor(Usuario usuario) {
        return rentado && usuarioRentado.equals(usuario);
    }
}