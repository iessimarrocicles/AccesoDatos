package ejercicio1;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

public class GestionEventos extends DefaultHandler {

    private ArrayList<Receta> listaPrincipal;
    private ArrayList<Receta> listaSecundario;
    private ArrayList<Receta> listaPostre;
    private String tipo;
    private String nombre;
    private String descripcion;
    private String aux;

    public GestionEventos(ArrayList<Receta> lPrincipal, ArrayList<Receta> lSecundario, ArrayList<Receta> lPostre) {
        tipo = "";
        listaPrincipal = lPrincipal;
        listaSecundario = lSecundario;
        listaPostre = lPostre;
    }

    @Override
    public void startDocument() {

    }

    @Override
    public void endDocument() {
        JOptionPane.showMessageDialog(null, "RECETAS LEÍDAS" + "\n Principal: " + listaPrincipal.size()
                + "\n Secundario: " + listaSecundario.size() + "\n Postre: " + listaPostre.size());
    }

    @Override
    public void startElement(String uri, String localName, String name, Attributes attributes) {

        String atributos = attributes.getValue(0);

        if (atributos != null) {
            this.tipo = atributos;
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) {

        if (localName.equals("nombre")) {
            this.nombre = aux;
        }
        if (localName.equals("descripcion")) {
            this.descripcion = aux;
        }
        if (localName.equals("receta")) {
            if (tipo != null) {
                switch (tipo) {
                case "principal":
                    listaPrincipal.add(new Receta(this.nombre, this.descripcion));
                    break;
                case "secundario":
                    listaSecundario.add(new Receta(this.nombre, this.descripcion));
                    break;
                case "postre":
                    listaPostre.add(new Receta(this.nombre, this.descripcion));
                    break;
                }
            }
        }
    }

    @Override
    public void characters(char[] ch, int inicio, int longitud) {
        aux = new String(ch, inicio, longitud);
    }
}
