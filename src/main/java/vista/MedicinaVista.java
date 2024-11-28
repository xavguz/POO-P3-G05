package vista;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import modelo.enums.Dias;
import modelo.enums.Frecuencia;
import modelo.enums.FrecuenciaDia;
import modelo.enums.Presentacion;
import modelo.Medicina;

public class MedicinaVista {
    public Scanner sc = new Scanner(System.in);

    public String nombreMedicina() {
        String nombreMedicina;
        do {
            System.out.println("Ingresar nombre del medicamento: ");
            nombreMedicina = sc.nextLine();
        } while (nombreMedicina.isEmpty());
        return nombreMedicina;
    }

    public float cantidadUnidadesDisponibles() {
        while (true) {
            System.out.println("Ingresar cantidad de unidades disponibles: ");
            try {
                return sc.nextFloat();

            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }

    public String presentacionMedicina() {
        while (true) {
            System.out.println("Ingresar la presentación (1-6): ");
            int contador = 1;
            for (Presentacion p : Presentacion.values()) {
                System.out.println(contador + ". " + p);
                contador++;
            }
            try {
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        return Presentacion.PASTILLA.name();
                    case 2:
                        return Presentacion.INYECCION.name();
                    case 3:
                        return Presentacion.SOLUCION.name();
                    case 4:
                        return Presentacion.GOTAS.name();
                    case 5:
                        return Presentacion.INHALADOR.name();
                    case 6:
                        return Presentacion.POLVO.name();
                    default:
                        System.out.println("Error: Por favor, ingresa un valor numérico válido entre 1 y 6.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }

    public String frecuencia(){
        ArrayList<String> diasSeleccionados = new ArrayList<String>();
        String frecuencia;
        int numeracion;
        while (true) {
            System.out.println("Seleccione una opción de presentación (Ingrese un numero del 1 al 6):");
            numeracion = 1;
            for (Presentacion p : Presentacion.values()) {
                System.out.println(numeracion + ". " + p);
                numeracion++;
            }
            try {
                int opcion = sc.nextInt();
                sc.nextLine();
                switch (opcion) {
                    case 1:
                        return Frecuencia.CADA_DIA.name();
                    case 2:
                        return Frecuencia.CADA_DOS_DIAS.name();
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
                        return "DIAS [ " + String.join("/", diasSeleccionados) + " ] ";
                    case 4:
                        System.out.println("Cantidad de días: ");
                        String dias = sc.nextLine();
                        return "CADA_" + dias + "_DIAS";
                    case 5:
                        System.out.println("Cantidad de semanas: ");
                        String semanas = sc.nextLine();
                        return "CADA_" + semanas + "_SEMANAS";
                    case 6:
                        System.out.println("Cantidad de meses: ");
                        String meses = sc.nextLine();
                        return "CADA_" + meses + "_DIAS";
                    default:
                        return null;
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }
    public String frecuenciaDia(){
        ArrayList<String> horas = new ArrayList<String>();
        String frecuenciaDia;
        String hora;
        while (true){
            System.out.println("Seleccione la frecuencia en el dia (Ingrese un numero del 1 al 4):");
            int numeracion = 1;
            for (FrecuenciaDia fDia : FrecuenciaDia.values()) {
                System.out.println(numeracion + ". " + fDia);
                numeracion++;
            }
            try {
                int opcion = sc.nextInt();
                sc.nextLine();

                int contador;
                switch (opcion) {
                    case 1:
                        frecuenciaDia = FrecuenciaDia.UNA_VEZ_AL_DIA.name();
                        System.out.println("Ingrese la hora para la toma (hh:mm): ");
                        hora = sc.nextLine();
                        frecuenciaDia += " [ " + hora + " ]";
                        return frecuenciaDia;
                    case 2:
                        frecuenciaDia = FrecuenciaDia.DOS_VECES_AL_DIA.name() + " [ ";
                        contador = 0;
                        while (contador < 2) {
                            System.out.println("Ingrese la hora para la toma (hh:mm): ");
                            hora = sc.nextLine();
                            horas.add(hora);
                            contador++;
                        }
                        frecuenciaDia += String.join("/", horas) + " ]";
                        return frecuenciaDia;
                    case 3:
                        frecuenciaDia = FrecuenciaDia.TRES_VECES_AL_DIA.name() + " [ ";
                        contador = 0;
                        while (contador < 3) {
                            System.out.println("Ingrese la hora para la toma (hh:mm): ");
                            hora = sc.nextLine();
                            horas.add(hora);
                            contador++;
                        }
                        frecuenciaDia += String.join("/", horas) + " ]";
                        return frecuenciaDia;
                    default:
                        frecuenciaDia = null;
                        return frecuenciaDia;
                    }
                } catch (InputMismatchException e){
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }

        }
    }

    public float dosis() {
        while (true) {
            System.out.println("Ingresar la dosis: ");
            try {
                return sc.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }
    
    public void mostrarListaMedicinas(ArrayList<Medicina> listaMedicinas){
        System.out.println("----------------------------------Lista de Medicinas----------------------------------");
        if (!listaMedicinas.isEmpty()) {
            System.out.println("NOMBRE / INVENTARIO / PRESENTACION / FRECUENCIA / FRECUENCIA_EN_EL_DIA [HORA] / DOSIS ");
            for (Medicina medicina : listaMedicinas) {
                System.out.printf("- " + medicina + "\n");
            }
        } else {
            System.out.println("                                  - No hay medicina");
        }
        System.out.println("--------------------------------------------------------------------------------------");
    }

    public int opcionesMedicamentos(){
        while (true) {
            System.out.println("1. Añadir Medicina.\n" + //
                    "2. Eliminar Medicina.\n" + //
                    "3. Registrar Toma.\n" + //
                    "4. Volver.");
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }
}