public class Calificacion {
    private Usuario usuario;
    private Libro libro;
    private int calificacion;
    private String resena;

    public Calificacion(Usuario usuario, Libro libro, int calificacion, String resena) {
        this.usuario = usuario;
        this.libro = libro;
        this.calificacion = calificacion;
        this.resena = resena;
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

    public String getResena() {
        return resena;
    }
}
