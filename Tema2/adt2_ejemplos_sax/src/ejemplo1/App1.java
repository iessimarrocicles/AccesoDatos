package ejemplo1;

import java.io.File;
import java.io.FileInputStream;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class App1 {
    public static void main(String[] args) throws Exception {

        //Nombre del fichero a analizar
        File filename = new File("./resources/ejemplo1.xml");

        try {
            // Creamos la factoria de analizadores por defecto  
            XMLReader procesadorXML = XMLReaderFactory.createXMLReader();
            // Creamos un objeto de nuestro manejador
            ManejadorEjemplo gestor = new ManejadorEjemplo();
            // Añadimos nuestro manejador al procesadorXML 
            procesadorXML.setContentHandler(gestor);
            // Creamos un InputSource de nuestro fichero
            InputSource fileXML = new InputSource(new FileInputStream(filename));
            // Procesamos el xml de ejemplo  
            procesadorXML.parse(fileXML);

        } catch (Exception e) {
            String errorMessage = "Error analizando " + filename + ": " + e;
            System.err.println(errorMessage);
            e.printStackTrace();
        }

    }
}
