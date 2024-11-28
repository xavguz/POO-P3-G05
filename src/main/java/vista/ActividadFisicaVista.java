package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.ActividadFisica;


public class ActividadFisicaVista {

    public Scanner sc = new Scanner(System.in);

    public void mostrarListaActividades(ArrayList<ActividadFisica> listaActividades){
        System.out.println("----------------Lista de Actividades Físicas----------------");
        if (listaActividades.isEmpty()){
            System.out.println("- No hay Actividades Físicas en los registros.");
        }
        else{
            for(ActividadFisica actividadFisica:listaActividades){
                System.out.printf("- " + actividadFisica + "\n");
            }
        }
        System.out.println("------------------------------------------------------------");
    }
}
