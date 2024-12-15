package Controladores;

import java.util.ArrayList;
import modelo.FechaModelo;
import modelo.PerfilModelo;
import modelo.ActividadFisicaModelo;
import vista.ActividadFisicaVista;

public class ActividadFisicaControlador {
    private ActividadFisicaVista actividadFisicaVista;

    public ActividadFisicaControlador(ActividadFisicaVista actividadFisicaVista){
        this.actividadFisicaVista = actividadFisicaVista;
    }

    public void registrarActividadFisica(PerfilModelo perfil){
        String dia;
        String mes;
        String año;
        String hora;
        String actividad;
        String duracion;
        String horario;

        ArrayList<ActividadFisicaModelo> listaActividades = perfil.getActividadesFisicas();
        
        actividadFisicaVista.mostrarListaActividades(listaActividades);

        dia = actividadFisicaVista.diaActividad();
        mes = actividadFisicaVista.mesActividad();
        año = actividadFisicaVista.añoActividad();
        hora = actividadFisicaVista.horaActividad();
        actividad = actividadFisicaVista.tipoActividad();
        duracion = actividadFisicaVista.duracionActividad();
        horario = actividadFisicaVista.horarioActividad();

        FechaModelo fecha = new FechaModelo(dia,mes,año,hora);
        ActividadFisicaModelo actividadFisica = new ActividadFisicaModelo(fecha, actividad, duracion, horario);
        listaActividades.add(actividadFisica);
        System.out.println("Se ha agregado la actividad: " + actividadFisica);
    }

    public void administrarActividadFisica(PerfilModelo perfil){
        int contador = 0;
        ArrayList<ActividadFisicaModelo> listaActividades = perfil.getActividadesFisicas();

        while(contador == 0){
            
            actividadFisicaVista.mostrarListaActividades(listaActividades);

            System.out.println("Escoja lo que quiera hacer:");
            
            int opcion = actividadFisicaVista.opcionesActividadFisica();
            actividadFisicaVista.sc.nextLine();
            switch (opcion) {
                case 1:
                    registrarActividadFisica(perfil);
                    break;
                case 2:
                contador++;
                    break;
            }
        }       
    }
}
