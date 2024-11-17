package Controladores;

import modelo.Perfil;
import java.util.ArrayList;
import java.util.Scanner;

public class PerfilControlador {

    static Scanner sc = new Scanner(System.in);
    public static ArrayList<Perfil> listaUsuario = new ArrayList<>();

    public static ArrayList<Perfil> getListaUsuario() {
        return listaUsuario;
    }

    public static String Opciones(){
        String opcion;
        System.out.println("-----------------\nLista de perfiles\n-----------------");

        for(Perfil usuario:listaUsuario){
            System.out.printf("- " + usuario.getNombreUsuario() + "\n");
        }

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
            listaUsuario.add(perfil);
        }
        else {
            Perfil perfil = new Perfil(nombre,relacion,"No tiene email.");
            listaUsuario.add(perfil);
        }
        System.out.println("Se ha creado un nuevo perfil.");
    }

    public static void SeleccionarPerfil(ArrayList<Perfil> listaUsuarios){
        
        System.out.println("-----------------\nLista de perfiles\n-----------------");
        for(Perfil usuario:listaUsuario){
            System.out.printf("- " + usuario.getNombreUsuario() + "\n");
        }
        System.out.println("Seleccine un perfil: ");

        String nombre = sc.nextLine();
        boolean encontrado = false;

        for (Perfil usuario:listaUsuario){
            if (usuario.getNombreUsuario().equalsIgnoreCase(nombre)){
                encontrado = true;
                System.out.println("\nHola, " + nombre + " que quieres hacer: ");
                System.out.println("\n1.Administrar Medicamentos.\n2.Administrar Medicos.\n3.Administrar Actividad Fisica.\n");
                int opcion = sc.nextInt();
                switch (opcion){
                    case 1:
                        System.out.println("Escoja lo que desee hacer: \n");
                        System.out.println("1.Añadir Medicina.\n2.Eliminar Medicina.\n3.Registrar Toma.");
                        opcion = sc.nextInt();
                        
                        switch (opcion){
                            case 1:
                                MedicinaControlador.añadirMedicina();

                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                        }
                    break;

                }

            }
        }
        if (encontrado == false){
            System.out.println("\nNo existe el usuario.");
        }
    }
}
