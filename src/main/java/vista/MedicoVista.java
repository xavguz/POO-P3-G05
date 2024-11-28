package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.Medico;
import modelo.enums.Especialidades;

public class MedicoVista {

    public Scanner sc = new Scanner(System.in);

    public void mostrarListaMedicos(ArrayList<Medico> listaMedicos){
        System.out.println("-- Lista de Medicos --");
        if (listaMedicos.isEmpty()){
            System.out.println("  - No hay Medicos");
        }
        else{
            for(Medico medico:listaMedicos){
                System.out.printf("- " + medico + "\n");
            }
        }
        System.out.println("-----------------------");
    }

    public String nombreMedico(){
        String nombreMedico;
        do {
            System.out.println("Ingresar nombre: ");
            nombreMedico = sc.nextLine();
        } while (nombreMedico.isEmpty());
        return nombreMedico;
    }

    public String especialidadMedico() {
        while (true) {
            System.out.println("Ingrese Especialidad (numero del 1 al 10): ");
            int contador = 1;
            for (Especialidades especialidad : Especialidades.values()){
                System.out.println(contador + ". " +especialidad);
                contador++;
            }
            try {
                int opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion){
                    case 1:
                        return Especialidades.MEDICINA_GENERAL.name();
                    case 2:
                        return Especialidades.CARDIOLOGIA.name();
                    case 3:
                        return Especialidades.DERMATOLOGIA.name();
                    case 4:
                        return Especialidades.ENDOCRINOLOGIA.name();
                    case 5:
                        return Especialidades.GASTROENTEROLOGIA.name();
                    case 6:
                        return Especialidades.GERIATRIA.name();
                    case 7:
                        return Especialidades.NEUROLOGIA.name();
                    case 8:
                        return Especialidades.PEDIATRIA.name();
                    case 9:
                        return Especialidades.PSIQUIATRIA.name();
                    case 10:
                        return Especialidades.TRAUMATOLOGIA.name();
                    default:
                        System.out.println("Error: Por favor, ingresa un valor numérico válido entre 1 y 10.");
                    }
                } catch (InputMismatchException e){
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }

    public String telefonoMedico(){
        String numeroTelefono;
        do {
            System.out.print("Ingrese teléfono: ");
            numeroTelefono = sc.nextLine();
        }  while (numeroTelefono.isEmpty());
        return numeroTelefono;
    }

    public String correoMedico(){
        String correo;
        do {
            System.out.print("Ingrese correo medico: ");
            correo = sc.nextLine();
        }  while (correo.isEmpty());
        return correo;
    }

    public String direccionMedico(){
        String direccion;
        do {
            System.out.print("Ingrese direccion medico: ");
            direccion = sc.nextLine();
        }  while (direccion.isEmpty());
        return direccion;
    }

    public int opcionesMedico(){
        while (true) {
            System.out.println("1. Añadir Médico.\n2. Volver.");
            try{
                return sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }
}
