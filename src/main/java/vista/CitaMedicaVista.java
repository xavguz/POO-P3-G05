package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.CitaMedica;

public class CitaMedicaVista {

    public Scanner sc = new Scanner(System.in);

    public String tituloCita(){
        String tituloCita;
        do{
            System.out.println("Ingrese el Titulo de la cita:");
            tituloCita = sc.nextLine();
        }while(tituloCita.isEmpty());
        return tituloCita;
    }

    public String nombreMedico(){
        String nomreMedico;
        do{
            System.out.println("Ingrese el nombre del medico:");
            nomreMedico = sc.nextLine();
        }while(nomreMedico.isEmpty());
        return nomreMedico;
    }

    public void mostrarListaCitas(ArrayList<CitaMedica> listaCitas){
        if (listaCitas.isEmpty()){
            System.out.println("-------------------Lista de Citas Medicas-------------------");
            System.out.println("           No hay Citas Medicas en los registros");;
        }
        else{
            System.out.println("-------------------Lista de Citas Medicas-------------------");
            
            for(CitaMedica citaMedica:listaCitas){
                System.out.printf("- " + citaMedica + "\n");
            }
        }
        System.out.println("------------------------------------------------------------");
    }

    public int opcionesCita(){
        
        while(true) {
            System.out.println("1. Agregar Cita.\n" + //
                                "2. Volver.\n");
            try{
                return sc.nextInt();
            }catch(InputMismatchException e){
                System.out.println("Error : Ingrese un numero.");
                sc.nextLine();
            }
        }
    }


}
