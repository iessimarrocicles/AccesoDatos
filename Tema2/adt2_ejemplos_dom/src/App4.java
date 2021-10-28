import java.io.*;

import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.*;

/**
 * XML: Ejemplo escritura mediante DOM en un fichero que NO existe
 */
public class App4 {

    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();

        // Crea un arbol DOM vacío
        Document document = builder.newDocument();

        Element elementoRaiz = document.createElement("libros");
        document.appendChild(elementoRaiz);
        
        // Crear nuevo Elemento
        Element nuevo = document.createElement("book");
        // crear atributo
        nuevo.setAttribute("category", "school");
        
        // Texto: creación (versión1)
        // nuevo.setTextContent("Libro Acceso a datos");

        // Texto: creación (versión2)
        Text nuevoTexto = document.createTextNode("Libro Acceso a datos");
        nuevo.appendChild(nuevoTexto);

        // Elemento raíz donde insertar el nuevo elemento
        elementoRaiz.appendChild(nuevo);

        System.out.println("Creación en el árbol DOM en memoria.");

        // Para pasar el árbol DOM de memoria a un fichero
        TransformerFactory transFactory = TransformerFactory.newInstance();
        Transformer idTransform = transFactory.newTransformer();
        idTransform.setOutputProperty(OutputKeys.METHOD,"xml");
        idTransform.setOutputProperty(OutputKeys.INDENT,"yes");
        Source input = new DOMSource(document);
        Result output = new StreamResult(
            new FileOutputStream(new File("./resources/ficherosalida2.xml")));
        idTransform.transform(input, output);

        System.out.println("Terminado la creación en el fichero destino.");
    }
    
}
