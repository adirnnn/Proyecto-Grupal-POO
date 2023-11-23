public class Usuario {
    private String nombre;
    private String correoElectronico;
    private String contrasena; 

    public Usuario(String nombre, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
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

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public void setEsEstudiante(boolean nuevoEstadoEstudiante) {
    }

    public String esEstudiante() {
        return null;
    }

    public Object getCorreo() {
        return null;
    }

    public boolean esAdministrador() {
        return false;
    }
}
