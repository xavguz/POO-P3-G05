package Controladores;

import modelo.Perfil;
import java.util.ArrayList;
import java.util.Scanner;
import Controladores.MedicinaControlador;
import modelo.medicina.*;

public class PerfilControlador {

    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Perfil> listaUsuario = new ArrayList<>();

    public static ArrayList<Perfil> getListaUsuario() {
        return listaUsuario;
    }

    public static String OpcionesIniciales(){
        String opcion;
        System.out.println("-----------------\nLista de perfiles\n-----------------");

        if (!listaUsuario.isEmpty()){
            for(Perfil usuario:listaUsuario){
                System.out.printf("- " + usuario.getNombreUsuario() +
                        " (" +usuario.getRelacion() + ")"+ "\n");
            }
        } else {
            System.out.println("- No hay usuarios");
        }
        System.out.println("-----------------");

        do {
            System.out.println("a.Crear perfil \nb.Seleccionar perfil \nc.Cerrar");
            opcion = sc.nextLine().toLowerCase();
        }while(!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c"));
        return opcion;
    }

    public static int OpcionesAdministrar(){
        int opcion;
        
        do {
            System.out.println("1. Administrar Medicamentos.\n" + //
                                "2. Administrar Médicos.\n" + //
                                "3. Administrar Citas Médicas.\n" + //
                                "4. Volver.");
            opcion = sc.nextInt();
            sc.nextLine();
        }while(opcion == 1 && opcion == 2 && opcion == 3 && opcion == 4);
        return opcion;
    }
    
    /*private static boolean verificarPerfil(ArrayList<Perfil> lista,Perfil p){
        for (Perfil perfil :lista){
            if (perfil.getNombreUsuario().equalsIgnoreCase(p.getNombreUsuario())&&
                perfil.getRelacion().equalsIgnoreCase(p.getRelacion())&&
                perfil.getEmail().equalsIgnoreCase(p.getEmail())){
                return true;
            }
        }
        return false;
    }*/

    public static void  CrearPerfil() {

        System.out.println("Ingrese su nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Ingrese su relación: ");
        String relacion = sc.nextLine();
        System.out.println("Ingrese su email(NO obligatorio): ");
        String email = sc.nextLine();

        if (!email.isEmpty()) {
            Perfil perfil = new Perfil(nombre, relacion, email);

            if (!listaUsuario.contains(perfil)) {
                listaUsuario.add(perfil);
            }
            else {
                System.out.println("El perfil ya existe");
            }
            
        } 
        else {
            Perfil perfil = new Perfil(nombre, relacion, "No tiene email.");
            
            if (!listaUsuario.contains(perfil)) {
                listaUsuario.add(perfil);
            }
            else {
                System.out.println("El perfil ya existe");
            }    
        }
    }

    public static void SeleccionarPerfil (ArrayList < Perfil > listaUsuarios) {

        System.out.println("-----------------\nLista de perfiles\n-----------------");
        for (Perfil usuario : listaUsuario) {
            System.out.printf("- " + usuario.getNombreUsuario() + "\n");
        }
        System.out.println("-----------------");
        System.out.println("Seleccine un perfil: ");

        String nombre = sc.nextLine();
        boolean encontrado = false;

        for (Perfil usuario : listaUsuario) {
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombre)) {
                encontrado = true;
                int contador = 0;

                while (contador == 0){
                    System.out.println("Hola, " + nombre + " que desea hacer:");
                    int opcion = OpcionesAdministrar();
                    switch (opcion) {
                        case 1:
                            MedicinaControlador.administrarMedicamento();
                            break;
                        case 2:
                            MedicoControlador.administrarMedico();
                            break;
                        case 3:
                            break;
                        case 4:
                        contador++;
                            break;
    
                        }
                }   
            }
        }
        if (encontrado == false) {
            System.out.println("\nNo existe el usuario.");
        }
    }
}

