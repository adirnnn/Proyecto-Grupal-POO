import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LibrosCSVReaderReserva {

    public static void reservarLibro(String nombreLibro, String nombreUsuario) {
        String rutaArchivo = "Libros.csv";
        File archivo = new File(rutaArchivo);
        File archivoTemporal = new File("Temp.csv");

        try (Scanner scanner = new Scanner(archivo);
             FileWriter writer = new FileWriter(archivoTemporal)) {

            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(",");

                if (campos.length >= 5 && campos[0] != null && campos[0].equalsIgnoreCase(nombreLibro)) {
                    if (campos[4] != null && campos[4].equalsIgnoreCase("disponible")) {
                        campos[4] = "reservado por " + nombreUsuario;
                        System.out.println("Libro reservado exitosamente por " + nombreUsuario);
                    } else {
                        System.out.println("El libro no está disponible o ya está reservado.");
                    }
                }

                writer.append(String.join(",", campos)).append("\n");
            }

        } catch (IOException e) {
            System.out.println("Error al reservar el libro: " + e.getMessage());
        }

        archivo.delete();
        archivoTemporal.renameTo(archivo);
    }

    public static void main(String[] args) {
        String nombreLibroAReservar = "Don Quijote de la Mancha"; // Nombre del libro a reservar
        String nombreUsuario = "Jorge"; // Nombre del usuario

        reservarLibro(nombreLibroAReservar, nombreUsuario);
        leerYMostrarDatosLibrosReserva();
    }

    public static void leerYMostrarDatosLibrosReserva() {
        String rutaArchivo = "Libros.csv";

        try {
            File archivo = new File(rutaArchivo);
            Scanner scanner = new Scanner(archivo, "UTF-8");

            // Leer el encabezado (si existe)
            if (scanner.hasNextLine()) {
                String encabezado = scanner.nextLine();
                String[] encabezados = encabezado.split(",");
                imprimirEncabezados(encabezados);
            }

            System.out.println(); // Agregar una línea en blanco para separar los encabezados de los datos

            // Leer el resto de las líneas
            while (scanner.hasNextLine()) {
                String linea = scanner.nextLine();
                String[] campos = linea.split(",");
                imprimirDatos(campos);
            }

            // Cerrar el scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + rutaArchivo);
            e.printStackTrace();
        }
    }

    private static void imprimirEncabezados(String[] encabezados) {
        for (String encabezado : encabezados) {
            System.out.printf("%-25s", encabezado); // Alineación a la izquierda con un ancho máximo de 25 caracteres
        }
    }

    private static void imprimirDatos(String[] datos) {
        for (String dato : datos) {
            System.out.printf("%-25s", dato); // Alineación a la izquierda con un ancho máximo de 25 caracteres
        }
        System.out.println(); // Agregar una línea en blanco entre las filas de datos
    }

}
