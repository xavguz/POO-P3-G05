package Controladores;
import modelo.cita.Medico;
import modelo.cita.enums.Especialidades;
import java.util.ArrayList;
import java.util.Scanner;

public class MedicoControlador {
    public static ArrayList<Medico> listaMedicos = new ArrayList<>();
    static Scanner sc= new Scanner(System.in);
    
    public static ArrayList<Medico> getListaMedicos() {
        return listaMedicos;
    }
    
    public static int OpcionesMedico(){
        int opcion;
        
        do {
            System.out.println("1. Añadir Médico.\n2. Volver.");
            opcion = sc.nextInt();
            sc.nextLine();
        }while(opcion == 1 && opcion == 2);
        return opcion;
    }

    public static void añadirMedico(){
        
        String nombreMedico;
        String especialidad;
        String numeroTelefono;
        String email;
        String direccion;
        int numero;

        System.out.println("Ingrese nombre: ");
        nombreMedico= sc.nextLine();

        numero = 1;
        for (Especialidades e:Especialidades.values() ){
            System.out.println(numero + ". " + e);
            numero++;
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
        listaMedicos.add(medico);

        System.out.println("Se ha añadido al Medico: " + medico);

    }

    public static void administrarMedico(){
        
        int contador = 0;
        while(contador == 0){
            
            System.out.println("---------------\nLista de Médicos\n---------------");
            for (Medico m: listaMedicos){
                System.out.println("- " + m);
            }

            int opcion = OpcionesMedico();
            switch (opcion) {
                case 1:
                    añadirMedico();
                    break;
            
                case 2:
                    contador++;
                    break;
            }
        }
        
    }  
}

