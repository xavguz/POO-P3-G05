package Controladores;

import modelo.Fecha;
import modelo.cita.CitaMedica;
import modelo.cita.Medico;
import java.util.ArrayList;
import java.util.Scanner;

public class CitasMedicasControlador {
    public static ArrayList<CitaMedica> citas = new ArrayList<>();
    public static Scanner sc= new Scanner(System.in);

    public static void agregarCitas(){
        String titulo;
        String dia;
        String hora;

        System.out.println("--------------\nLista de Citas\n--------------");
        for(CitaMedica cita : citas){
            System.out.println("- " + cita);
        }
        System.out.print("Ingrese el título de la cita: ");
        titulo = sc.nextLine();
        
        System.out.println("---------------\nLista de Médicos\n---------------");
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
}
