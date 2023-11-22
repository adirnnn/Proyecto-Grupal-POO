import java.util.Scanner;

public class Main {
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenuInicial();
    }

    private static void mostrarMenuInicial() {
        int opcion;
        do {
            System.out.println("Bienvenido a la Biblioteca:");
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Registrarse como nuevo usuario");
            System.out.println("3. Salir");
            System.out.print("Ingrese su elección: ");
            opcion = obtenerEnteroInput();

            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    registrarNuevoUsuario();
                    break;
                case 3:
                    System.out.println("Gracias por visitar la Biblioteca. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 3);
    }

    private static void iniciarSesion() {
        System.out.println("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();

        Usuario usuario = biblioteca.iniciarSesion(correo, contrasena);
        if (usuario != null) {
            mostrarMenuUsuario(usuario);
        } else {
            System.out.println("Correo electrónico o contraseña incorrectos. ¿Desea intentar nuevamente? (Sí/No)");
            String respuesta = scanner.nextLine();
            if (respuesta.equalsIgnoreCase("No")) {
                System.out.println("Volviendo al menú inicial.");
            }
        }
    }

    private static void registrarNuevoUsuario() {
        System.out.println("Ingrese su nombre: ");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese su correo electrónico: ");
        String correo = scanner.nextLine();
        System.out.println("Ingrese su contraseña: ");
        String contrasena = scanner.nextLine();


        Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);
        biblioteca.registrarUsuario(nuevoUsuario);

        System.out.println("Registro exitoso. ¡Bienvenido a la Biblioteca!");
        mostrarMenuUsuario(nuevoUsuario);
    }

    private static void mostrarMenuUsuario(Usuario usuario) {
        System.out.println("¡Bienvenido, " + usuario.getNombre() + "!");
    }

    private static int obtenerEnteroInput() {
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
