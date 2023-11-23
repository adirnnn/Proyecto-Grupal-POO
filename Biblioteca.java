import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Biblioteca<Registro> {
    private static List<Libro> listaDeLibros = new ArrayList<>();
    private List<Usuario> listaDeUsuarios = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Biblioteca biblioteca = new Biblioteca();
        biblioteca.mostrarMenuInicioSesion();
    }

    public Usuario crearNuevoUsuario() {
        System.out.println("Creación de Nuevo Usuario:");
    
        System.out.println("Ingrese el nombre del usuario:");
        String nombre = scanner.nextLine();
        System.out.println("Ingrese el correo electrónico del usuario:");
        String correoElectronico = scanner.nextLine();
        System.out.println("Ingrese la contraseña del usuario:");
        String contrasena = scanner.nextLine();
    
        Usuario nuevoUsuario = new Usuario(nombre, correoElectronico, contrasena);
        registrarUsuario(nuevoUsuario);
        
        System.out.println("¡Usuario registrado exitosamente!");
    
        // Regresar al menú de inicio de sesión
        mostrarMenuInicioSesion();
        
        return nuevoUsuario;
    }
    

    public void iniciarSesion() {
        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine();
        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        Usuario usuario = buscarUsuario(correo, contrasena);

        if (usuario != null) {
            System.out.println("¡Bienvenido, " + usuario.getNombre() + "!");
            mostrarMenuUsuario(usuario);
        } else {
            System.out.println("Correo electrónico o contraseña incorrectos.");
        }
    }

    public void mostrarMenuUsuario(Usuario usuario) {
        if (usuario.esAdministrador()) {
            mostrarMenuAdmin();
        } else {
            mostrarMenuUsuarioNormal(usuario);
        }
    }

    private void mostrarMenuAdmin() {
        System.out.println("Menú de Administrador:");
        System.out.println("1. Agregar nuevo libro");
        System.out.println("2. Administrar usuarios");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                agregarNuevoLibro();
                break;
            case 2:
                administrarUsuarios();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    public void mostrarMenuInicioSesion() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Iniciar sesión");
        System.out.println("2. Registrarse como nuevo usuario");
        int opcion = scanner.nextInt();
        scanner.nextLine();
    
        switch (opcion) {
            case 1:
                iniciarSesion();
                break;
            case 2:
                crearNuevoUsuario();
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }
    

    private void administrarUsuarios() {
    }

    private void mostrarMenuUsuarioNormal(Usuario usuario) {
        System.out.println("Menú de Usuario:");
        System.out.println("1. Buscar libros");
        System.out.println("2. Ver historial");
        int opcion = scanner.nextInt();
        scanner.nextLine();

        switch (opcion) {
            case 1:
                buscarLibros();
                break;
            case 2:
                verHistorial(usuario);
                break;
            default:
                System.out.println("Opción no válida.");
                break;
        }
    }

    public Usuario buscarUsuario(String correo, String contrasena) {
        for (Usuario usuario : listaDeUsuarios) {
            if (usuario.getCorreoElectronico().equals(correo) && usuario.getContrasena().equals(contrasena)) {
                return usuario;
            }
        }
        return null;
    }

    public void registrarUsuario(Usuario usuario) {
        listaDeUsuarios.add(usuario);
    }

    public void agregarNuevoLibro() {
        System.out.println("Ingrese el título del libro:");
        String titulo = scanner.nextLine();
        System.out.println("Ingrese el autor del libro:");
        String autor = scanner.nextLine();
        System.out.println("¿El libro es virtual? (Sí/No):");
        boolean esVirtual = scanner.nextLine().equalsIgnoreCase("Sí");

        listaDeLibros.add(new Libro(titulo, autor, esVirtual));
        System.out.println("Libro agregado con éxito.");
    }

    public static List<Libro> buscarLibros() {
        System.out.println("Ingrese el título o autor a buscar:");
        String busqueda = scanner.nextLine();
        List<Libro> librosEncontrados = buscarLibrosPorTituloOAutor(busqueda);
        // ... (mostrar los libros encontrados)
        return librosEncontrados;
    }

    public static List<Libro> buscarLibrosPorTituloOAutor(String busqueda) {
        List<Libro> librosEncontrados = new ArrayList<>();
        for (Libro libro : listaDeLibros) {
            if (libro.getTitulo().toLowerCase().contains(busqueda.toLowerCase())
                    || libro.getAutor().toLowerCase().contains(busqueda.toLowerCase())) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public void verHistorial(Usuario usuario) {
        List<Registro> historial = obtenerHistorial(usuario);
        // ... (mostrar historial)
    }

    public List<Registro> obtenerHistorial(Usuario usuario) {
        // ... (lógica para obtener el historial del usuario)
        return new ArrayList<>(); // Temporal, debe retornar el historial
    }

    public Libro buscarLibroPorTitulo(String tituloLibro) {
        return null;
    }

    public void agregarCalificacion(Calificacion nuevaCalificacion) {
    }

    public void eliminarUsuario(Usuario usuario) {
    }

    public List<Calificacion> obtenerCalificaciones(Usuario usuario) {
        return null;
    }

    public void actualizarUsuario(Usuario usuario) {
    }

    public void devolverLibro(Usuario usuario, Libro libroDevuelto) {
    }

    public List<Libro> obtenerLibrosRentados(Usuario usuario) {
        return null;
    }

    public boolean renovarPrestamo(Usuario usuario, Libro libroARenovar) {
        return false;
    }

    public static List<Libro> buscarLibros(String tituloBusqueda) {
        return null;
    }

    public List<Item> obtenerItemsDisponibles() {
        return null;
    }

    public void agregarItem(Item nuevoItem) {
    }
}