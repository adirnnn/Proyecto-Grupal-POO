public class Calificacion {
    private Usuario usuario;
    private Libro libro;
    private int calificacion;
    private String comentario;

    public Calificacion(Usuario usuario, Libro libro, int calificacion, String comentario) {
        if (usuario == null || libro == null) {
            throw new IllegalArgumentException("Usuario y libro no pueden ser nulos.");
        }
        
        this.usuario = usuario;
        this.libro = libro;
        this.calificacion = calificacion;
        this.comentario = comentario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public int getCalificacion() {
        return calificacion;
    }

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
