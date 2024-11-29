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
        int contador = 1;
        while (true){
            System.out.println("Seleccion el dia de la Toma (1-7): ");
            for(Dias dia : Dias.values()) {
                System.out.println(contador + ". " +dia);
                contador++;
            }
            try {
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion){
                    case 1:
                        return Dias.Lunes.name();
                    case 2:
                        return Dias.Martes.name();
                    case 3:
                        return Dias.Miercoles.name();
                    case 4:
                        return Dias.Jueves.name();
                    case 5:
                        return Dias.Viernes.name();
                    case 6:
                        return Dias.Sabado.name();
                    case 7:
                        return Dias.Domingo.name();
                    default:
                        System.out.println("Error: Por favor, ingresa un valor numérico válido entre 1 y 7.");

                }
            } catch (InputMismatchException e){
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }

    public String horaToma(){
        String horaToma;
        do{
            System.out.println("Ingrese la hora de la Toma (hh:mm): ");
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
