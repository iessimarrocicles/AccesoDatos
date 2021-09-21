import java.util.Scanner;

/**
 *
 * @author Enric
 */
public class App {

    public static void menu() {
        System.out.println("\n");
        System.out.println("================================================");
        System.out.println("===================== MENÚ =====================");
        System.out.println("1.- Asignar nueva ruta de trabajo.");
        System.out.println("2.- Listado de la ruta de trabajo.");
        System.out.println("3.- Información detallada de un archivo.");
        System.out.println("4.- Creación de un directorio.");
        System.out.println("5.- Creación de un fichero.");
        System.out.println("6.- Eliminación de un fichero.");
        System.out.println("7.- Salir.");
        System.out.println("================================================");
        System.out.println("================================================");
        System.out.print("Opción? ");

    }

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        boolean salir = false;

        GestionArchivos ga = new GestionArchivos();

        while (!salir) {

            menu();
            String opcion = in.nextLine();

            switch (opcion) {
                case "1":
                    System.out.print("\t1.- Asignar nueva ruta de trabajo: ");
                    ga.setRutaTrabajo(in.nextLine());
                    break;
                case "2":
                    System.out.print("\t2.- Listando... " + ga.getRutaTrabajo() + "\n");
                    ga.listarRutaTrabajo();
                    break;

                case "3":
                    System.out.print("\t3.- Archivo sobre el que quieres información: ");
                    ga.setNombreArchivo(in.nextLine());

                    System.out.println(ga.informacionDetallada());
                    break;

                case "4":
                    System.out.print("\t4.- Directorio que quieres crear: ");
                    ga.setNuevaCarpeta(in.nextLine());
                    ga.creaCarpeta();
                    break;

                case "5":
                    System.out.print("\t5.- Fichero que quieres crear: ");
                    ga.setNombreArchivo(in.nextLine());
                    ga.creaFitxer();
                    break;

                case "6":

                    System.out.print("\t6.- Fichero que quieres eliminar: ");
                    ga.setNombreArchivo(in.nextLine());
                    ga.eliminaFitxer();
                    break;
                    

                case "7":
                    System.out.println("Has salido de la aplicación.");
                    salir = true;
                    break;
            } // Fin del swicth

        } // Fin del while

        in.close();
        
    }// Fin del main

}// Fin class
