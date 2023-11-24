import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class LibrosCSVReader {

    public static void leerYMostrarDatosLibros() {
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
                System.out.println(); // Agregar una línea en blanco después de cada conjunto de datos
            }

            // Cerrar el scanner
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Archivo no encontrado: " + rutaArchivo);
            e.printStackTrace();
        }
    }

    private static void imprimirEncabezados(String[] encabezados) {
        System.out.printf("%-25s%-25s%-25s%n", encabezados[0], encabezados[1], encabezados[2]);
    }

    private static void imprimirDatos(String[] datos) {
        System.out.printf("%-25s%-25s%-25s%n", datos[0], datos[1], datos[2]);
    }

    public static void main(String[] args) {
        // Llamada a la función para leer y mostrar datos desde el archivo CSV
        leerYMostrarDatosLibros();
    }
}
