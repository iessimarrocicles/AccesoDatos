package adt1_ejemplos;

import java.io.*;

// Ficheros de texto: Escritura y lectura de lineas de caracteres
public class App4 {

    public static void main(String[] args) {

        String fichero = "./resources/ejemplo4.txt";
        try {
            // Escritura en el fichero
            PrintWriter pw = new PrintWriter(new File(fichero));
            for (int i = 0; i < 10; i++) {
                pw.println(i);
            }
            pw.close();

            //Lectura en el fichero de lineas de caracteres
            FileReader fr = new FileReader(new File(fichero));
            BufferedReader br = new BufferedReader(fr);

            String linea;

            while ((linea = br.readLine()) != null) {
                System.out.println("Linea leida: " + linea);
            }
            br.close();
        } catch (IOException ex) {
            System.err.println("Problemas del fichero " + fichero);
        }
    }
}
