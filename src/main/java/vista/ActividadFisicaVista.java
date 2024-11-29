package vista;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import modelo.ActividadFisica;
import modelo.enums.Actividad;
import modelo.enums.Horario;


public class ActividadFisicaVista {

    public Scanner sc = new Scanner(System.in);

    public void mostrarListaActividades(ArrayList<ActividadFisica> listaActividades) {
        System.out.println("----------------Lista de Actividades Físicas----------------");
        if (listaActividades.isEmpty()) {
            System.out.println("- No hay Actividades Físicas en los registros.");
        } else {
            for (ActividadFisica actividadFisica : listaActividades) {
                System.out.printf("- " + actividadFisica + "\n");
            }
        }
        System.out.println("------------------------------------------------------------");
    }

    public String diaActividad() {
        String dia;
        do {
            System.out.println("Ingrese el dia que realizó la actividad:");
            dia = sc.nextLine();
        } while (dia.isEmpty());
        return dia;
    }

    public String horaActividad() {
        String hora;
        do {
            System.out.println("Ingrese la hora en que realizó la actvidad:");
            hora = sc.nextLine();
        } while (hora.isEmpty());
        return hora;
    }

    public String tipoActividad() {
        while (true) {
            int contador = 1;
            System.out.println("Escoja la actividad que realizo (1 al 7): ");
            for (Actividad a : Actividad.values()) {
                System.out.println(contador + ". " + a);
                contador++;
            }
            try {
                int opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
                    case 1:
                        return Actividad.CAMINAR.name();
                    case 2:
                        return Actividad.TROTAR.name();
                    case 3:
                        return Actividad.CORRER.name();
                    case 4:
                        return Actividad.FUNCIONAL.name();
                    case 5:
                        return Actividad.CROSSFIT.name();
                    case 6:
                        return Actividad.ENTRENAMIENTO_DE_PESAS.name();
                    case 7:
                        return Actividad.NADAR.name();
                    default:
                        System.out.println("Error: Por favor, ingresa un valor numérico válido entre 1 y 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }

    public String duracionActividad() {
        String duracion;
        do {
            System.out.println("Ingrese la duracion del ejercicio (en minutos): ");
            duracion = sc.nextLine();
        } while (duracion.isEmpty());
        return duracion;
    }

    public String horarioActividad() {
        while (true){
            int contador = 1;
            for (Horario horario:Horario.values()){
                System.out.println(contador + ". " + horario);
                contador++;
            }
            try {
                int opcion = sc.nextInt();
                switch (opcion) {
                    case 1:
                        return Horario.MAÑANA.name();
                    case 2:
                         return Horario.TARDE.name();
                    case 3:
                        return Horario.NOCHE.name();
                    default:
                        System.out.println("Error: Por favor, ingresa un valor numérico válido entre 1 y 3.");
                }
            } catch (InputMismatchException e){
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }

    public int opcionesActividadFisica(){
        while (true){
            System.out.println("1. Registrar acitividad fisica.\n" + //
                    "2. Volver.");
            try{
                return sc.nextInt();
            } catch (InputMismatchException e){
                System.out.println("Error: Por favor, ingresa un valor numérico válido.");
                sc.nextLine();
            }
        }
    }
}
