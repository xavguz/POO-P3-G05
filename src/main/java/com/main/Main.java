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
    }
}