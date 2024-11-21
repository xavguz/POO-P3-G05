package Controladores;

import modelo.Fecha;
import modelo.cita.CitaMedica;
import modelo.cita.Medico;
import java.util.ArrayList;
import java.util.Scanner;

public class CitasMedicasControlador {
    public static ArrayList<CitaMedica> citas = new ArrayList<>();
    public static Scanner sc= new Scanner(System.in);

    public static void mostrarListaCitas(){
        if(citas.isEmpty()){
            System.out.println("--------------------------\n      Lista de Citas      \n--------------------------");
            System.out.println("- No hay citas pendientes.\n--------------------------");
        }
        else{
            System.out.println("--------------------------\n      Lista de Citas      \n--------------------------");
            for(CitaMedica cita : citas){
                System.out.println("- " + cita);
            }
            System.out.println("--------------------------");
        }
    }
    
    public static void agregarCitas(){
        String titulo;
        String dia;
        String hora;

        mostrarListaCitas();

        System.out.print("Ingrese el título de la cita: ");
        titulo = sc.nextLine();
        
        System.out.println("-------------------\n Lista de Médicos \n-------------------");
        for(Medico medico : MedicoControlador.getListaMedicos()){
            System.out.println("- " + medico.getNombre() + " / " +medico.getEspecialidades());
        }
        
        System.out.print("Elija un médico(nombre): ");
        String nombreMedico = sc.nextLine();
        
        for(Medico medico : MedicoControlador.getListaMedicos()){
            if (medico.getNombre().equalsIgnoreCase(nombreMedico)){
                System.out.println("Ingrese el dia de la cita: ");
                dia = sc.nextLine();
                System.out.println("Ingrese la hora de la cita: ");
                hora = sc.nextLine();

                Fecha fecha = new Fecha(dia,hora);
                CitaMedica cita = new CitaMedica(titulo, fecha, medico);
                citas.add(cita);
            }
            else{
                System.out.println("\nEl médico no esta en su registro. ");
            }
        }
    }

    public static int opcionesCita(){
        int opcion;
        
        do {
            System.out.println("1. Agregar Cita.\n" + //
                                "2. Volver.\n");
            opcion = sc.nextInt();
            sc.nextLine();
        }while(opcion == 1 && opcion == 2);
        return opcion;
    }

    public static void administrarCita(){
        int contador = 0;

        while (contador == 0){

            mostrarListaCitas();
            System.out.println("Escoja lo que desee hacer:");
            int opcion = opcionesCita();
            
            switch (opcion) {
                case 1:
                    agregarCitas();
                    break;
                case 2:
                    contador++;
                    break;
            }
        }
    }
}
