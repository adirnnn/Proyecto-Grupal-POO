import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    private List<Libro> libros;
    private List<Estudiante> estudiantes;
    private List<Calificacion> calificaciones;
    private List<Usuario> usuarios;
    private List<Item> items;
    private List<Libro> librosRentados;

    public Biblioteca() {
        this.libros = new ArrayList<>();
        this.estudiantes = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.items = new ArrayList<>();
        this.librosRentados = new ArrayList<>();
    }

    public void agregarLibros(List<Libro> libros) {
        this.libros.addAll(libros);
    }

    public void agregarEstudiante(Estudiante estudiante) {
        estudiantes.add(estudiante);
    }

    public void mostrarListadoLibros() {
        System.out.println("Listado de libros:");

        for (Libro libro : libros) {
            System.out.println("Título: " + libro.getTitulo());
            System.out.println("Editorial: " + libro.getEditorial());

            if (libro.esVirtual()) {
                System.out.println("Link: " + libro.getLink());
            }

            System.out.println("----------------------");
        }
    }

    public void mostrarMenuEstudiante(Estudiante estudiante) {
        System.out.println("¡Bienvenido, " + estudiante.getNombre() + "!");

        int opcion;
        do {
            System.out.println("Menú:");
            System.out.println("1. Ver listado de libros");
            System.out.println("2. Salir");

            opcion = obtenerEnteroInput("Ingrese su elección: ");

            switch (opcion) {
                case 1:
                    mostrarListadoLibros();
                    break;
                case 2:
                    System.out.println("Saliendo del programa. ¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }
        } while (opcion != 2);
    }

    public Estudiante crearNuevoEstudiante() {
        System.out.println("Creación de Nuevo Estudiante:");

        // Solicitar nombre y correo electrónico
        String nombre = obtenerInput("Ingrese el nombre del estudiante: ");
        String correoElectronico = obtenerInput("Ingrese el correo electrónico del estudiante: ");

        // Crear y devolver el nuevo estudiante
        Estudiante nuevoEstudiante = new Estudiante(nombre, correoElectronico);
        estudiantes.add(nuevoEstudiante);
        return nuevoEstudiante;
    }

    public int obtenerEnteroInput(String mensaje) {
        int resultado = 0;
        boolean entradaValida = false;
        do {
            try {
                System.out.print(mensaje);
                BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
                resultado = Integer.parseInt(br.readLine());
                entradaValida = true;
            } catch (NumberFormatException | IOException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        } while (!entradaValida);
        return resultado;
    }

    private String obtenerInput(String mensaje) {
        String resultado = "";
        boolean entradaValida = false;
        do {
            try {
                System.out.print(mensaje);
                BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
                resultado = br.readLine();
                entradaValida = true;
            } catch (IOException e) {
                System.out.println("Error al obtener la entrada. Inténtelo de nuevo.");
            }
        } while (!entradaValida);
        return resultado;
    }

    public boolean hayEstudiantes() {
        return !estudiantes.isEmpty();
    }

    public List<Libro> buscarLibros(String titulo) {
        List<Libro> librosEncontrados = new ArrayList<>();

        for (Libro libro : libros) {
            if (libro.getTitulo().toLowerCase().contains(titulo.toLowerCase())) {
                librosEncontrados.add(libro);
            }
        }
        return librosEncontrados;
    }

    public Libro buscarLibroPorTitulo(String titulo) {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        return null;
    }

    public List<Calificacion> obtenerCalificaciones(Usuario usuario) {
        List<Calificacion> calificacionesUsuario = new ArrayList<>();
        for (Calificacion calificacion : calificaciones) {
            if (calificacion.getUsuario().equals(usuario)) {
                calificacionesUsuario.add(calificacion);
            }
        }
        return calificacionesUsuario;
    }

    public void agregarCalificacion(Calificacion calificacion) {
        calificaciones.add(calificacion);
    }

    public void eliminarUsuario(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public List<Item> obtenerItemsDisponibles() {
        return items;
    }

    public void agregarItem(Item item) {
        items.add(item);
    }
        public List<Libro> obtenerLibrosRentados(Usuario usuario) {
        List<Libro> librosUsuario = new ArrayList<>();
        for (Libro libro : librosRentados) {
            if (libro.estaRentadoPor(usuario)) {
                librosUsuario.add(libro);
            }
        }
        return librosUsuario;
    }
}