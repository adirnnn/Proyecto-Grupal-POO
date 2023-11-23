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

    public static void main(String[] args) {
        // Llamada a la función para leer y mostrar datos desde el archivo CSV
        leerYMostrarDatosLibros();
    }
}
