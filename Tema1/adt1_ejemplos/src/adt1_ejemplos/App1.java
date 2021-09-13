package adt1_ejemplos;

import java.io.*;

// Ficheros binarios: Escritura y lectura
public class App1 {

    public static void main(String[] args) {

        String fichero = "./resources/ejemplo1.data";
        String nombre = "IIP";
        int conv = 1;
        double nota = 7.8;

        try {
            // Escritura de datos primitivos en un fichero binario
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fichero));
            out.writeUTF(nombre);
            out.writeInt(conv);
            out.writeDouble(nota);
            out.close();

            // Lectura de datos primitivos en un fichero binario
            DataInputStream in = new DataInputStream(new FileInputStream(new File(fichero)));
            System.out.println("Valor leído de nombre: " + in.readUTF());
            System.out.println("Valor leído de convocatoria: " + in.readInt());
            System.out.println("Valor leído de nota: " + in.readDouble());
            in.close();
        } catch (FileNotFoundException e) {
            System.err.println("Problemas con el fichero " + fichero + "." + e.getMessage());
        } catch (IOException e) {
            System.err.println("Problemas al escribir en el fichero " + fichero);
        }
    }
}
