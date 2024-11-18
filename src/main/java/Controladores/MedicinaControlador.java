package Controladores;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.enums.*;
import modelo.medicina.*;

public class MedicinaControlador {
    public static ArrayList <Medicina> listaMedicinas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void añadirMedicina(){

        String nombreMedicamento;
        float cantidadUnidades;
        String presentacion;
        String frecuencia;
        String frecuenciaDia;
        float dosis;
        int opcion;
        ArrayList<String> diasSeleccionados = new ArrayList<String>();
        int variable;

        System.out.print("Nombre del Medicamento: ");
        nombreMedicamento = sc.nextLine();

        System.out.print("Cantidad de unidades disponibles a consumir: ");
        cantidadUnidades= sc.nextFloat();
        
        System.out.println("Seleccione una opción de presentación (Ingrese un numero del 1 al 6):");
        variable = 1;
        for (Presentacion p : Presentacion.values()) {
            System.out.println(variable + ". " + p);
            variable++;
        }
        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                presentacion = Presentacion.PASTILLA.name();
                break;
            case 2:
                presentacion = Presentacion.INYECCION.name();
                break;
            case 3:
                presentacion = Presentacion.SOLUCION.name();
                break;
            case 4:
                presentacion = Presentacion.GOTAS.name();
                break;
            case 5:
                presentacion = Presentacion.INHALADOR.name();
                break;
            case 6:
                presentacion = Presentacion.POLVO.name();
                break;
            default:
                presentacion = null;
                break;

        }

        System.out.println("Seleccione la frecuencia (Ingrese un numero del 1 al 6):");
        variable = 1;
        for (Frecuencia f : Frecuencia.values()) {
            System.out.println(variable + ". "+f);
            variable++;
        }

        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                frecuencia = Frecuencia.CADA_DIA.name();
                break;
            case 2:
                frecuencia = Frecuencia.CADA_DOS_DIAS.name();
                break;
            case 3:
                int n = 0;
                variable = 1;
                for(Dias dia : Dias.values()) {
                    System.out.println(variable + ". " +dia);
                    variable++;
                }

                while(n == 0) {
                    System.out.print("Seleccionar los días (Ingrese uno por uno): ");
                    String dias= sc.nextLine();
                    if (!dias.isEmpty()){
                        diasSeleccionados.add(dias);
                    }
                    else {
                        n += 1;
                    }
                }
                frecuencia = String.join(",", diasSeleccionados);
                break;
            case 4:
                System.out.println("Cantidad de días: ");
                String dias = sc.nextLine();
                frecuencia = "CADA_" + dias + "_DIAS";
                break;
            case 5:
                System.out.println("Cantidad de semanas: ");
                String semanas = sc.nextLine();
                frecuencia = "CADA_" + semanas + "_SEMANAS";
                break;
            case 6:
                System.out.println("Cantidad de meses: ");
                String meses = sc.nextLine();
                frecuencia = "CADA_" + meses + "_DIAS";
                break;
            default:
                frecuencia = null;
        }

        System.out.println("Seleccione la frecuencia en el dia (Ingrese un numero del 1 al 4):");
        variable = 1;
        for (FrecuenciaDia fDia : FrecuenciaDia.values()) {
            System.out.println(variable + ". " + fDia);
            variable++;
        }
        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                frecuenciaDia = FrecuenciaDia.UNA_VEZ_AL_DIA.name();
                break;
            case 2:
                frecuenciaDia = FrecuenciaDia.DOS_VECES_AL_DIA.name();
                break;
            case 3:
                frecuenciaDia = FrecuenciaDia.TRES_VECES_AL_DIA.name();
                break;
            case 4:
                System.out.println("Ingrese la hora para cada toma(Formato 24 horas):"); 
                frecuenciaDia = sc.nextLine();
                break;
            default:
                frecuenciaDia = null;
        }

        System.out.println("Ingrese la dosis a tomar de la medicina (gramos): ");
        dosis = sc.nextFloat();

        Medicina medicina = new Medicina(nombreMedicamento, cantidadUnidades,
                presentacion, frecuencia, frecuenciaDia, dosis);
        System.out.println("Se añadio la medicina " + medicina);
    }
}
