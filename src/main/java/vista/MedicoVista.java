package vista;

import java.util.ArrayList;
import java.util.Scanner;

import modelo.Medico;

public class MedicoVista {

    public Scanner sc = new Scanner(System.in);

    public void mostrarListaMedicos(ArrayList<Medico> listaMedicos){
        if (listaMedicos.isEmpty()){
            System.out.println("-----------------------------------------------------------");
            System.out.println("                     Lista de Médicos                     ");
            System.out.println("-----------------------------------------------------------");
            System.out.println("- No hay Perfiles.");
            System.out.println("-----------------------------------------------------------");
        }
        else{
            System.out.println("----------------------------------------------------------");
            System.out.println("                     Lista de Médicos                     ");
            System.out.println("----------------------------------------------------------");
            for(Medico medico:listaMedicos){
                System.out.printf("- " + medico + "\n");
            }
            System.out.println("-----------------------------------------------------------");
        }
    }
}
