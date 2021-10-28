import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 * XML: Ejemplo2 lectura mediante DOM
 */
public class App2 {

    public static void main(String[] args) {

        try {

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document document = db.parse(new File("./resources/bookstore.xml"));

            // Normalizar el árbol
            document.getDocumentElement().normalize();

            NodeList list = document.getElementsByTagName("book");

            for (int i = 0; i < list.getLength(); i++) {

                Node padre = list.item(i);

                NodeList listaHijos = padre.getChildNodes();

                for (int j = 0; j < listaHijos.getLength(); j++) {
                    Node hijo = listaHijos.item(j);

                    if (hijo.getNodeName() == "title") {
                        System.out.println(hijo.getFirstChild().getNodeValue());
                    } else {
                        if (hijo.getNodeName() == "price") {
                            System.out.println("\tPrecio: " + hijo.getFirstChild().getNodeValue() + "€");
                        }
                    }

                }

                System.out.println("\tCategoria: " + padre.getAttributes().getNamedItem("category").getNodeValue());

            }

        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(App2.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
