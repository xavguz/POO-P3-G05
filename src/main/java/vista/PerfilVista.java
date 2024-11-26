package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Perfil;

public class PerfilVista {

    public Scanner sc = new Scanner(System.in);

    public String ingresarNombre(){
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        return nombre;
    }

    public String ingresarRelacion(){
        System.out.println("Ingrese su relación: ");
        String relacion = sc.nextLine();
        return relacion;
    }

    public String ingresarEmail(){
        System.out.println("Ingrese su email(NO obligatorio): ");
        String email = sc.nextLine();

        if (!email.isEmpty()) {
            email = "No tiene email.";
        }
        return email;
    }

    public void mostrarListaPerfiles(ArrayList<Perfil> listaPerfiles){
        if (listaPerfiles.isEmpty()){
            System.out.println("-----------------------------------------------------------");
            System.out.println("                     Lista de Perfiles                     ");
            System.out.println("-----------------------------------------------------------");
            System.out.println("- No hay perfiles en los registros.");
            System.out.println("-----------------------------------------------------------");
        }
        else{
            System.out.println("-----------------------------------------------------------");
            System.out.println("                     Lista de Perfiles                     ");
            System.out.println("-----------------------------------------------------------");
            for(Perfil perfil: listaPerfiles){
                System.out.printf("- " + perfil + "\n");
            }
            System.out.println("-----------------------------------------------------------");
        }
    }

    public int opcionesAdministrar(){
        int opcion;
        
        do {
            System.out.println("1. Administrar Medicamentos.\n" + //
                                "2. Administrar Médicos.\n" + //
                                "3. Administrar Citas Médicas.\n" + //
                                "4. Administrar Actividad Fisica.\n" + //
                                "5. Volver.");
            opcion = sc.nextInt();
            sc.nextLine();
        }while(opcion == 1 && opcion == 2 && opcion == 3 && opcion == 4 && opcion == 5);
        return opcion;
    }

    public String opcionesIniciales(){

        String opcion;

        do {
            System.out.println("a.Crear perfil \nb.Seleccionar perfil \nc.Cerrar");
            opcion = sc.nextLine().toLowerCase();
        }while(!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c"));
        return opcion;
    }
}
