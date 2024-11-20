package Controladores;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.enums.*;
import modelo.medicina.*;

public class MedicinaControlador {
    public static ArrayList <Medicina> listaMedicinas = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static ArrayList<Medicina> getListaMedicinas() {
        return listaMedicinas;
    }
    public static int OpcionesMedicamentos(){
        int opcion;
        
        do {
            System.out.println("\n1. Añadir Medicina.\n" + //
                                "2. Eliminar Medicina.\n" + //
                                "3. Registrar Toma.\n" + //
                                "4. Volver.\n");
            opcion = sc.nextInt();

        }while(opcion == 1 && opcion == 2 && opcion == 3 && opcion == 4);
        return opcion;
    }

    public static void añadirMedicina(){

        ArrayList<String> diasSeleccionados = new ArrayList<String>();
        ArrayList<String> horas = new ArrayList<String>();
        String nombreMedicamento;
        float cantidadUnidades;
        String presentacion;
        String frecuencia;
        String frecuenciaDia;
        float dosis;
        int opcion;
        int variable;
        String hora;

        System.out.print("Nombre del Medicamento: ");
        nombreMedicamento = sc.nextLine();

        System.out.print("Cantidad de unidades disponibles a consumir: ");
        cantidadUnidades= sc.nextFloat();
        
        System.out.println("Seleccione una opción de presentación (Ingrese un numero del 1 al 6):");
        variable = 1;
        for (Presentacion p : Presentacion.values()) {
            System.out.println(variable + ". " + p);
            variable++;
        }
        opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                presentacion = Presentacion.PASTILLA.name();
                break;
            case 2:
                presentacion = Presentacion.INYECCION.name();
                break;
            case 3:
                presentacion = Presentacion.SOLUCION.name();
                break;
            case 4:
                presentacion = Presentacion.GOTAS.name();
                break;
            case 5:
                presentacion = Presentacion.INHALADOR.name();
                break;
            case 6:
                presentacion = Presentacion.POLVO.name();
                break;
            default:
                presentacion = null;
                break;

        }

        System.out.println("Seleccione la frecuencia (Ingrese un numero del 1 al 6):");
        variable = 1;
        for (Frecuencia f : Frecuencia.values()) {
            System.out.println(variable + ". "+f);
            variable++;
        }

        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                frecuencia = Frecuencia.CADA_DIA.name();
                break;
            case 2:
                frecuencia = Frecuencia.CADA_DOS_DIAS.name();
                break;
            case 3:
                int n = 0;
                variable = 1;
                for(Dias dia : Dias.values()) {
                    System.out.println(variable + ". " +dia);
                    variable++;
                }

                while(n == 0) {
                    System.out.print("Seleccionar los días (del 1 al 7):\n Presione ENTER para continuar. ");
                    String dia = sc.nextLine();
                    switch (dia) {
                        case "1":
                            diasSeleccionados.add("LUNES");
                            break;
                        case "2":
                            diasSeleccionados.add("MARTES");
                            break;
                        case "3":
                            diasSeleccionados.add("MIERCOLES");
                            break;
                        case "4":
                            diasSeleccionados.add("JUEVES");
                            break;
                        case "5":
                            diasSeleccionados.add("VIERNES");
                            break;
                        case "6":
                            diasSeleccionados.add("SABADO");
                            break;
                        case "7":
                            diasSeleccionados.add("DOMINGO");
                            break;
                        default:
                            n++;
                            break;
                    }
                }
                frecuencia = "DIAS [ " + String.join("/", diasSeleccionados) + " ] ";
                diasSeleccionados.clear();
                break;
            case 4:
                System.out.println("Cantidad de días: ");
                String dias = sc.nextLine();
                frecuencia = "CADA_" + dias + "_DIAS";
                break;
            case 5:
                System.out.println("Cantidad de semanas: ");
                String semanas = sc.nextLine();
                frecuencia = "CADA_" + semanas + "_SEMANAS";
                break;
            case 6:
                System.out.println("Cantidad de meses: ");
                String meses = sc.nextLine();
                frecuencia = "CADA_" + meses + "_DIAS";
                break;
            default:
                frecuencia = null;
        }

        System.out.println("Seleccione la frecuencia en el dia (Ingrese un numero del 1 al 4):");
        variable = 1;
        for (FrecuenciaDia fDia : FrecuenciaDia.values()) {
            System.out.println(variable + ". " + fDia);
            variable++;
        }

        opcion = sc.nextInt();
        sc.nextLine();

        int contador;
        switch (opcion) {
            case 1:
                frecuenciaDia = FrecuenciaDia.UNA_VEZ_AL_DIA.name();
                System.out.println("Ingrese la hora para la toma (hh:mm): ");
                hora = sc.nextLine();
                frecuenciaDia += " [ " + hora + " ]";
                break;
            case 2:
                frecuenciaDia = FrecuenciaDia.DOS_VECES_AL_DIA.name() + " [ ";
                contador = 0;
                while(contador < 2){
                    System.out.println("Ingrese la hora para la toma (hh:mm): ");
                    hora = sc.nextLine();
                    horas.add(hora);
                    contador++;
                }
                frecuenciaDia += String.join("/",horas) + " ]";
                horas.clear();
                break;
            case 3:
                frecuenciaDia = FrecuenciaDia.TRES_VECES_AL_DIA.name() + " [ ";
                contador = 0;
                while(contador < 3){
                    System.out.println("Ingrese la hora para la toma (hh:mm): ");
                    hora = sc.nextLine();
                    horas.add(hora);
                    contador++;
                }
                frecuenciaDia += String.join("/",horas) + " ]";
                horas.clear();

                break;
            default:
                frecuenciaDia = null;
                break;
        }

        System.out.println("Ingrese la dosis a tomar de la medicina (gramos): ");
        dosis = sc.nextFloat();

        Medicina medicina = new Medicina(nombreMedicamento, cantidadUnidades,
                presentacion, frecuencia, frecuenciaDia, dosis);
        listaMedicinas.add(medicina);
        System.out.println("Se añadio la medicina " + medicina);
    }
    
    public static void administrarMedicamento(){

        int contador = 0;
        while (contador == 0){
            System.out.println("-----------------------------\nLista de Medicamentos Activos\n-----------------------------");
            System.out.println("\nNOMBRE / INVENTARIO / PRESENTACION / FRECUENCIA / FRECUENCIA_EN_EL_DIA / DOSIS\n");
            if (!listaMedicinas.isEmpty()){
                for(Medicina medicina: listaMedicinas){
                    System.out.printf("- " + medicina + "\n");
                }
            }
            System.out.println("---------------------------");
            System.out.println("Escoja lo que desee hacer: ");
            int opcion = OpcionesMedicamentos();
            sc.nextLine();
            switch (opcion) {
                case 1:
                    añadirMedicina();
                case 2:
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
