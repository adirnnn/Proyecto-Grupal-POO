public class Usuario {
    private String nombre;
    private String correoElectronico;
    private boolean esEstudiante;

    public Usuario(String nombre, String correoElectronico, boolean esEstudiante) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.esEstudiante = esEstudiante;
    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public boolean esEstudiante() {
        return esEstudiante;
    }

    public void setEsEstudiante(boolean esEstudiante) {
        this.esEstudiante = esEstudiante;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", correoElectronico='" + correoElectronico + '\'' +
                ", esEstudiante=" + esEstudiante +
                '}';
    }
}
