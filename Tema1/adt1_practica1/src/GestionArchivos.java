import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 *
 * @author Enric
 */
public class GestionArchivos {

    private String rutaTrabajo;
    private String nuevaCarpeta;
    private String nombreArchivo;

    public GestionArchivos() {
        // Obtener la ruta inicial por defecto a C:\ o /
        rutaTrabajo = File.listRoots()[0].toString();
        nuevaCarpeta = "";
        nombreArchivo = "";
    }

    public String getRutaTrabajo() {
        return rutaTrabajo;
    }

    public void setRutaTrabajo(String rutaTrabajo1) {
        this.rutaTrabajo = rutaTrabajo1;
    }

    public String getNuevaCarpeta() {
        return nuevaCarpeta;
    }

    public void setNuevaCarpeta(String novaCarpeta) {
        this.nuevaCarpeta = novaCarpeta;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public void listarRutaTrabajo() {

        File ruta = new File(rutaTrabajo);
        File[] listaFicheros = ruta.listFiles();

        for (File contenido : listaFicheros) {
            if (contenido.isDirectory()) {
                System.out.println("(d): " + contenido);
            } else {
                System.out.println("(f): " + contenido);
            }
        }
    }

    public String informacionDetallada() {

        StringBuilder strBuilder = new StringBuilder();
        File file = new File(rutaTrabajo, nombreArchivo);
        //Es controla que existeixi l'element a analitzar
        if (!file.exists()) {
            System.out.println("Error. No es pot obtenir información de " + nombreArchivo + ", no existeix.");
            return "";
        }
        //es controla que es tinguin permisos per llegir la carpeta
        if (!file.canRead()) {
            System.out.println("Alerta. No es pot  accedir a " + nombreArchivo + ". No teniu prou permisos");
             return "";
        }
        //S'escriu el títol
        strBuilder.append("INFORMACIóN DEL SISTEMA");
        strBuilder.append("\n\n");
        //S'afegeix el nom
        strBuilder.append("Nombre: ");
        strBuilder.append(nombreArchivo);
        strBuilder.append("\n");
        //El tipus (carpeta o fitxer)
        strBuilder.append("Tipo: ");
        if (file.isFile()) {
            //es fitxer
            strBuilder.append("fichero");
            strBuilder.append("\n");
            //s'escriu La mida
            strBuilder.append("Longitud: ");
            strBuilder.append(file.length());
            strBuilder.append("\n");
        } else {
            //es carpeta
            strBuilder.append("carpeta");
            strBuilder.append("\n");
            //S'indica el nombre d'elements continguts
            strBuilder.append("Contenido: ");
            strBuilder.append(file.list().length);
            strBuilder.append(" entradas\n");
        }
        //Afegim la ubicació
        strBuilder.append("Ubicación: ");
        /* Cal posar el try per exigencies del llenguatge, però no controlarem
         * aquest error doncs sabem que mai es produirà. Si hem arribat fins aquí és
         * que l'adreça és bona*/
        try {
            strBuilder.append(file.getCanonicalPath());
        } catch (IOException ex) {/*Mai es produirà aquest error*/

        }
        strBuilder.append("\n");
        //Afegim la data de la última modificació
        strBuilder.append("Última modificación: ");
        Date date = new Date(file.lastModified());
        strBuilder.append(date.toString());
        strBuilder.append("\n");
        //Indiquem si és o  no un fitxer ocult
        strBuilder.append("Oculto: ");
        strBuilder.append((file.isHidden()) ? "Si" : "No");
        strBuilder.append("\n");

        if (file.isDirectory()) {
            //Mostrem l'espai lliure
            strBuilder.append("Espacio libre: ");
            strBuilder.append(file.getFreeSpace());
            strBuilder.append("\n");
            //Mostrem l'espai disponible
            strBuilder.append("Espacio disponible: ");
            strBuilder.append(file.getUsableSpace());
            strBuilder.append("\n");
            //Mostrem l'espai total
            strBuilder.append("Espacio total: ");
            strBuilder.append(file.getTotalSpace());
            strBuilder.append("\n");
        }

        return strBuilder.toString();
    }

    public void creaCarpeta() {
       File carpetaDeTreball = new File(rutaTrabajo);
        File file = new File(carpetaDeTreball, nuevaCarpeta);

        if (!carpetaDeTreball.canWrite()) {
            System.out.println("Error. No s'ha pogut crear " + nuevaCarpeta
                    + ". No teniu suficients permisos");
            return;
        }
        if (file.exists()) {
            System.out.println("Error. No s'ha pogut crear. Ja existeix un "
                    + "fitxer o caprpeta amb el nom " + nuevaCarpeta);
            return;
        }

        if (!file.mkdir()) {
            System.out.println("Error. No s'ha pogut crear " + nuevaCarpeta + ".");
        }
    }

    public void creaFitxer() {

        File carpetaDeTreball = new File(rutaTrabajo);
        File file = new File(carpetaDeTreball, nombreArchivo);

        if (!carpetaDeTreball.canWrite()) {
            System.out.println("Error. No s'ha pogut crear " + nombreArchivo
                    + ". No teniu suficients permisos");
            return;
        }
        if (file.exists()) {
            System.out.println("Error. No s'ha pogut crear. Ja exiteix un "
                    + "fitxer o caprpeta amb el nom " + nombreArchivo);
            return;
        }
        try {
            if (!file.createNewFile()) {
                System.out.println("Error. No s'ha pogut crear " + nombreArchivo + ".");
            }
        } catch (IOException ex) {
            System.out.println("S'ha produit un error d'entrada o sortida: "
                    + ex.getMessage());
        }
    }

    public void eliminaFitxer() {

        File carpetaDeTreball = new File(rutaTrabajo);
        File file = new File(carpetaDeTreball, nombreArchivo);

        if (!file.exists()) {
            System.out.println("Error. No s'ha pogut eliminar però no existeix "
                    + "un fitxer amb el nom " + nombreArchivo);
            return;
        }

        if (!file.canWrite()) {
            System.out.println("Error. No s'ha pogut eliminar " + nombreArchivo
                    + ". No teniu suficients permisos");
            return;
        }

        if (!file.delete()) {
            System.out.println("Error. No s'ha pogut eliminar " + nombreArchivo + ".");
        }else{
            System.out.println("Fichero eliminado.");
        }

    }

}