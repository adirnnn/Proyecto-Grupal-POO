import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final String NOMBRE_ARCHIVO_USUARIOS = "usuarios.txt";
    private static Map<String, String> usuarios = new HashMap<>();
    private static String usuarioActual = null;

    public static void main(String[] args) {
        cargarUsuariosDesdeArchivo();

        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

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
        try (Scanner scanner = new Scanner(System.in)) {
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
    }

    private static void realizarReserva() {
        if (usuarioActual == null) {
            System.out.println("Debes iniciar sesión para hacer una reserva.");
            return;
        }

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese el nombre del libro que desea reservar:");
            String titulo = scanner.nextLine();

            // Aquí deberías implementar la lógica para reservar el libro con el título proporcionado
            boolean reservaExitosa = CatalogoLibros.reservarLibro(titulo); // Asumiendo que tienes una instancia de CatalogoLibros llamada 'catalogo'

            if (reservaExitosa) {
                System.out.println("Reserva exitosa. ¡Disfruta de tu lectura!");
            } else {
                System.out.println("El libro no está disponible o no existe.");
            }
        }
    }

private static void menuPrincipal() {
    try (Scanner scanner = new Scanner(System.in)) {
        int opcion = 0;

        do {
            try {
                System.out.println("Menú principal:");
                System.out.println("1. Realizar una reserva");
                System.out.println("2. Ver mis reservas");
                System.out.println("3. Cerrar sesión");
                System.out.print("Seleccione una opción: ");

                opcion = scanner.nextInt();
                scanner.nextLine(); // Limpiar el buffer de entrada

                switch (opcion) {
                    case 1:
                        realizarReserva();
                        LibrosCSVReader.leerYMostrarDatosLibros();
                        System.out.println("Realizando tarea 1...");
                        break;
                    case 2:
                        do {
                            try {
                                System.out.println("Opciones de ver mis reservas:");
                                System.out.println("1. Opción 1");
                                System.out.println("2. Opción 2");
                                System.out.println("3. Volver al menú principal");
                                System.out.print("Seleccione una opción: ");

                                opcion = scanner.nextInt();
                                scanner.nextLine(); // Limpiar el buffer de entrada

                                switch (opcion) {
                                    case 1:
                                        // Lógica para la opción 1
                                        break;
                                    case 2:
                                        // Lógica para la opción 2
                                        break;
                                    case 3:
                                        System.out.println("Volviendo al menú principal...");
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
                        break;
                    case 3:
                        usuarioActual = null;
                        System.out.println("Cierre de sesión exitoso. Regresando al menú principal.");
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
    }
}
    

    private static void registrarUsuario() {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Ingrese su correo electrónico:");
            String correo = scanner.nextLine().toLowerCase(); // Convertir a minúsculas
    
            if (usuarios.containsKey(correo)) {
                System.out.println("Este correo electrónico ya está en uso. Inténtelo con otro.");
                return;
            }
    
            System.out.println("Ingrese una contraseña:");
            String contrasena = scanner.nextLine();
    
            usuarios.put(correo, contrasena);
        }
    
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

