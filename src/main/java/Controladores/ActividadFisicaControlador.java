package Controladores;

import java.util.ArrayList;
import java.util.Scanner;
import modelo.Fecha;
import modelo.actividadfisica.ActividadFisica;
import modelo.actividadfisica.enums.Actividad;
import modelo.actividadfisica.enums.Horario;
import modelo.cita.CitaMedica;

public class ActividadFisicaControlador {

    static ArrayList <ActividadFisica> listaActividadesFisicas = new ArrayList<>();
    public static Scanner sc = new Scanner(System.in);

    public static int opcioneActividadFisica(){
        int opcion;
        do{
            System.out.println("1. Registrar acitividad fisica.\n" + //
                                "2. Volver.");
            opcion = sc.nextInt();
            sc.nextLine();
        }while(opcion == 1 && opcion == 2);
        return opcion;
    }

    public static void mostrarListaActividadFisica(){
        if(listaActividadesFisicas.isEmpty()){
            System.out.println("--------------------------------------\n" + //
                                "     Lista de actividades fisicas     \n" + //
                                "--------------------------------------");
            System.out.println("- No hay Actividad Fisica registradas.\n--------------------------------------");
        }
        else{
            System.out.println("--------------------------------------\n" + //
                                "     Lista de actividades fisicas     \n" + //
                                "--------------------------------------");
            for(ActividadFisica a:listaActividadesFisicas){
                System.out.println("- " + a);
            }
            System.out.println("--------------------------------------");
        }
    }

    public static void registrarActividadFisica(){
        String dia;
        String hora;
        String actividad;
        String duracion;
        String horario;
        int opcion;
        int numeral;

        mostrarListaActividadFisica();

        System.out.println("Ingrese el dia que realizó la actividad:");
        dia = sc.nextLine();
        System.out.println("Ingrese la hora en que realizó la actvidad:");
        hora = sc.nextLine();
        Fecha fecha = new Fecha(dia,hora);
        numeral = 1;

        for (Actividad a: Actividad.values()){
            System.out.println(numeral + ". " + a);
            numeral++;
        }
        System.out.println("Escoja la actividad que relizo(1 al 7).");
        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                actividad = Actividad.CAMINAR.name();
                break;
            case 2:
                actividad = Actividad.TROTAR.name();
                break;
            case 3:
                actividad = Actividad.CORRER.name();
                break;
            case 4:
                actividad = Actividad.FUNCIONAL.name();
                break;
            case 5:
                actividad = Actividad.CROSSFIT.name();
                break;
            case 6:
                actividad = Actividad.ENTRENAMIENTO_DE_PESAS.name();
                break;
            case 7:
                actividad = Actividad.NADAR.name();
                break;
            default:
                actividad = null;
                break;
        }

        System.out.println("Ingrese la duracion del ejercicio: ");
        duracion = sc.nextLine();
        numeral = 1;

        for (Horario h:Horario.values()){
            System.out.println(numeral + ". " + h);
            numeral++;
        }
        System.out.println("Escoja el horario(1 al 3).");
        opcion = sc.nextInt();
        sc.nextLine();
        switch (opcion) {
            case 1:
                horario = Horario.MAÑANA.name();
                break;
            case 2:
                horario = Horario.TARDE.name();
                break;
            case 3:
                horario = Horario.NOCHE.name();
                break;
            default:
                horario = null;
                break;
        }
        ActividadFisica actividadFisica = new ActividadFisica(fecha, actividad, duracion, horario);
        listaActividadesFisicas.add(actividadFisica);
    }

    public static void administrarActividadFisica(){
        int contador = 0;

        while(contador == 0){
            mostrarListaActividadFisica();
            System.out.println("Escoja lo que quiera hacer:");
            
            int opcion = opcioneActividadFisica();
            switch (opcion) {
                case 1:
                    registrarActividadFisica();
                    break;
                default:
                contador++;
                    break;
            }
        }       
    }
}
