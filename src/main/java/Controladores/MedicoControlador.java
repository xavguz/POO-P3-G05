package Controladores;
import modelo.cita.Medico;
import modelo.cita.enums.Especialidades;
import java.util.ArrayList;
import java.util.Scanner;

public class MedicoControlador {
    public static ArrayList<Medico> medicoRegistrado = new ArrayList<>();
    static Scanner sc= new Scanner(System.in);
    
    public static void AñadirMedico(){
        
        String nombreMedico;
        String especialidad;
        String numeroTelefono;
        String email;
        String direccion;

        System.out.print("Ingrese nombre: ");
        nombreMedico= sc.nextLine();
        System.out.println("\n");

        for (Especialidades e:Especialidades.values() ){
            System.out.println(e);
        }
        System.out.print("Ingrese Especialidad (numero del 1 al 10): ");
        int opcion= sc.nextInt();
       
        switch (opcion){
            case 1:
            especialidad= Especialidades.MEDICINA_GENERAL.name();
            break;
            case 2:
            especialidad= Especialidades.CARDIOLOGIA.name();
            break;
            case 3:
            especialidad= Especialidades.DERMATOLOGIA.name();
            break;
            case 4:
            especialidad= Especialidades.ENDOCRINOLOGIA.name();
            break;
            case 5:
            especialidad= Especialidades.GASTROENTEROLOGIA.name();
            break;
            case 6:
            especialidad= Especialidades.GERIATRIA.name();
            break;
            case 7:
            especialidad= Especialidades.NEUROLOGIA.name();
            break;
            case 8:
            especialidad= Especialidades.PEDIATRIA.name();
            break;
            case 9:
            especialidad= Especialidades.PSIQUIATRIA.name();
            break;
            default:
            especialidad= Especialidades.TRAUMATOLOGIA.name();
            break;
        }

        sc.nextLine();
   
        System.out.print("Ingrese teléfono: ");
        numeroTelefono= sc.nextLine();
            
        System.out.print("Ingrese correo: ");
        email= sc.nextLine();

        System.out.print("Ingrese dirección: ");
        direccion= sc.nextLine();

        Medico medico = new Medico(nombreMedico, especialidad, numeroTelefono, email, direccion);
        medicoRegistrado.add(medico);

        System.out.println("Se ha añadido al Medico: " + medico.getNombre());

    }

    public static void mostrarMedicos() {
        if (medicoRegistrado.isEmpty()) {
            System.out.println("No hay médicos registrados.\n");
        } else {
            System.out.println("Lista de Médicos Registrados:");
            for (Medico medico : medicoRegistrado) {
                Medico med= medico;
                System.out.println("-Nombre: "+med.getNombre()+", Especialidad: "+med.getEspecialidades()+", Contacto: "+med.getTelefono());
            }
        }
    }
}
