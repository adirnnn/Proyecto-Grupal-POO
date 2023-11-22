import java.util.Scanner;

public class ModificarInformacionMenu {

    public ModificarInformacionMenu(Biblioteca biblioteca) {
    }

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

    private void modificarNombre(Scanner scanner, Usuario usuario) {
        System.out.print("Ingrese el nuevo nombre: ");
        String nuevoNombre = scanner.nextLine();
        usuario.setNombre(nuevoNombre);
        System.out.println("Nombre modificado exitosamente a: " + usuario.getNombre());
    }

    private void modificarCorreo(Scanner scanner, Usuario usuario) {
        System.out.print("Ingrese el nuevo correo electrónico: ");
        String nuevoCorreo = scanner.nextLine();
        usuario.setCorreoElectronico(nuevoCorreo);
        System.out.println("Correo electrónico modificado exitosamente a: " + usuario.getCorreoElectronico());
    }

    private void modificarEstadoEstudiante(Scanner scanner, Usuario usuario) {
        System.out.print("¿Es estudiante? (true/false): ");
        boolean nuevoEstadoEstudiante = scanner.nextBoolean();
        usuario.setEsEstudiante(nuevoEstadoEstudiante);
        System.out.println("Estado de estudiante modificado exitosamente a: " + usuario.esEstudiante());
    }

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
}
