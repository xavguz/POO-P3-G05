package Controladores;
import modelo.cita.CitaMedica;
import modelo.cita.Medico;
import java.util.ArrayList;
import java.util.Scanner;

public class CitasMedicasControlador {
    public static ArrayList<CitaMedica> Citas= new ArrayList<>();
    public static Scanner sc= new Scanner(System.in);

    public static void agregarCitas(){
        String titulo;
        Medico doctor;
        System.out.print("Ingrese el título de la cita: ");
        titulo = sc.nextLine();
        
        for(int i=0; i<MedicoControlador.listaMedicos.size();i++){
            System.out.println((i+1)+". "+ (MedicoControlador.listaMedicos.get(i)).getNombre());
        }
        
        System.out.print("Elija un medico: ");

    }
}
