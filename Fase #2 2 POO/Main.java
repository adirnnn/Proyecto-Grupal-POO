import java.util.Scanner;

public class Main {
    /**
     * @param args
     */
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        Scanner scanner = new Scanner(System.in);

        // Código para cargar datos iniciales, si es necesario

        Usuario usuarioActual = null;

        while (true) {
            System.out.println("Menu Principal:");
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    usuarioActual = iniciarSesion(scanner, biblioteca);
                    if (usuarioActual != null) {
                        menuUsuario(scanner, biblioteca, usuarioActual);
                    }
                    break;
                case 2:
                    registrarUsuario(scanner, biblioteca);
                    break;
                case 3:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    /**
     * @param scanner
     * @param biblioteca
     * @return
     */
    private static Usuario iniciarSesion(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        Usuario usuario = biblioteca.iniciarSesion(correo, contrasena);

        if (usuario == null) {
            System.out.println("Inicio de sesión fallido. Verifique sus credenciales.");
        } else {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido, " + usuario.getNombre() + "!");
        }

        return usuario;
    }

    /**
     * @param scanner
     * @param biblioteca
     */
    private static void registrarUsuario(Scanner scanner, Biblioteca biblioteca) {
        System.out.println("Ingrese su nombre:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();
        System.out.println("¿Es estudiante? (true/false):");
        boolean esEstudiante = scanner.nextBoolean();
        scanner.nextLine(); // Consumir el salto de línea

        Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena, esEstudiante);
        biblioteca.agregarUsuario(nuevoUsuario);

        System.out.println("Registro exitoso. ¡Bienvenido, " + nuevoUsuario.getNombre() + "!");
    }

    /**
     * @param scanner
     * @param biblioteca
     * @param usuario
     */
    private static void menuUsuario(Scanner scanner, Biblioteca biblioteca, Usuario usuario) {
        while (true) {
            System.out.println("Menu de Usuario:");
            System.out.println("1. Buscar Libro");
            System.out.println("2. Gestionar Libros Rentados");
            System.out.println("3. Calificar Libro");
            System.out.println("4. Ver Calificaciones");
            System.out.println("5. Modificar Información Personal");
            System.out.println("6. Eliminar Cuenta");
            System.out.println("7. Cerrar Sesión");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    BuscarLibroMenu buscarLibroMenu = new BuscarLibroMenu(biblioteca);
                    buscarLibroMenu.buscarLibro(scanner);
                    break;
                case 2:
                    GestionarLibrosRentadosMenu gestionarLibrosRentadosMenu = new GestionarLibrosRentadosMenu(biblioteca);
                    gestionarLibrosRentadosMenu.gestionarLibrosRentados(scanner, usuario);
                    break;
                case 3:
                    CalificarLibroMenu calificarLibroMenu = new CalificarLibroMenu(biblioteca);
                    calificarLibroMenu.calificarLibro(scanner, usuario);
                    break;
                case 4:
                    VerCalificacionesMenu verCalificacionesMenu = new VerCalificacionesMenu(biblioteca);
                    verCalificacionesMenu.verCalificaciones(scanner, usuario);
                    break;
                case 5:
                    ModificarInformacionMenu modificarInformacionMenu = new ModificarInformacionMenu(biblioteca);
                    modificarInformacionMenu.modificarInformacion(scanner, usuario);
                    break;
                case 6:
                    EliminarCuentaMenu eliminarCuentaMenu = new EliminarCuentaMenu(biblioteca);
                    eliminarCuentaMenu.eliminarCuenta(scanner, usuario);
                    usuario = null; // Cerrar sesión después de eliminar la cuenta
                    break;
                case 7:
                    System.out.println("Cerrando sesión. ¡Hasta luego, " + usuario.getNombre() + "!");
                    return;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
