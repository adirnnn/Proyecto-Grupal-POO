import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Clase principal que contiene el programa de la biblioteca.
 */
public class Main {
    public static List<Usuario> listaDeUsuarios = new ArrayList<>();

    /**
     * Método principal que inicia el programa de la biblioteca.
     * @param args los argumentos de la línea de comandos
     */
    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(new Scanner(System.in));
        biblioteca.mostrarMenu();
    }

    /**
     * Clase interna que representa la biblioteca.
     */
    static class Biblioteca {
        private Scanner scanner;

        /**
         * Constructor de la clase Biblioteca.
         * @param scanner el scanner utilizado para leer la entrada del usuario
         */
        public Biblioteca(Scanner scanner) {
            this.scanner = scanner;
        }

        /**
         * Muestra el menú del sistema de la biblioteca.
         *
         * @return No tiene valor de retorno
         */
        public void mostrarMenu() {
            int opcion;
            do {
                System.out.println("Bienvenido a la Biblioteca:");
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Registrarse como nuevo usuario");
                System.out.println("3. Salir");
                System.out.print("Ingrese su elección: ");
                opcion = obtenerEnteroInput();

                switch (opcion) {
                    case 1 -> iniciarSesion();
                    case 2 -> crearNuevoUsuario();
                    case 3 -> System.out.println("Gracias por visitar la Biblioteca. ¡Hasta luego!");
                    default -> System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } while (opcion != 3);
        }


        /**
         * Método privado que maneja el inicio de sesión del usuario.
         */
        private void iniciarSesion() {
            System.out.println("Ingrese su correo electrónico:");
            String correo = scanner.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contrasena = scanner.nextLine();

            Usuario usuario = buscarUsuario(correo, contrasena);

            if (usuario != null) {
                System.out.println("¡Bienvenido, " + usuario.getNombre() + "!");
            } else {
                System.out.println("Correo electrónico o contraseña incorrectos.");
            }
        }

        /**
         * Método privado que crea un nuevo usuario.
         */
        private void crearNuevoUsuario() {
            System.out.println("Ingrese su nombre:");
            String nombre = scanner.nextLine();
            System.out.println("Ingrese su correo electrónico:");
            String correo = scanner.nextLine();

            // Validación para verificar si el correo ya está registrado
            if (usuarioExistente(correo)) {
                System.out.println("Este correo ya está registrado. Inicie sesión o utilice otro correo.");
                return;
            }

            System.out.println("Ingrese su contraseña:");
            String contrasena = scanner.nextLine();

            Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);
            listaDeUsuarios.add(nuevoUsuario);
            System.out.println("¡Usuario creado con éxito!");
        }

        /**
         * Método privado que verifica si un usuario ya existe en la lista de usuarios.
         * @param correo el correo del usuario a verificar
         * @return true si el usuario ya existe, false de lo contrario
         */
        private boolean usuarioExistente(String correo) {
            for (Usuario usuario : listaDeUsuarios) {
                if (usuario.getCorreo().equals(correo)) {
                    return true; // El usuario ya está registrado
                }
            }
            return false; // El usuario no está registrado
        }

        /**
         * Busca un usuario en la lista de usuarios de la biblioteca utilizando el correo y la contraseña proporcionados.
         * 
         * @param correo el correo del usuario a buscar
         * @param contrasena la contraseña del usuario a buscar
         * @return el usuario encontrado, o null si no se encontró ningún usuario con el correo y contraseña proporcionados
         */
        private Usuario buscarUsuario(String correo, String contrasena) {
            for (Usuario usuario : listaDeUsuarios) {
                if (usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)) {
                    return usuario; // Usuario encontrado
                }
            }
            return null; // Usuario no encontrado
        }

        /**
         * Obtiene un entero del usuario como entrada.
         * 
         * @return el entero ingresado por el usuario
         */
        private int obtenerEnteroInput() {
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

    static class Usuario {
        private String nombre;
        private String correo;
        private String contrasena;

        /**
         * Crea un nuevo objeto de tipo Usuario con los valores proporcionados.
         *
         * @param nombre      el nombre del usuario
         * @param correo      el correo electrónico del usuario
         * @param contrasena  la contraseña del usuario
         */
        public Usuario(String nombre, String correo, String contrasena) {
            this.nombre = nombre;
            this.correo = correo;
            this.contrasena = contrasena;
        }

        /**
         * Obtiene el valor de la propiedad correo.
         *
         * @return  el valor de la propiedad correo
         */
        public String getCorreo() {
            return correo;
        }

        /**
         * Obtiene el valor de la propiedad contrasena.
         *
         * @return el valor de la propiedad contrasena
         */
        public String getContrasena() {
            return contrasena;
        }

        /**
         * Obtiene el nombre.
         *
         * @return el nombre
         */
        public String getNombre() {
            return nombre;
        }
    }
    }
}
