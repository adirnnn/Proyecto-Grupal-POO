public class Usuario {
    private String nombre;
    private String correoElectronico;
    private boolean esEstudiante;

    public Usuario(String nombre, String correoElectronico, boolean esEstudiante) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.esEstudiante = esEstudiante;
    }

    // Getters y setters (métodos para acceder y modificar los atributos)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    // Otros getters y setters para los demás atributos

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", esEstudiante=" + esEstudiante +
                '}';
    }
}