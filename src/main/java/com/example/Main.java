package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String respuesta;

        do{
            System.out.println("a. Crear perfil\nb. Seleccionar perfil");
            respuesta = sc.nextLine();
        } while (respuesta.equals("a") || respuesta.equals("b"));
    }
}