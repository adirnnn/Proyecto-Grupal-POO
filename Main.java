import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca(new Scanner(System.in));
        biblioteca.cargarUsuarios();
        biblioteca.mostrarMenu();
    }

    static class Biblioteca {
        private Scanner scanner;
        private List<Usuario> listaDeUsuarios;
        private Usuario usuarioAutenticado;

        public Biblioteca(Scanner scanner) {
            this.scanner = scanner;
            this.listaDeUsuarios = new ArrayList<>();
        }

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
                    case 1:
                        iniciarSesion();
                        break;
                    case 2:
                        crearNuevoUsuario();
                        break;
                    case 3:
                        guardarUsuarios();
                        System.out.println("Gracias por visitar la Biblioteca. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } while (opcion != 3);
        }

        private void cargarUsuarios() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("usuarios.dat"))) {
                listaDeUsuarios = (List<Usuario>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("No se pudo cargar la lista de usuarios.");
            }
        }

        private void guardarUsuarios() {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("usuarios.dat"))) {
                oos.writeObject(listaDeUsuarios);
            } catch (IOException e) {
                System.out.println("No se pudo guardar la lista de usuarios.");
            }
        }

        private void iniciarSesion() {
            System.out.println("Ingrese su correo electrónico:");
            String correo = scanner.nextLine();
            System.out.println("Ingrese su contraseña:");
            String contrasena = scanner.nextLine();

            Usuario usuario = buscarUsuario(correo, contrasena);

            if (usuario != null) {
                System.out.println("¡Bienvenido, " + usuario.getNombre() + "!");
                usuarioAutenticado = usuario;
                mostrarMenuUsuario();
            } else {
                System.out.println("Correo electrónico o contraseña incorrectos.");
            }
        }

        private void mostrarMenuUsuario() {
            int opcionUsuario;
            do {
                System.out.println("Menú del Usuario:");
                System.out.println("1. Ver libros disponibles");
                System.out.println("2. Calificar un libro");
                System.out.println("3. Gestionar libros rentados");
                System.out.println("4. Modificar información del usuario");
                System.out.println("5. Ver calificaciones");
                System.out.println("6. Cerrar sesión");
                System.out.print("Ingrese su elección: ");
                opcionUsuario = obtenerEnteroInput();

                switch (opcionUsuario) {
                    case 1:
                        // Lógica para ver libros disponibles
                        break;
                    case 2:
                        // Lógica para calificar un libro
                        break;
                    case 3:
                        // Lógica para gestionar libros rentados
                        break;
                    case 4:
                        // Lógica para modificar información del usuario
                        break;
                    case 5:
                        // Lógica para ver calificaciones
                        break;
                    case 6:
                        System.out.println("Cerrando sesión. ¡Hasta luego, " + usuarioAutenticado.getNombre() + "!");
                        break;
                    default:
                        System.out.println("Opción no válida. Inténtelo de nuevo.");
                }
            } while (opcionUsuario != 6);

            usuarioAutenticado = null;
        }

        // Resto del código...

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

        private Usuario buscarUsuario(String correo, String contrasena) {
            for (Usuario usuario : listaDeUsuarios) {
                if (usuario.getCorreo().equals(correo) && usuario.getContrasena().equals(contrasena)) {
                    return usuario;
                }
            }
            return null;
        }

        private void crearNuevoUsuario() {
            // Implementa la lógica para crear un nuevo usuario aquí
            // Puedes usar scanner para obtener datos del usuario
        }
    }

    static class Usuario implements Serializable {
        private String nombre;
        private String correo;
        private String contrasena;

        public Usuario(String nombre, String correo, String contrasena) {
            this.nombre = nombre;
            this.correo = correo;
            this.contrasena = contrasena;
        }

        public String getNombre() {
            return nombre;
        }

        public String getCorreo() {
            return correo;
        }

        public String getContrasena() {
            return contrasena;
        }
    }

    // Resto del código...
}
