package adt1_ejemplos;

import java.io.File;

public class App0 {
    
    public static void main(String[] args) {

        File f = new File("./resources/file.txt");
        if (f.exists()) {
            System.out.println("El fichero existe!");
        } else {
            System.err.println("El fichero NO existe!");
        }

        System.out.println("getName(): " + f.getName());
        System.out.println("getParent(): " + f.getParent());
        System.out.println("length(): " + f.length());

    }
}

