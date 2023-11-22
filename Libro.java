/**
 * Clase que representa un libro.
 *
 * Contiene información sobre la editorial, si es virtual o no, el enlace, si está rentado o no,
 * el usuario que lo ha rentado, el título y el autor.
 */
public class Libro {
    private String editorial;
    private boolean esVirtual;
    private String link;
    private boolean rentado;
    private Usuario usuarioRentado;
    private String titulo;
    private String autor;

    /**
     * Constructor de la clase Libro.
     *
     * @param titulo      el título del libro
     * @param editorial   la editorial del libro
     * @param esVirtual   indica si el libro es virtual o no
     * @param link2       el enlace del libro (opcional)
     */
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

    /**
     * Obtiene el título del libro.
     *
     * @return el título del libro
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Obtiene la editorial del libro.
     *
     * @return la editorial del libro
     */
    public String getEditorial() {
        return editorial;
    }

    /**
     * Indica si el libro es virtual o no.
     *
     * @return true si el libro es virtual, false si no lo es
     */
    public boolean esVirtual() {
        return esVirtual;
    }

    /**
     * Obtiene el enlace del libro.
     *
     * @return el enlace del libro
     */
    public String getLink() {
        return link;
    }

    /**
     * Indica si el libro está rentado.
     *
     * @return true si el libro está rentado, false si no lo está
     */
    public boolean estaRentado() {
        return rentado;
    }

    /**
     * Obtiene el usuario que ha rentado el libro.
     *
     * @return el usuario que ha rentado el libro
     */
    public Usuario getUsuarioRentado() {
        return usuarioRentado;
    }

    /**
     * Obtiene el autor del libro.
     *
     * @return el autor del libro
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Rentar el libro a un usuario.
     *
     * @param usuario el usuario al que se le rentará el libro
     */
    public void rentar(Usuario usuario) {
        if (!rentado) {
            rentado = true;
            usuarioRentado = usuario;
        }
    }

    /**
     * Devolver el libro.
     */
    public void devolver() {
        rentado = false;
        usuarioRentado = null;
    }

    /**
     * Verifica si el libro está rentado por un usuario específico.
     *
     * @param usuario el usuario a verificar
     * @return true si el libro está rentado por el usuario especificado, false si no lo está
     */
    public boolean estaRentadoPor(Usuario usuario) {
        return rentado && usuarioRentado.equals(usuario);
    }
}