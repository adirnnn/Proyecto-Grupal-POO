public class Item {
    /**
     *
     */
    private String nombre;

    /**
     * @param nombre
     */
    public Item(String nombre) {
        this.nombre = nombre;
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
     * Devuelve una representación en cadena del objeto Item.
     *
     * @return          una representación en cadena del objeto Item
     */
    @Override
    public String toString() {
        return "Item{" +
                "nombre='" + nombre + '\'' +
                '}';
    }
}