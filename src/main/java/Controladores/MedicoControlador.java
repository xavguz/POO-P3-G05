package Controladores;
import java.util.Scanner;

public class MedicoControlador {
    static Scanner sc= new Scanner(System.in);
    
    public static void AñadirMedico(){
        
        System.out.print("Ingrese nombre: ");
        String nombre_Medico= sc.nextLine();

        System.err.println(" \nMedicina General\r\n" + //
                        "Cardiologia\r\n" + //
                        "Dermatologia\r\n" + //
                        "Endocrinologia\r\n" + //
                        "Gastroenterologia\r\n" + //
                        "Geriatria\r\n" + //
                        "Neurologia\r\n" + //
                        "Pediatria\r\n" + //
                        "Psiquiatria\r\n" + //
                        "Traumatologia");
        System.err.print("Ingrese Especialidad: ");
        String Especialidad= sc.nextLine();

        boolean conf_telefono= true;
        while (conf_telefono){
            System.out.print("Ingrese teléfono: ");
            String TelefonoMedico= sc.nextLine();
            if (TelefonoMedico.length()==10){
                conf_telefono= false;
            }
         }
        System.out.print("Ingrese correo: ");
        String email= sc.nextLine();

        System.out.print("Ingrese dirección: ");
        String direccion= sc.nextLine();

        
    }    
}
