package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.TomaMedicina;

public class TomaMedicinaVista {

    public Scanner sc = new Scanner(System.in);
    
    public void mostrarListaTomas(ArrayList<TomaMedicina> listaTomas){
        if (listaTomas.isEmpty()){
            System.out.println("-----------------------------------------------------------");
            System.out.println("                       Lista de Tomas                      ");
            System.out.println("-----------------------------------------------------------");
            System.out.println("- No hay tomas registradas.");
            System.out.println("-----------------------------------------------------------");
        }
        else{
            System.out.println("-----------------------------------------------------------");
            System.out.println("                       Lista de Tomas                      ");
            System.out.println("-----------------------------------------------------------");
            for(TomaMedicina toma: listaTomas){
                System.out.printf("- " + toma + "\n");
            }
            System.out.println("-----------------------------------------------------------");
        }
    }

}
