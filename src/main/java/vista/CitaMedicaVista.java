package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.CitaMedicaModelo;

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
        String nombreMedico;
        do{
            System.out.println("Ingrese el nombre del medico:");
            nombreMedico = sc.nextLine();
        }while(nombreMedico.isEmpty());
        return nombreMedico;
    }

    public String diaCita(){
        String dia;
        do{
            System.out.println("Ingrese la fecha de la cita (DD/MM/AA)");

            System.out.println("Ingrese el dia de la cita (DD): ");
            dia = sc.nextLine();

        }while(dia.isEmpty());
        return dia;
    }

    public String mesCita(){
        String mes;
        do {
            System.out.println("Ingrese el mes de la cita (MM): ");
            mes = sc.nextLine();
        } while (mes.isEmpty());
        return mes;
    }

    public String añoCita(){
        String año;
        do {
            System.out.println("Ingrese el año de la cita (AA): ");
            año = sc.nextLine();
        } while (año.isEmpty());
        return año;
    }

    public String horaCita(){
        String horaCita;
        do{
            System.out.println("Ingrese la hora de la cita (HH:MM):");
            horaCita = sc.nextLine();
        }while(horaCita.isEmpty());
        return horaCita;
    }

    public void mostrarListaCitas(ArrayList<CitaMedicaModelo> listaCitas){

        if (listaCitas.isEmpty()){
            System.out.println("-------------------Lista de Citas Medicas-------------------");
            System.out.println("           No hay Citas Medicas en los registros");
        }
        else{
            System.out.println("-------------------Lista de Citas Medicas-------------------");
            
            for(CitaMedicaModelo citaMedica:listaCitas){
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
