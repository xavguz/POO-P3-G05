package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.TomaMedicina;
import modelo.enums.Dias;

public class TomaMedicinaVista {

    public Scanner sc = new Scanner(System.in);
    
    public String nombreMedicina(){
        String nombreMedicina;
        do{
            System.out.println("Ingrese la medicina a registrar la toma: ");
            nombreMedicina = sc.nextLine();
        }while(nombreMedicina.isEmpty());
        return nombreMedicina;
    }

    public String diaToma(){
        String dia;
        do{
            System.out.println("Ingrese la fecha de la Toma (DD/MM/AA)");

            System.out.println("Ingrese el dia de la Toma (DD): ");
            dia = sc.nextLine();

        }while(dia.isEmpty());
        return dia;
    }

    public String mesToma(){
        String mes;
        do {
            System.out.println("Ingrese el mes de la Toma (MM): ");
            mes = sc.nextLine();
        } while (mes.isEmpty());
        return mes;
    }

    public String añoToma(){
        String año;
        do {
            System.out.println("Ingrese el año de la Toma (AA): ");
            año = sc.nextLine();
        } while (año.isEmpty());
        return año;
    }

    public String horaToma(){
        String horaToma;
        do{
            System.out.println("Ingrese la hora de la Toma (HH:MM): ");
            horaToma = sc.nextLine();
        }while(horaToma.isEmpty());
        return horaToma;
    }

    public void mostrarListaTomas(ArrayList<TomaMedicina> listaTomas){
        System.out.println("-----------------------Registro de Tomas-----------------------");
        if (listaTomas.isEmpty()){
            System.out.println("                  No hay tomas registradas"); 
        }
        else{
            for(TomaMedicina toma: listaTomas){
                System.out.printf("- " + toma + "\n");
            }
        }
        System.out.println("-----------------------------------------------------------");
    }

    public int opcionesTomaMedicina(){
        while (true) {
            System.out.println("1. Añadir Toma.\n2. Volver.");
            try{
                return sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }

}
