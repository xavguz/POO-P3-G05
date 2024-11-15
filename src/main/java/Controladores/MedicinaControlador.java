package Controladores;

import java.util.ArrayList;
import java.util.Scanner;

public class MedicinaControlador {
    
    static Scanner sc = new Scanner(System.in);

    public static void añadirMedicina(){

        System.out.print("Nombre del Medicamento: ");
        String nombreMedicamento= sc.nextLine();

        System.out.print("Cantidad de unidades disponibles: ");
        int cantidadUnidades= sc.nextInt();
        sc.nextLine();
        
        System.out.println("\n1.Pastilla\r\n" + //
                        "2.Inyección\r\n" + //
                        "3.Solución\r\n" + //
                        "4.Gotas\r\n" + //
                        "5.Inhalador\r\n" + //
                        "6.Polvo\r\n" + //
                        "");

        System.out.print("Seleccione una opción de presentación: ");
        int presentacion= sc.nextInt();
        sc.nextLine();

        System.out.println("\nCada día\r\n" + //
                        "1.Cada dos días\r\n" + //
                        "2.Días específicos de la semana\r\n" + //
                        "3.Cada x días\r\n" + //
                        "4.Cada x semanas\r\n" + //
                        "5.Cada x meses\r\n" + //
                        "");
        System.out.print("\nIndique la frecuencia con la que debe tomar la medicina: ");
        int frecuencia= sc.nextInt();
        sc.nextLine();
        
        if (frecuencia==2){
            ArrayList<String> diaasSeleccionados=new ArrayList<String>();
            String dia=" ";
            System.out.println("\nLunes\r\n"+ "Martes\r\n"+"Miércoles\r\n"+"Jueves\r\n"+"Viernes\r\n"+"Sábado\r\n"+"Domingo\r\n");
            while(dia!=""){
                System.out.print("Seleccionar días(palabra): ");
                String dias= sc.nextLine();
                if (dias!=""){
                    diaasSeleccionados.add(dias);
                }
                dia=dias;
            }
        }
        else if (frecuencia==3){
            System.out.print("Cantidad de días: ");
            int dias= sc.nextInt();
        }
        else if (frecuencia==4){
            System.out.print("Cantidad de semanas: ");
            int semanas=sc.nextInt();
        }
        else if (frecuencia==5){
            System.out.print("Cantidad de meses: ");
            int meses= sc.nextInt();
        }

        System.out.println("\n1.Una vez al día\r\n" + //
                        "2.Dos veces al día\r\n" + //
                        "3.Tres veces al día\r\n" + //
                        "");
        System.out.print("Opción de tomar la medicina:");
        int frecuenciaDia= sc.nextInt();

        System.out.print("\nIngrese la cantidad de medicamento a tomar en cada ocasión: ");
        double dosis= sc.nextDouble();
    }
}
