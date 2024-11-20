package Controladores;

import modelo.Fecha;
import java.util.Scanner;
import java.util.ArrayList;
import modelo.medicina.Medicina;
import modelo.medicina.TomaMedicina;

public class TomaMedicinaControlador {
    static Scanner sc = new Scanner(System.in);
    static ArrayList <TomaMedicina> listaTomas = new ArrayList<>();

    public static void registrarToma(){
        MedicinaControlador.mostrarListaMedicamento();
        System.out.println("Seleccione un medicamento a registrar toma: ");
        String seleccionMedicamento = sc.nextLine();
        for (Medicina medicina:MedicinaControlador.getListaMedicinas()){
            if (medicina.getNombreMedicamento().equalsIgnoreCase(seleccionMedicamento)){
                String dia;
                String hora;

                System.out.println("Ingrese el dia de la toma: ");
                dia = sc.nextLine();
                System.out.println("Ingrese la hora de la toma (hh:mm): ");
                hora = sc.nextLine();

                Fecha fecha = new Fecha(dia,hora);
                TomaMedicina toma = new TomaMedicina(medicina, fecha);
                listaTomas.add(toma);
                
                System.out.println("Se ha registrado la toma de [ " + seleccionMedicamento + " ].");
            }
            else{
                System.out.println("No esta el medicamento en los registros.");
            }
        }
    }
}
