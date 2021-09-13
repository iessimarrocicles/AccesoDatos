package adt1_ejemplos;

import java.io.*;

// Ficheros de texto: Escritura
public class App2 {

    public static void main(String[] args) {

        String fichero = "./resources/ejemplo2.txt";
        try {
            PrintWriter pw = new PrintWriter(new FileWriter(fichero));
            pw.print("El veloz murciélago hindú");
            pw.println(" comía feliz cardillo y kiwi");
            pw.println(4.815162342);
            pw.close();
        } catch (FileNotFoundException e) {
            System.err.println("Problemas fichero no encontrado " + fichero);
        } catch (IOException ex) {
            System.err.println("Problemas al abrir el fichero " + fichero);
        }
    }
}

