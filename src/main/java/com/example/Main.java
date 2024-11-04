package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String input;

        do{
            System.out.println("a. Crear perfil\nb. Seleccionar perfil");
            input = sc.nextLine();
        } while (!input.equalsIgnoreCase("a") &&
                !input.equalsIgnoreCase("b"));

        sc.close();
    }
}