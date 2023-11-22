import java.util.Scanner;

/**
 * Clase que representa un menú para modificar la información de un usuario en una biblioteca.
 */
public class ModificarInformacionMenu {

    private Biblioteca biblioteca;

    /**
     * Constructor de la clase ModificarInformacionMenu.
     *
     * @param biblioteca  la instancia de la biblioteca en la que se realizarán las modificaciones
     */
    public ModificarInformacionMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    /**
     * Método para modificar la información de un usuario.
     *
     * @param scanner  el objeto Scanner utilizado para obtener la entrada del usuario
     * @param usuario  el objeto Usuario cuya información se modificará
     */
    public void modificarInformacion(Scanner scanner, Usuario usuario) {
        System.out.println("Información Actual:");
        System.out.println(usuario.toString());

        System.out.println("Seleccione qué desea modificar:");
        System.out.println("1. Nombre");
        System.out.println("2. Correo Electrónico");
        System.out.println("3. Estado de Estudiante");
        System.out.println("4. Volver al menú anterior");

        System.out.print("Ingrese el número de la opción: ");
        int opcion = obtenerEnteroInput(scanner);

        switch (opcion) {
            case 1:
                modificarNombre(scanner, usuario);
                break;
            case 2:
                modificarCorreo(scanner, usuario);
                break;
            case 3:
                modificarEstadoEstudiante(scanner, usuario);
                break;
            case 4:
                System.out.println("Volviendo al menú anterior.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /**
     * Método privado para obtener un entero ingresado por el usuario utilizando el objeto Scanner proporcionado.
     *
     * @param scanner  el objeto Scanner utilizado para obtener la entrada del usuario
     * @return         el valor entero ingresado por el usuario
     */
    private int obtenerEnteroInput(Scanner scanner) {
        int resultado = 0;
        boolean entradaValida = false;
        do {
            try {
                resultado = Integer.parseInt(scanner.nextLine());
                entradaValida = true;
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número válido.");
            }
        } while (!entradaValida);
        return resultado;
    }

    /**
     * Método privado para modificar el nombre del usuario.
     *
     * @param scanner  el objeto Scanner utilizado para obtener la entrada del usuario
     * @param usuario  el objeto Usuario cuyo nombre se modificará
     */
    private void modificarNombre(Scanner scanner, Usuario usuario) {
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        usuario.setNombre(nuevoNombre);
        System.out.println("Nombre modificado exitosamente a: " + usuario.getNombre());
        biblioteca.actualizarUsuario(usuario);
    }

    /**
     * Método privado para modificar el correo electrónico del usuario.
     *
     * @param scanner  el objeto Scanner utilizado para obtener la entrada del usuario
     * @param usuario  el objeto Usuario cuyo correo electrónico se modificará
     */
    private void modificarCorreo(Scanner scanner, Usuario usuario) {
        System.out.print("Ingrese el nuevo correo electrónico: ");
        String nuevoCorreo = scanner.nextLine();
        usuario.setCorreoElectronico(nuevoCorreo);
        System.out.println("Correo electrónico modificado exitosamente a: " + usuario.getCorreoElectronico());
        biblioteca.actualizarUsuario(usuario);
    }

    /**
    

    /**
     * Modifica el estado de estudiante del usuario.
     *
     * @param  scanner                el objeto Scanner utilizado para obtener la entrada del usuario
     * @param  usuario                el objeto Usuario cuyo estado de estudiante se modificará
     */
    private void modificarEstadoEstudiante(Scanner scanner, Usuario usuario) {
        System.out.print("¿Es estudiante? (true/false): ");
        boolean nuevoEstadoEstudiante = scanner.nextBoolean();
        usuario.setEsEstudiante(nuevoEstadoEstudiante);
        System.out.println("Estado de estudiante modificado exitosamente a: " + usuario.esEstudiante());
        biblioteca.actualizarUsuario(usuario);
    }
}
  