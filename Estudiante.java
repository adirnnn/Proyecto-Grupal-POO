/**
 * Esta clase representa a un estudiante.
 */
public class Estudiante {
    private String nombre;
    private String correoElectronico;

    /**
     * Crea un nuevo estudiante con el nombre y correo electrónico especificados.
     *
     * @param nombre            el nombre del estudiante
     * @param correoElectronico el correo electrónico del estudiante
     */
    public Estudiante(String nombre, String correoElectronico) {
        this.nombre = nombre;
        this.correoElectronico = correoElectronico;
    }

    /**
     * Retorna el nombre del estudiante.
     *
     * @return el nombre del estudiante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Retorna el correo electrónico del estudiante.
     *
     * @return el correo electrónico del estudiante
     */
    public String getCorreoElectronico() {
        return correoElectronico;
    }

    /**
     * Establece el nombre del estudiante.
     *
     * @param nombre el nuevo nombre del estudiante
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Establece el correo electrónico del estudiante.
     *
     * @param correoElectronico el nuevo correo electrónico del estudiante
     */
    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    /**
     * Retorna la contraseña del estudiante.
     *
     * @return la contraseña del estudiante
     */
    public Object getContrasena() {
        return null;
    }
}