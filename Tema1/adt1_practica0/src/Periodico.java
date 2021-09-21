import java.util.ArrayList;

public class Periodico {
    public static final int NUM_NOT = 1000;
    private ArrayList<Noticia> noticias;
    private int numNoticias;

    public Periodico() {
        noticias = new ArrayList<Noticia>();
        numNoticias = 0;
    }

    public void insertar(Noticia n) {
        if (numNoticias != NUM_NOT) {
            noticias.add(n);
            numNoticias++;
        }
    }

    public Noticia primeraNoticia(int d, int m, int a) {
        int i = 0;
        while (i < numNoticias && !noticias.get(i).igualFecha(d, m, a)) {
            i++;
        }
        if (i < numNoticias) {
            return noticias.get(i);
        } else {
            return null;
        }
    }

    public void masPopulars() {
        if (numNoticias == 0) {
            System.out.println("Sin noticias.");
        } else {
            Noticia mesP = noticias.get(0);
            int indMesP = 0;
            for (int i = 1; i < numNoticias; i++) {
                if (noticias.get(i).getLecturas() > mesP.getLecturas()) {
                    mesP = noticias.get(i);
                    indMesP = i;
                }
            }

            System.out.println(mesP);

            for (int j = indMesP + 1; j < numNoticias; j++) {
                if (noticias.get(j).getLecturas() == mesP.getLecturas()) {
                    System.out.println(noticias.get(j));
                }
            }
        } // Fin del else
    }

    public void esborrarAnteriors(int d, int m, int a) {

        int fecha = a * 10000 + m * 100 + d;

        for (int i = 0; i < numNoticias; i++) {
            if (noticias.get(i).getFecha() < fecha) {
                noticias.remove(i);
                numNoticias--;
            }
        }
    }

    public void mostrar() {
        for (Noticia nn : noticias) {
            System.out.println(nn);
        }
    }
}
