import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVReader {
    public static List<Libro> leerLibrosDesdeCSV(String archivoCSV) {
        List<Libro> libros = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(archivoCSV))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");

                if (datos.length >= 3) {
                    String titulo = datos[0].trim(); // Asegurar que no hay espacios adicionales
                    String editorial = datos[1].trim();
                    boolean esVirtual = Boolean.parseBoolean(datos[2].trim());
                    
                    // Verificar la longitud antes de acceder a datos[3]
                    String link = esVirtual && datos.length > 3 ? datos[3].trim() : null;

                    Libro libro = new Libro(titulo, editorial, esVirtual, link);
                    libros.add(libro);
                } else {
                    System.out.println("Error: Datos incompletos en la línea: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        return libros;
    }
}
