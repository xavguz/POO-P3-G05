package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Perfil;

public class PerfilVista {

    public Scanner sc = new Scanner(System.in);

    public String ingresarNombre(){
        String nombrePerfil;
        do {
            System.out.println("Ingresar nombre: ");
            nombrePerfil = sc.nextLine();
        } while (nombrePerfil.isEmpty());
        return nombrePerfil;
    }

    public String ingresarRelacion(){
        String relacion;
        do {
            System.out.println("Ingresar relacion: ");
            relacion = sc.nextLine();
        } while (relacion.isEmpty());
        return relacion;
    }

    public String ingresarEmail(){
        System.out.println("Ingresar email (No obligatorio): ");
        return sc.nextLine();
    }

    public void mostrarListaPerfiles(ArrayList<Perfil> listaPerfiles){
        System.out.println("-- Lista de perfiles --");
        if (listaPerfiles.isEmpty()){
            System.out.println("  - No hay perfiles");
        } else {
            for (Perfil perfil: listaPerfiles){
                System.out.println("- " + perfil.getNombre() + " (" +perfil.getRelacion() + ")");
            }
        }
        System.out.println("-----------------------");

    }

    public int opcionesAdministrar(){
        int opcion = -1;
        do {
            try{
                System.out.println("1. Administrar Medicamentos.\n" + //
                                    "2. Administrar Médicos.\n" + //
                                    "3. Administrar Citas Médicas.\n" + //
                                    "4. Administrar Actividad Fisica.\n" + //
                                    "5. Volver.");
                opcion = sc.nextInt();
                sc.nextLine();
            }catch(InputMismatchException e){
                System.out.println("Error: Debes ingresar un numero.\n");
                sc.nextLine();
            }
        }while(opcion!=1 && opcion!=2 && opcion!=3 && opcion!=4 && opcion!=5);

        return opcion;
    }

    public String opcionesIniciales(){

        while (true) {
            try {
                System.out.println("a.Crear perfil \nb.Seleccionar perfil \nc.Cerrar");
                return sc.nextLine().toLowerCase();
        }catch (InputMismatchException e){
                System.out.println("Error: Debes ingresar una opcion correcta.");
            }
        }
    }
}
