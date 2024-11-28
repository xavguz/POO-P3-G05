package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.TomaMedicina;

public class TomaMedicinaVista {

    public Scanner sc = new Scanner(System.in);
    
    public String nombreMedicina(){
        String nombreMedicina;
        do{
            System.out.println("Ingrese la medicina a registrar la toma:");
             nombreMedicina = sc.nextLine();
        }while(nombreMedicina.isEmpty());
        return nombreMedicina;
    }


    public void mostrarListaTomas(ArrayList<TomaMedicina> listaTomas){
        if (listaTomas.isEmpty()){
            System.out.println("-----------------------Lista de Tomas-----------------------");
            System.out.println("                  No hay tomas registradas"); 
        }
        else{
            System.out.println("-----------------------Lista de Tomas-----------------------");
            for(TomaMedicina toma: listaTomas){
                System.out.printf("- " + toma + "\n");
            }
        }
        System.out.println("-----------------------------------------------------------");
    }

}
