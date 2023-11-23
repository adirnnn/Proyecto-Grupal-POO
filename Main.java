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

    static class CSVReader {

        public static List<Libro> leerLibrosDesdeCSV(String rutaCSV) {
            List<Libro> listaDeLibros = new ArrayList<>();

            try (BufferedReader br = new BufferedReader(new FileReader(rutaCSV))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(",");
                    if (partes.length == 5) {
                        String titulo = partes[0].trim();
                        String autor = partes[1].trim();
                        String editorial = partes[2].trim();
                        boolean esVirtual = Boolean.parseBoolean(partes[3].trim());
                        String link = partes[4].trim();
                        Libro libro = new Libro(titulo, autor, editorial, esVirtual, link);
                        listaDeLibros.add(libro);
                    }
                }
            } catch (IOException e) {
                System.out.println("Error al cargar libros desde el archivo CSV.");
            }

            return listaDeLibros;
        }
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
                System.out.println("\t\t\tBienvenido a la Biblioteca:");
                System.out.println("\t\t1. Iniciar sesión");
                System.out.println("\t\t2. Registrarse como nuevo usuario");
                System.out.println("\t\t3. Salir");
                System.out.print("\tIngrese su elección: ");
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
                        System.out.println("\t\t\u001B[34mGracias por visitar la Biblioteca. ¡Hasta luego!\u001B[0m");
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
            System.out.println("\t\tIngrese su correo electrónico:");
            String correo = scanner.nextLine();
            System.out.println("\t\tIngrese su contraseña:");
            String contrasena = scanner.nextLine();

            Usuario usuario = buscarUsuario(correo, contrasena);

            if (usuario != null) {
                System.out.println("\t\t¡Bienvenido, " + usuario.getNombre() + "!");
                usuarioAutenticado = usuario;
                mostrarMenuUsuario();
            } else {
                System.out.println("Correo electrónico o contraseña incorrectos.");
            }
        }

        private void mostrarMenuUsuario() {
            int opcionUsuario;
            do {
                System.out.println("\tMenú del Usuario:");
                System.out.println("1. Ver libros disponibles");
                System.out.println("2. Calificar un libro");
                System.out.println("3. libros reservar ");
                System.out.println("4. Modificar información del usuario");
                System.out.println("5. Ver calificaciones");
                System.out.println("6. Cerrar sesión");
                System.out.print("Ingrese su elección: ");
                opcionUsuario = obtenerEnteroInput();

                switch (opcionUsuario) {
                    case 1:
                
                    LibrosCSVReader.leerYMostrarDatosLibros();
                        System.out.println("Has seleccionado la opcion 1");
                        break;
                    case 2:
                        // Lógica para calificar un libro
                        break;
                    case 3:
                        reservarLibro();
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

private void reservarLibro() {
    // Lógica para reservar un libro por el usuario autenticado
    System.out.println("Ingrese el nombre del libro a reservar:");
    String nombreLibro = scanner.nextLine();

    // Buscar el libro por nombre en la lista de libros disponibles
    List<Libro> listaDeLibros = CSVReader.leerLibrosDesdeCSV("Libros.csv");
    boolean libroEncontrado = false;

    for (Libro libro : listaDeLibros) {
        if (libro.getTitulo().length > 0 && !libro.estaReservado()) {
            libro.reservar(usuarioAutenticado.getNombre());
            libroEncontrado = true;
            System.out.println("Libro reservado exitosamente por " + usuarioAutenticado.getNombre());
            break;
        }
    }

    if (!libroEncontrado) {
        System.out.println("El libro no está disponible o ya está reservado.");
    }
}
        
        

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

    static class Libro {
        private String titulo;
        private boolean reservado;

        public Libro(String titulo, String autor, String editorial, boolean esVirtual, String link) {
            this.titulo = titulo;
            
        }


        public boolean estaReservado() {
            return reservado;
        }

        public char[] getTitulo() {
            return null;
        }

        public void reservar(String usuario) {
            reservado = true;
        }

        public boolean estaReservado(Class<Boolean> class1) {
            return false;
        }

        @Override
        public String toString() {
            return "Título: " + titulo + ", Reservado: " + (reservado ? "Sí" : "No");
        }
    }
}