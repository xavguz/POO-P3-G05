package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.actividadfisica.ActividadFisica;


public class ActividadFisicaVista {

    public Scanner sc = new Scanner(System.in);

    public void mostrarListaActividades(ArrayList<ActividadFisica> listaActividades){
        if (listaActividades.isEmpty()){
            System.out.println("------------------------------------------------------------");
            System.out.println("                Lista de Actividades Físicas                ");
            System.out.println("------------------------------------------------------------");
            System.out.println("- No hay Actividades Físicas en los registros.");
            System.out.println("------------------------------------------------------------");
        }
        else{
            System.out.println("------------------------------------------------------------");
            System.out.println("                Lista de Actividades Físicas                ");
            System.out.println("------------------------------------------------------------");
            for(ActividadFisica actividadFisica:listaActividades){
                System.out.printf("- " + actividadFisica + "\n");
            }
            System.out.println("------------------------------------------------------------");
        }
    }
}
