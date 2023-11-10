public class Usuario {
    /**
     *
     */
    private String nombre;
    /**
     *
     */
    private String correoElectronico;
    /**
     *
     */
    private boolean esEstudiante;

    /**
     * @param nombre
     * @param correoElectronico
     * @param contrasena
     * @param esEstudiante
     */
    public Usuario(String nombre, String correoElectronico, String contrasena, boolean esEstudiante) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.esEstudiante = esEstudiante;
    }



    /**
     * @return
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * @param correoElectronico
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * @return
     */
    public boolean esEstudiante() {
        return esEstudiante;
    }

    /**
     * @param esEstudiante
     */
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
