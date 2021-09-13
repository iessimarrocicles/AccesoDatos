package adt1_ejemplosObjetos2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

public class Punto implements Serializable {

    int x;
    int y;
    Date fecha;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
        this.fecha = new Date();
    }

    public String toString() {
        return "Punto[" + x + ", " + y + "]; " + fecha;
    }

    private void writeObjet(ObjectOutputStream salida) {
        try {
            salida.writeInt(x);
            salida.writeInt(y);
        } catch (IOException ex) {
            System.out.println("Error al escribir el objeto.");
        }
        
    }

    private void readObject(ObjectInputStream entrada) {
        
        try {
            x = entrada.readInt();
            y = entrada.readInt();
        } catch (IOException ex) {
            System.out.println("Error al leer el objeto: " + ex.toString());
        }
        //entrada.defaultReadObject();
        
        fecha = new Date();
    }
}
