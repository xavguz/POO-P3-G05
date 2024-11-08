package com.main;

import java.util.Scanner;

public class Funciones {
    
    protected static String input;
    static Scanner sc = new Scanner(System.in);

    public static void CrearPerfil(){
        System.out.println("Ingresar nombre: ");
        String nombreUsuario = sc.nextLine();
        System.out.println("Ingresar relacion: ");
        String relacion = sc.nextLine();
        System.out.println("Ingresar email (No obligatorio): ");
        String email = sc.nextLine();
        /*if (email.equals(null)) {
            Perfil perfil = new Perfil(nombreUsuario, relacion);
        }*/
        Perfil perfil = new Perfil(nombreUsuario, relacion, email);
        
        System.out.println("Se ha creado un perfil");
        System.out.println(Perfil.getListaUsuarios());
    }
    
    public static String Opciones(){
        do{
            System.out.println("a. Crear perfil\nb. Seleccionar perfil");
            input = sc.nextLine().toLowerCase();
        } while (!input.equals("a") &&
                !input.equals("b"));
        
        return input;
    }
}
