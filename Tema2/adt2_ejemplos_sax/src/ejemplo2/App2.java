package ejemplo2;

import java.io.File;
import java.io.FileInputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class App2 {
    public static void main(String[] args) throws Exception {
        //Nombre del fichero a analizar
        File filename = new File("./resources/ejemplo2.xml");

        // Creamos nuestro objeto libro vacío  
        Libro libro = new Libro();

        try {

            // Creamos la factoria de analizadores por defecto  
            XMLReader reader = XMLReaderFactory.createXMLReader();
            // Añadimos nuestro manejador al reader pasandole el objeto libro  
            reader.setContentHandler(new ManejadorLibro(libro));
            // Procesamos el xml de ejemplo  
            reader.parse(new InputSource(new FileInputStream(filename)));
            // Ya tenemos nuestro objeto libro con los valores obtenidos del xml  
            // Lo imprimimos  
            System.out.println(libro.toString());

        } catch (Exception e) {

            String errorMessage = "Error analizando " + filename + ": " + e;
            System.err.println(errorMessage);
            e.printStackTrace();
        }    }
}
