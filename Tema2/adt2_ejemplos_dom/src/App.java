import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.*;
import org.w3c.dom.*;

public class App {
    public static void main(String[] args) throws Exception {

        DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = builderFactory.newDocumentBuilder();
        Document document = builder.parse(new File("./resources/bookstore.xml"));

        document.getDocumentElement().normalize();

        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Sacar los elementos hijos de la raíz:");
        System.out.println("---------------------------------------------------------------------------------------");

        // Obtenemos la etiqueta raíz
        Element elementRaiz = document.getDocumentElement();

        // Iteramos sobre sus hijos
        NodeList hijos = elementRaiz.getChildNodes();

        for (int i = 0; i < hijos.getLength(); i++) {
            Node nodo = hijos.item(i);
            if (nodo instanceof Element) {
                System.out.println("\t" + nodo.getNodeName());
            }
        }

        // Sacar todos los precios
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Sacar todos los precios (salen duplicados porque hemos utilizado 2 métodos diferentes):");
        System.out.println("---------------------------------------------------------------------------------------");
        NodeList list1 = document.getElementsByTagName("price");

        for (int i = 0; i < list1.getLength(); i++) {
            Node nodo = list1.item(i);
            if (nodo instanceof Element) {
                System.out.println("\t Método1: " + nodo.getTextContent());
                System.out.println("\t Método2: " + nodo.getFirstChild().getNodeValue());
            }
        }

        // Sacar el último precio
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Sacar último precio:");
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("\t" + list1.item(list1.getLength() - 1).getTextContent());

        // Sacar los atributos de book
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Sacar los atributos de book:");
        System.out.println("---------------------------------------------------------------------------------------");
        NodeList list2 = document.getElementsByTagName("book");

        for (int i = 0; i < list2.getLength(); i++) {
            Node nodo = list2.item(i);
            if (nodo instanceof Element) {
                // Compruebo por si algun elemento book no tiene el atributo category
                if (nodo.getAttributes().getNamedItem("category") instanceof Node) {
                    System.out.println("\tCategoria: " + nodo.getAttributes().getNamedItem("category").getNodeValue());
                }
            }
        }

        // Ejemplo XPATH para 1 Node
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Sacar 1 Node a partir de una ruta del XPATH:");
        System.out.println("---------------------------------------------------------------------------------------");
        XPathFactory xpathFactory = XPathFactory.newInstance();
        XPath xpath = xpathFactory.newXPath();

        Element elementRaiz2 = document.getDocumentElement();

        Node nodo = (Node) xpath.evaluate("/bookstore/book[price>35]/price", elementRaiz2, XPathConstants.NODE);

        System.out.println("\t" + nodo.getTextContent());

        // Ejemplo XPATH para NodeList
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.println("Sacar un listado (NodeList/NodeSet) a partir de una ruta del XPATH:");
        System.out.println("---------------------------------------------------------------------------------------");
        NodeList lista3 = (NodeList) xpath.evaluate("/bookstore/book[price>35]/price", elementRaiz2, XPathConstants.NODESET);

        for (int i = 0; i < lista3.getLength(); i++) {
            Node nodo3 = lista3.item(i);
            System.out.println("\t" + nodo3.getTextContent());
        }
    }
}
