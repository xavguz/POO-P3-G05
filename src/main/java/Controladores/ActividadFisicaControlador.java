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

    public void registrarActividadFisica(String nombre,String relacion){
        String dia;
        String mes;
        String año;
        String hora;
        String actividad;
        String duracion;
        String horario;

        int i = perfilModelo.obtenerIndice(nombre, relacion);
        ArrayList<ActividadFisica> listaActividades = actividadFisicaModelo.obtenerListaActividades(i);
        
        actividadFisicaVista.mostrarListaActividades(listaActividades);

        dia = actividadFisicaVista.diaActividad();
        mes = actividadFisicaVista.mesActividad();
        año = actividadFisicaVista.añoActividad();
        hora = actividadFisicaVista.horaActividad();
        actividad = actividadFisicaVista.tipoActividad();
        duracion = actividadFisicaVista.duracionActividad();
        horario = actividadFisicaVista.horarioActividad();

        Fecha fecha = new Fecha(dia,mes,año,hora);
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
            
            int opcion = actividadFisicaVista.opcionesActividadFisica();
            actividadFisicaVista.sc.nextLine();
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
