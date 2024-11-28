package vista;

import java.util.Scanner;

public class FechaVista {
    
    Scanner sc = new Scanner(System.in);

    public String dia(){
        String dia;
        do{
            System.out.println("Ingrese el dia de la toma:");
            dia = sc.nextLine();
        }while(dia.isEmpty());
        return dia;  
    }

    public String hora(){
        String hora;
        do{
            System.out.println("Ingrese la hora de la toma:");
            hora = sc.nextLine();
        }while(hora.isEmpty());
        return hora;
    }
}
