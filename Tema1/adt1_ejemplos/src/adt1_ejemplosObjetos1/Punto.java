package adt1_ejemplosObjetos1;

import java.io.Serializable;

public class Punto implements Serializable {

    int x;
    int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String toString() {
        return "Punto[" + x + ", " + y + "]";
    }

}
