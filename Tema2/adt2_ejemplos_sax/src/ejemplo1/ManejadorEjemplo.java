package ejemplo1;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Manejador de eventos SAX de ejemplo.
 * 
*
 */
public class ManejadorEjemplo extends DefaultHandler {

    @Override
    public void startDocument() throws SAXException {
        System.out.println("\nPrincipio del documento...");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("\nFin del documento...");
    }

    @Override
    public void startElement(String uri, String name, String prefijo, Attributes attributes)
            throws SAXException {
        System.out.println("\nProcesando etiqueta...");
        System.out.println("\tNamespace uri: " + uri);
        System.out.println("\tNombre con prefijo: " + prefijo);
        System.out.println("\tNombre: " + name);
        //Recorremos los atributos
        System.out.println("\tProcesando " + attributes.getLength() + " atributos...");
        for (int i = 0; i < attributes.getLength(); i++) {
            System.out.println("\t\tNombre: " + attributes.getQName(i));
            System.out.println("\t\tValor: " + attributes.getValue(i));
        }
        // También podemos obtener los atributos por nombre
        String valorId = attributes.getValue("id");
        if (valorId != null) {
            System.out.println("\tEjemplo de obtencion de atributos por su nombre...");
            System.out.println("\tId: " + valorId);
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        System.out.println("\nProcesando texto dentro de una etiqueta... ");
        System.out.println("\tTexto: " + String.valueOf(ch, start, length));
    }

    @Override
    public void endElement(String uri, String name, String prefijo) throws SAXException {
        System.out.println("\nFin de etiqueta...");
        System.out.println("\tNamespace uri: " + uri);
        System.out.println("\tNombre con prefijo: " + prefijo);
        System.out.println("\tNombre: " + name);
    }
}
