package adt1_ejemplos;

import java.io.*;

// Ficheros de texto: Lectura de caracteres
public class App3 {

    public static void main(String[] args) {

        File fichero = new File("./src/adt1_ejemplos/App3.java");

        try {

            //crear el flujo de entrada             
            FileReader fileReader = new FileReader(fichero);

            int i;
            //se va leyendo un caracter
            while ((i = fileReader.read()) != -1) {
                System.out.println((char) i);
            }

            //cerrar flujo de entrada
            fileReader.close();
            
        } catch (IOException ex) {
            System.err.println("Problemas del fichero " + fichero);
        }
    }
}
