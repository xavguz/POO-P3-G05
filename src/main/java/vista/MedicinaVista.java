package vista;

import java.util.Scanner;
import java.util.ArrayList;
import modelo.enums.Dias;
import modelo.enums.Frecuencia;
import modelo.enums.FrecuenciaDia;
import modelo.enums.Presentacion;
import modelo.medicina.Medicina;

public class MedicinaVista {
    
    public Scanner sc = new Scanner(System.in);

    public ArrayList<Object> medicina() {
        ArrayList<Object> medicina = new ArrayList<>();
        ArrayList<String> diasSeleccionados = new ArrayList<String>();
        ArrayList<String> horas = new ArrayList<String>();
        String nombre;
        float cantidadUnidades;
        String presentacion;
        String frecuencia;
        String frecuenciaDia;
        float dosis;
        String hora;
        int numeracion;
        int opcion;

        System.out.print("Nombre del Medicamento: ");
        nombre = sc.nextLine();
        medicina.add(nombre);
    
        System.out.print("Cantidad de unidades disponibles a consumir: ");
        cantidadUnidades = sc.nextFloat();
        sc.nextLine();
        medicina.add(cantidadUnidades);
    
        System.out.println("Seleccione una opción de presentación (Ingrese un numero del 1 al 6):");
        numeracion = 1;
        for (Presentacion p : Presentacion.values()) {
            System.out.println(numeracion + ". " + p);
            numeracion++;
        }
        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                presentacion = Presentacion.PASTILLA.name();
                medicina.add(presentacion);
                break;
            case 2:
                presentacion = Presentacion.INYECCION.name();
                medicina.add(presentacion);
                break;
            case 3:
                presentacion = Presentacion.SOLUCION.name();
                medicina.add(presentacion);
                break;
            case 4:
                presentacion = Presentacion.GOTAS.name();
                medicina.add(presentacion);
                break;
            case 5:
                presentacion = Presentacion.INHALADOR.name();
                medicina.add(presentacion);
                break;
            case 6:
                presentacion = Presentacion.POLVO.name();
                medicina.add(presentacion);
                break;
            default:
                presentacion = null;
                medicina.add(presentacion);
                break;
        
        }
        
        System.out.println("Seleccione la frecuencia (Ingrese un numero del 1 al 6):");
        numeracion = 1;
        for (Frecuencia f : Frecuencia.values()) {
            System.out.println(numeracion + ". "+f);
            numeracion++;
        }
        
        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                frecuencia = Frecuencia.CADA_DIA.name();
                medicina.add(frecuencia);
                break;
            case 2:
                frecuencia = Frecuencia.CADA_DOS_DIAS.name();
                medicina.add(frecuencia);
                break;
            case 3:
                int n = 0;
                numeracion = 1;
                for(Dias dia : Dias.values()) {
                    System.out.println(numeracion + ". " +dia);
                    numeracion++;
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
                medicina.add(frecuencia);
                diasSeleccionados.clear();
                break;
            case 4:
                System.out.println("Cantidad de días: ");
                String dias = sc.nextLine();
                frecuencia = "CADA_" + dias + "_DIAS";
                medicina.add(frecuencia);
                break;
            case 5:
                System.out.println("Cantidad de semanas: ");
                String semanas = sc.nextLine();
                frecuencia = "CADA_" + semanas + "_SEMANAS";
                medicina.add(frecuencia);
                break;
            case 6:
                System.out.println("Cantidad de meses: ");
                String meses = sc.nextLine();
                frecuencia = "CADA_" + meses + "_DIAS";
                medicina.add(frecuencia);
                break;
            default:
                frecuencia = null;
                medicina.add(frecuencia);
        }
        
        System.out.println("Seleccione la frecuencia en el dia (Ingrese un numero del 1 al 4):");
        numeracion = 1;
        for (FrecuenciaDia fDia : FrecuenciaDia.values()) {
            System.out.println(numeracion + ". " + fDia);
            numeracion++;
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
                medicina.add(frecuenciaDia);
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
                medicina.add(frecuenciaDia);
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
                medicina.add(frecuenciaDia);
                horas.clear();
                
                break;
            default:
                frecuenciaDia = null;
                medicina.add(frecuenciaDia);
                break;
        }

        System.out.println("Ingrese la dosis a tomar de la medicina (gramos): ");
        dosis = sc.nextFloat();
        sc.nextLine();
        medicina.add(dosis);

        return medicina;
    }
    
    public void mostrarListaMedicinas(ArrayList<Medicina> listaMedicinas){

        if (listaMedicinas.isEmpty()){
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("                                  Lista de Medicinas                                  ");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("NOMBRE / INVENTARIO / PRESENTACION / FRECUENCIA / FRECUENCIA_EN_EL_DIA [HORA] / DOSIS ");
            System.out.println("- No hay medicinas.");
            System.out.println("--------------------------------------------------------------------------------------");
        }
        else{
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("                                  Lista de Medicinas                                  ");
            System.out.println("--------------------------------------------------------------------------------------");
            System.out.println("NOMBRE / INVENTARIO / PRESENTACION / FRECUENCIA / FRECUENCIA_EN_EL_DIA [HORA] / DOSIS ");
            for(Medicina medicina: listaMedicinas){
                System.out.printf("- " + medicina + "\n");
            }
            System.out.println("--------------------------------------------------------------------------------------");
        }
    }

    public int opcionesMedicamentos(){
        int opcion;
        
        do {
            System.out.println("1. Añadir Medicina.\n" + //
                                "2. Eliminar Medicina.\n" + //
                                "3. Registrar Toma.\n" + //
                                "4. Volver.");
            opcion = sc.nextInt();
        }while(opcion == 1 && opcion == 2 && opcion == 3 && opcion == 4);
        return opcion;
    }
}
