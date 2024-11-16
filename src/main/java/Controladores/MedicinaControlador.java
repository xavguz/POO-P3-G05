package Controladores;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.enums.*;

public class MedicinaControlador {
    
    static Scanner sc = new Scanner(System.in);

    public static void añadirMedicina(){

        System.out.print("Nombre del Medicamento: ");
        String nombreMedicamento= sc.nextLine();

        System.out.print("Cantidad de unidades disponibles a consumir: ");
        int cantidadUnidades= sc.nextInt();
        sc.nextLine();
        
        System.out.println("Seleccione una opción de presentación (Ingrese un numero del 1 al 6):");
        for (Presentacion presentacion : Presentacion.values()) {
            System.out.println(presentacion);
        }
        int presentacion= sc.nextInt();
        sc.nextLine();

        System.out.println("Seleccione la frecuencia (Ingrese un numero del 1 al 6):");
        for (Frecuencia frecuencia : Frecuencia.values()) {
            System.out.println(frecuencia);
        }
        int frecuencia = sc.nextInt();
        sc.nextLine();
        
        if (frecuencia == 3){
            ArrayList<String> diasSeleccionados=new ArrayList<String>();
            int n = 0;

            for(Dias dia : Dias.values()) {
                System.out.println(dia);
            }
            
            while(n == 0){
                System.out.print("Seleccionar días (Ingrese uno por uno): ");
                String dias= sc.nextLine();
                if (dias!=""){
                    diasSeleccionados.add(dias);
                }
                else {
                    n += 1;
                }
            }
        }
        else if (frecuencia == 4){
            System.out.print("Cantidad de días: ");
            int dias= sc.nextInt();
        }
        else if (frecuencia == 5){
            System.out.print("Cantidad de semanas: ");
            int semanas=sc.nextInt();
        }
        else if (frecuencia == 6){
            System.out.print("Cantidad de meses: ");
            int meses= sc.nextInt();
        }


        System.out.println("Seleccione la frecuencia en el dia (Ingrese un numero del 1 al 4):");
        for (FrecuenciaDia frecuenciaDia : FrecuenciaDia.values()) {
            System.out.println(frecuenciaDia);
        }
        String frecuenciaDia = sc.nextLine();
        sc.nextLine();

        System.out.println("Ingrese la dosis a tomar de la medicina: ");
        String dosis = sc.nextLine();
        sc.nextLine();

    }
}
