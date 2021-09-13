package adt1_ejemplosObjetos3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class App {

    public static void main(String[] args) {
        Punto punto = new Punto(52, 5);

        // Escritura del objeto
        ObjectOutputStream oos = null;

        try {
            oos = new ObjectOutputStream(new FileOutputStream("./resources/ejemploObjeto3.data"));
            oos.writeObject(punto);

        } catch (IOException ex) {
            System.out.println("Error escribiendo objeto");
        } finally {
            if (oos != null) {
                try {
                    oos.close();
                } catch (IOException ex) {
                    System.out.println("Error cerrando escritura");
                }
            }
        }

        // Lectura del objeto
        ObjectInputStream ois = null;

        try {
            ois = new ObjectInputStream(new FileInputStream("ejemploObjeto3.data"));
            Punto lecturaPunto = (Punto) ois.readObject();
            System.out.println(lecturaPunto);

        } catch (FileNotFoundException ex) {
            System.out.println("Error en la lectura: no existe el fichero.");
        } catch (IOException ex) {
            System.out.println("Error en la lectura del objeto");
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en la lectura del objeto: clase no existe");
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    System.out.println("Error cerrando lectura");
                }
            }
        }// Fin del finally
    } // Fin del main
}