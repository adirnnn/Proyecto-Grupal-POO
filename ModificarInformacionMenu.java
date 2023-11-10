import java.util.Scanner;

public class ModificarInformacionMenu {
    private Biblioteca biblioteca;

    public ModificarInformacionMenu(Biblioteca biblioteca) {
        this.biblioteca = biblioteca;
    }

    public void modificarInformacionUsuario(Scanner scanner, Usuario usuario) {
        System.out.println("Menú de Modificación de Información:");
        System.out.println("1. Modificar nombre");
        System.out.println("2. Modificar correo electrónico");
        System.out.println("3. Modificar estado de estudiante");
        System.out.println("4. Volver al menú principal");

        int opcion = scanner.nextInt();
        scanner.nextLine(); // Consumir el salto de línea después de leer la opción

        switch (opcion) {
            case 1:
                System.out.print("Ingrese el nuevo nombre: ");
                String nuevoNombre = scanner.nextLine();
                usuario.setNombre(nuevoNombre);
                System.out.println("Nombre modificado con éxito.");
                break;
            case 2:
                System.out.print("Ingrese el nuevo correo electrónico: ");
                String nuevoCorreo = scanner.nextLine();
                usuario.setCorreoElectronico(nuevoCorreo);
                System.out.println("Correo electrónico modificado con éxito.");
                break;
            case 3:
                System.out.print("¿Es estudiante ahora? (true/false): ");
                boolean nuevoEstadoEstudiante = scanner.nextBoolean();
                usuario.setEsEstudiante(nuevoEstadoEstudiante);
                System.out.println("Estado de estudiante modificado con éxito.");
                break;
            case 4:
                System.out.println("Volviendo al menú principal.");
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }
}
