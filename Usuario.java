/**
 * Clase que representa un usuario.
 */
public class Usuario {

    /**
     * Nombre del usuario.
     */
    private String nombre;

    /**
     * Correo electrónico del usuario.
     */
    private String correoElectronico;

    /**
     * Contraseña del usuario.
     */
    private String contrasena;

    /**
     * Crea una nueva instancia de Usuario con el nombre, correo electrónico y contraseña especificados.
     *
     * @param nombre            el nombre del usuario
     * @param correoElectronico el correo electrónico del usuario
     * @param contrasena        la contraseña del usuario
     */
    public Usuario(String nombre, String correoElectronico, String contrasena) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
        this.contrasena = contrasena;
    }

    /**
     * Obtiene el nombre del usuario.
     *
     * @return el nombre del usuario
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el valor del nombre del usuario.
     *
     * @param nombre el nuevo valor del nombre del usuario
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el correo electrónico del usuario.
     *
     * @return el correo electrónico del usuario
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el valor del campo `correoElectronico`.
     *
     * @param correoElectronico el nuevo valor del campo `correoElectronico`
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Obtiene el valor del campo `contrasena`.
     *
     * @return el valor del campo `contrasena`
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Establece el valor del campo `contrasena`.
     *
     * @param contrasena el nuevo valor del campo `contrasena`
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * Establece el estado de estudiante del usuario.
     *
     * @param nuevoEstadoEstudiante el nuevo estado de estudiante del usuario
     */
    public void setEsEstudiante(boolean nuevoEstadoEstudiante) {
        // Lógica para establecer el estado de estudiante
    }

    /**
     * Verifica si el usuario es estudiante.
     *
     * @return true si el usuario es estudiante, false de lo contrario
     */
    public String esEstudiante() {
        return null;
    }

    /**
     * Verifica si el usuario es administrador.
     *
     * @return true si el usuario es administrador, false de lo contrario
     */
    public boolean esAdministrador() {
        return false;
    }
}