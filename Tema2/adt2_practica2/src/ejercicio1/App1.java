package ejercicio1;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class App1 {
    public static void main(String[] args) throws Exception {
        
                //Nombre del fichero a analizar
                File filename = new File("./resources/ejercicio1/ejercicio1.xml");

                // Creamos nuestros listas de objetos recetas   
                ArrayList<Receta> listaPrincipal = new ArrayList<>();
                ArrayList<Receta> listaSecundario = new ArrayList<>();
                ArrayList<Receta> listaPostre = new ArrayList<>();
        
                try {
        
                    // Creamos la factoria de analizadores por defecto  
                    XMLReader reader = XMLReaderFactory.createXMLReader();
                    // Creamos un objeto de nuestra GestionEventos
                    GestionEventos gestor = new GestionEventos(listaPrincipal, listaSecundario, listaPostre);
                    // Añadimos nuestro manejador al reader pasandole el objeto libro  
                    reader.setContentHandler(gestor);
                    // Procesamos el xml de ejemplo  
                    reader.parse(new InputSource(new FileInputStream(filename)));
                    // Ya tenemos nuestro objeto libro con los valores obtenidos del xml  
        
                    // Lo imprimimos las 3 listas
                    System.out.println("PRINCIPAL");
                    System.out.println(listaPrincipal.toString());
                    System.out.println("SECUNDARIO");
                    System.out.println(listaSecundario.toString());
                    System.out.println("POSTRE");
                    System.out.println(listaPostre.toString());
        
                    // Gestor para la generación del DOM
                    XmlCtrlDom controlador = new XmlCtrlDom();
                    Document document = null;
                    
                    // PRINCIPAL
                    document = controlador.instanciarDocument();
                    controlador.generarArbolRecetario(document, listaPrincipal);
                    controlador.escribirDocumentAXmlFichero(document, new File("./resources/ejercicio1/principal.xml"));
        
                    // SECUNDARIO
                    document = controlador.instanciarDocument();
                    controlador.generarArbolRecetario(document, listaSecundario);
                    controlador.escribirDocumentAXmlFichero(document, new File("./resources/ejercicio1/secundario.xml"));
        
                    // POSTRE
                    document = controlador.instanciarDocument();
                    controlador.generarArbolRecetario(document, listaPostre);
                    controlador.escribirDocumentAXmlFichero(document, new File("./resources/ejercicio1/postre.xml"));
                    
                    // FIN DEL PROGRAMA
                    System.out.println("Ficheros generados.");
        
                } catch (Exception e) {
        
                    String errorMessage = "Error analizando " + filename + ": " + e;
                    System.err.println(errorMessage);
                    e.printStackTrace();
                }

    }
}
