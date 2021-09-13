package adt1_ejemplos;

import java.io.*;

// Ficheros binarios: lectura
public class App5 {

    public static void main(String[] args) {

        try {
            FileInputStream archivo = new FileInputStream("./resources/ejemplo5.png");
            boolean eof = false;
            int contador = 0;

            while (!eof) {
                int entrada = archivo.read();
                System.out.print(entrada + ", ");
                if (entrada == -1) {
                    eof = true;
                } else {
                    contador++;
                }
            }

            archivo.close();

            System.out.println("\n Bytes leidos: " + contador);

        } catch (IOException err) {
            System.out.println("Error: " + err.toString());
        }

    }

}
