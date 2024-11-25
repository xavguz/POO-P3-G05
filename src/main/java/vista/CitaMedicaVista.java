package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.CitaMedica;

public class CitaMedicaVista {

    public Scanner sc = new Scanner(System.in);

    public void mostrarListaCitas(ArrayList<CitaMedica> listaCitas){
        if (listaCitas.isEmpty()){
            System.out.println("------------------------------------------------------------");
            System.out.println("                   Lista de Citas Medicas                   ");
            System.out.println("------------------------------------------------------------");
            System.out.println("- No hay Citas Medicas en los registros.");
            System.out.println("------------------------------------------------------------");
        }
        else{
            System.out.println("------------------------------------------------------------");
            System.out.println("                   Lista de Citas Medicas                   ");
            System.out.println("------------------------------------------------------------");
            for(CitaMedica citaMedica:listaCitas){
                System.out.printf("- " + citaMedica + "\n");
            }
            System.out.println("------------------------------------------------------------");
        }
    }

}
