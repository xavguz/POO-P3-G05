package Controladores;

import modelo.Perfil;

import java.util.ArrayList;
import java.util.Scanner;

public class Funciones {

    static Scanner sc = new Scanner(System.in);

    public static String Opciones(){
        String opcion;
        do {
            System.out.println("a.Crear perfil \nb.Seleccionar perfil \nc.Cerrar");
            opcion = sc.nextLine().toLowerCase();
        }while(!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c"));
        return opcion;
    }
    
    public static void  CrearPerfil(){
        
        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su relación: ");
        String relacion = sc.nextLine();
        System.out.println("Ingrese su email(NO obligatorio): ");
        String email = sc.nextLine();

        if (!email.isEmpty()){
            Perfil perfil = new Perfil(nombre,relacion,email);
        }
        else {
            Perfil perfil = new Perfil(nombre,relacion,"No tiene email.");
        }
        System.out.println("Se ha creado un nuevo perfil.");
    }

    public static void SeleccionarPerfil(ArrayList<Perfil> listaUsuarios){
        for(Perfil usuario:listaUsuarios){
        System.out.printf(usuario.getNombreUsuario() + "\n");
        }
    }

}
