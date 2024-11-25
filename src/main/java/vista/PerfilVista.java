package vista;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Perfil;

public class PerfilVista {

    public Scanner sc = new Scanner(System.in);

    public String IngresarNombre(){
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        return nombre;
    }

    public String IngresarRelacion(){
        System.out.println("Ingrese su relación: ");
        String relacion = sc.nextLine();
        return relacion;
    }

    public String IngresarEmail(){
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
            System.out.println("- No hay Perfiles.");
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
}
