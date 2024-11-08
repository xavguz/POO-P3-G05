package com.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input;

        do{
            System.out.println("a. Crear perfil\nb. Seleccionar perfil");
            input = sc.nextLine().toLowerCase();
        } while (!input.equals("a") &&
                !input.equals("b"));

        switch (input) {
            case "a":
                System.out.println("Ingresar nombre: ");
                String nombreUsuario = sc.nextLine();
                System.out.println("Ingresar relacion: ");
                String relacion = sc.nextLine();
                System.out.println("Ingresar email (No obligatorio): ");
                String email = sc.nextLine();

                if (email.isEmpty()) {
                    Perfil perfil = new Perfil(nombreUsuario, relacion);
                } else {
                    Perfil perfil = new Perfil(nombreUsuario, relacion, email);
                }
                System.out.println("Se ha creado un perfil");
                System.out.println(Perfil.getListaUsuarios());
                break;
        }
    }
}