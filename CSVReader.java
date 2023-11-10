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
                String titulo = datos[0];
                String editorial = datos[1];
                boolean esVirtual = Boolean.parseBoolean(datos[2]);
                String link = esVirtual ? datos[3] : null;

                Libro libro = new Libro(titulo, editorial, esVirtual, link);
                libros.add(libro);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return libros;
    }
}