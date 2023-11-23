public class Estudiante {
    private String nombre;
    private String correoElectronico;

    public Estudiante(String nombre, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public Object getContrasena() {
        return null;
    }
}
