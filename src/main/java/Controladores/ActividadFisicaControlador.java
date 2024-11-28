package Controladores;

import java.util.ArrayList;
import modelo.Fecha;
import modelo.PerfilModelo;
import modelo.ActividadFisica;
import modelo.ActividadFisicaModelo;
import modelo.enums.Actividad;
import modelo.enums.Horario;
import vista.ActividadFisicaVista;

public class ActividadFisicaControlador {
    private ActividadFisicaModelo actividadFisicaModelo;
    private ActividadFisicaVista actividadFisicaVista;
    private PerfilModelo perfilModelo;

    public ActividadFisicaControlador(ActividadFisicaModelo actividadFisicaModelo, 
    ActividadFisicaVista actividadFisicaVista, PerfilModelo perfilModelo){
        this.actividadFisicaModelo = actividadFisicaModelo;
        this.actividadFisicaVista = actividadFisicaVista;
        this.perfilModelo = perfilModelo;
    }


    public int opcionesActividadFisica(){
        int opcion;
        do{
            System.out.println("1. Registrar acitividad fisica.\n" + //
                                "2. Volver.");
            opcion = actividadFisicaVista.sc.nextInt();
            actividadFisicaVista.sc.nextLine();
        }while(opcion == 1 && opcion == 2);
        return opcion;
    }


    public void registrarActividadFisica(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre, relacion);
        String dia;
        String hora;
        String actividad;
        String duracion;
        String horario;
        int opcion;
        int numeral;

        ArrayList<ActividadFisica> listaActividades = actividadFisicaModelo.obtenerListaActividades(i);
        
        actividadFisicaVista.mostrarListaActividades(listaActividades);

        System.out.println("Ingrese el dia que realizó la actividad:");
        dia = actividadFisicaVista.sc.nextLine();
        System.out.println("Ingrese la hora en que realizó la actvidad:");
        hora = actividadFisicaVista.sc.nextLine();
        Fecha fecha = new Fecha(dia,hora);
        numeral = 1;

        for (Actividad a: Actividad.values()){
            System.out.println(numeral + ". " + a);
            numeral++;
        }

        System.out.println("Escoja la actividad que realizo (1 al 7): ");
        opcion = actividadFisicaVista.sc.nextInt();
        actividadFisicaVista.sc.nextLine();
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
        duracion = actividadFisicaVista.sc.nextLine();
        numeral = 1;

        for (Horario h:Horario.values()){
            System.out.println(numeral + ". " + h);
            numeral++;
        }
        System.out.println("Escoja el horario(1 al 3).");
        opcion = actividadFisicaVista.sc.nextInt();
        actividadFisicaVista.sc.nextLine();
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
        actividadFisicaModelo.agregarActividad(i, actividadFisica);
        System.out.println("Se ha agregado la actividad: " + actividadFisica);
    }

    public void administrarActividadFisica(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre, relacion);
        int contador = 0;

        ArrayList<ActividadFisica> listaActividades = actividadFisicaModelo.obtenerListaActividades(i);

        while(contador == 0){
            
            actividadFisicaVista.mostrarListaActividades(listaActividades);

            System.out.println("Escoja lo que quiera hacer:");
            
            int opcion = opcionesActividadFisica();
            switch (opcion) {
                case 1:
                    registrarActividadFisica(nombre,relacion);
                    break;
                case 2:
                contador++;
                    break;
            }
        }       
    }
}
