public class Calificacion {
    /**
     *
     */
    private Usuario usuario;
    /**
     *
     */
    private Libro libro;
    /**
     *
     */
    private int calificacion;
    /**
     *
     */
    private String comentario;

    /**
     * @param usuario
     * @param libro
     * @param calificacion
     * @param comentario
     */
    public Calificacion(Usuario usuario, Libro libro, int calificacion, String comentario) {
        this.usuario = usuario;
        this.libro = libro;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    /**
     * @return
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @return
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @return
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * @return
     */
    public String getComentario() {
        return comentario;
    }

    @Override
    public String toString() {
        return "Calificacion{" +
                "usuario=" + usuario.getNombre() +
                ", libro=" + libro.getTitulo() +
                ", calificacion=" + calificacion +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
