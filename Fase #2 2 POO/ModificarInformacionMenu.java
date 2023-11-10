import java.util.Scanner;

public class ModificarInformacionMenu {
    /**
     * @param biblioteca
     */
    public ModificarInformacionMenu(Biblioteca biblioteca) {
    }

    /**
     * @param scanner
     * @param usuario
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
        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea

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
                return;
            default:
                System.out.println("Opción no válida.");
        }
    }

    /**
     * @param scanner
     * @param usuario
     */
    private void modificarNombre(Scanner scanner, Usuario usuario) {
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        usuario.setNombre(nuevoNombre);
        System.out.println("Nombre modificado exitosamente.");
    }

    /**
     * @param scanner
     * @param usuario
     */
    private void modificarCorreo(Scanner scanner, Usuario usuario) {
        System.out.print("Ingrese el nuevo correo electrónico: ");
        String nuevoCorreo = scanner.nextLine();
        usuario.setCorreoElectronico(nuevoCorreo);
        System.out.println("Correo electrónico modificado exitosamente.");
    }

    /**
     * @param scanner
     * @param usuario
     */
    private void modificarEstadoEstudiante(Scanner scanner, Usuario usuario) {
        System.out.print("¿Es estudiante? (true/false): ");
        boolean nuevoEstadoEstudiante = scanner.nextBoolean();
        usuario.setEsEstudiante(nuevoEstadoEstudiante);
        System.out.println("Estado de estudiante modificado exitosamente.");
    }
}
