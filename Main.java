import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String NOMBRE_ARCHIVO_USUARIOS = "usuarios.txt";
    private static Map<String, String> usuarios = new HashMap<>();
    private static String usuarioActual = null;

    public static void main(String[] args) {
        cargarUsuariosDesdeArchivo();

        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            try {
                System.out.println("Bienvenido al programa:");
                System.out.println("1. Iniciar sesión");
                System.out.println("2. Registrar un nuevo usuario");
                System.out.println("3. Salir");
                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada

                switch (opcion) {
                    case 1:
                        iniciarSesion();
                        break;
                    case 2:
                        registrarUsuario();
                        break;
                    case 3:
                        guardarUsuariosEnArchivo();
                        System.out.println("Gracias por usar el programa. ¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Respuesta inválida. Inténtelo de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.nextLine(); // Limpiar el buffer de entrada para evitar bucle infinito
                opcion = 0; // Asignar un valor válido para que el bucle continúe
            }
        } while (opcion != 3);

        scanner.close();
    }

    private static void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine().toLowerCase(); // Convertir a minúsculas

        System.out.println("Ingrese su contraseña:");
        String contrasena = scanner.nextLine();

        if (usuarios.containsKey(correo) && usuarios.get(correo).equals(contrasena)) {
            System.out.println("Inicio de sesión exitoso. ¡Bienvenido!");
            usuarioActual = correo;
            menuPrincipal();
        } else {
            System.out.println("Correo electrónico o contraseña incorrectos. Inténtelo de nuevo.");
        }
    }

    private static void menuPrincipal() {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n\t\tMenú Principal:");
            System.out.println("\t1. Mostrar Libros en catálogo");
            System.out.println("\t2. Realizar reserva");
            System.out.println("\t3. Cerrar sesión");
            System.out.print("\tSeleccione una opción: ");

            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de entrada

            switch (opcion) {
                case 1:
                    LibrosCSVReader.leerYMostrarDatosLibros();
                    System.out.println("Realizando tarea 1...");
                    break;
                case 2:
                    realizarReserva();
                    break;
                case 3:
                    usuarioActual = null;
                    System.out.println("Cierre de sesión exitoso. Regresando al menú principal.");
                    break;
                default:
                    System.out.println("Respuesta inválida. Inténtelo de nuevo.");
                    break;
            }
        } while (opcion != 3);
    }

    private static void realizarReserva() {
        if (usuarioActual == null) {
            System.out.println("Debes iniciar sesión para hacer una reserva.");
            return;
        }

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del libro que desea reservar:");
        String nombreLibro = scanner.nextLine();

        // Aquí puedes agregar la lógica para realizar la reserva, por ejemplo, actualizar un estado en el libro, etc.
        // También puedes almacenar las reservas en una estructura de datos, por ejemplo, un mapa con el nombre del libro y el usuario que lo reservó.
        // Por ahora, simplemente mostraremos un mensaje de reserva exitosa.

        System.out.println("Reserva exitosa. ¡Disfruta de tu lectura!");
    }

    private static void registrarUsuario() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese su correo electrónico:");
        String correo = scanner.nextLine().toLowerCase(); // Convertir a minúsculas

        if (usuarios.containsKey(correo)) {
            System.out.println("Este correo electrónico ya está en uso. Inténtelo con otro.");
            return;
        }

        System.out.println("Ingrese una contraseña:");
        String contrasena = scanner.nextLine();

        usuarios.put(correo, contrasena);
        System.out.println("Usuario registrado con éxito.");
    }

    private static void cargarUsuariosDesdeArchivo() {
        try {
            File archivo = new File(NOMBRE_ARCHIVO_USUARIOS);
            Scanner scanner = new Scanner(archivo);

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] partes = linea.split(",");
                if (partes.length == 2) {
                    usuarios.put(partes[0].toLowerCase(), partes[1]); // Convertir a minúsculas
                }
            }

            scanner.close();
        } catch (IOException e) {
            System.out.println("Error al cargar usuarios desde el archivo: " + e.getMessage());
        }
    }

    private static void guardarUsuariosEnArchivo() {
        try {
            File archivo = new File(NOMBRE_ARCHIVO_USUARIOS);
            FileWriter escritor = new FileWriter(archivo);

            for (Map.Entry<String, String> entry : usuarios.entrySet()) {
                escritor.write(entry.getKey() + "," + entry.getValue() + "\n");
            }

            escritor.close();
        } catch (IOException e) {
            System.out.println("Error al guardar usuarios en el archivo: " + e.getMessage());
        }
    }
}

