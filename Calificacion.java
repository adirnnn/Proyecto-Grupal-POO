/**
 * Clase Calificacion.
 * 
 * Esta clase representa una calificación de un libro realizada por un usuario.
 */
public class Calificacion {
    private Usuario usuario;
    private Libro libro;
    private int calificacion;
    private String comentario;

    /**
     * Constructor de la clase Calificacion.
     * 
     * @param usuario      El usuario que realiza la calificación.
     * @param libro        El libro que se califica.
     * @param calificacion La calificación del libro.
     * @param comentario   El comentario asociado a la calificación.
     * @throws IllegalArgumentException Si el usuario o el libro son nulos.
     */
    public Calificacion(Usuario usuario, Libro libro, int calificacion, String comentario) {
        if (usuario == null || libro == null) {
            throw new IllegalArgumentException("Usuario y libro no pueden ser nulos.");
        }

        this.usuario = usuario;
        this.libro = libro;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    /**
     * Método para obtener el usuario que realizó la calificación.
     * 
     * @return El usuario que realizó la calificación.
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * Método para obtener el libro que se calificó.
     * 
     * @return El libro que se calificó.
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * Método para obtener la calificación del libro.
     * 
     * @return La calificación del libro.
     */
    public int getCalificacion() {
        return calificacion;
    }

    /**
     * Método para obtener el comentario asociado a la calificación.
     * 
     * @return El comentario asociado a la calificación.
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Método toString para representar la calificación como una cadena de texto.
     * 
     * @return La representación de la calificación como una cadena de texto.
     */
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