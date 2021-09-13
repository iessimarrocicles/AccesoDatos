package adt1_ejemplosObjetos3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Date;

public class Punto implements Serializable {

    int x;
    int y;
    transient Date fecha;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
        this.fecha = new Date();
    }

    public String toString() {
        return "Punto[" + x + ", " + y + "]; " + fecha;
    }

    private void readObject(ObjectInputStream entrada) throws IOException, ClassNotFoundException {
        entrada.defaultReadObject();
        fecha = new Date();
    }
}
