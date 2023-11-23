public class Libro {
    private String editorial;
    private boolean esVirtual;
    private String link;
    private boolean rentado;
    private Usuario usuarioRentado;
    private String titulo;
    private String autor;

    public Libro(String titulo, String editorial, boolean esVirtual, String link2) {
        this.titulo = titulo;
        this.editorial = editorial;
        this.esVirtual = esVirtual;
        this.link = null; // Opcional: Asignar un valor por defecto para 'link'
        this.rentado = false;
        this.usuarioRentado = null;
        this.autor = null; // Si es necesario inicializar el autor
    }

    // Getters para los atributos

    public Libro(String titulo2, String autor2, boolean esVirtual2) {
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

    public String getAutor() {
        return autor;
    }

    // Métodos para rentar, devolver y verificar si está rentado por un usuario específico

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
