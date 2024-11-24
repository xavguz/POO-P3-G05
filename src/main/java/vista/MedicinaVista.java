package vista;

import java.util.Scanner;
import java.util.ArrayList;
import modelo.medicina.Medicina;

public class MedicinaVista {
    
    public Scanner sc = new Scanner(System.in);
    
    public void mostrarListaMedicinas(ArrayList<Medicina> listaMedicinas){

        if (listaMedicinas.isEmpty()){
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("                                  Lista de Medicinas                                  ");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("NOMBRE / INVENTARIO / PRESENTACION / FRECUENCIA / FRECUENCIA_EN_EL_DIA [HORA] / DOSIS ");
            System.out.println("- No hay medicinas.");
            System.out.println("--------------------------------------------------------------------------------------");
        }
        else{
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("                                  Lista de Medicinas                                  ");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("NOMBRE / INVENTARIO / PRESENTACION / FRECUENCIA / FRECUENCIA_EN_EL_DIA [HORA] / DOSIS ");
            for(Medicina medicina: listaMedicinas){
                System.out.printf("- " + medicina + "\n");
            }
            System.out.println("--------------------------------------------------------------------------------------");
        }
    }
}
