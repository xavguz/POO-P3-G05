package modelo;

import java.util.ArrayList;

public class ActividadFisicaModelo {
    private ArrayList<ArrayList<ActividadFisica>> listaListasActividades;

    public ActividadFisicaModelo(){
        this.listaListasActividades = new ArrayList<>();
    }

    //Inicializa una lista de actividades para el perfil. 
    public void inicializarListaActividades(){
        listaListasActividades.add(new ArrayList<>());
    }

    //Agregar una actividad a la lista de actividades.
    public void agregarActividad(int i,ActividadFisica actividadFisica){
        if (i >= 0 && i < listaListasActividades.size()){
            listaListasActividades.get(i).add(actividadFisica);
        }
    }

    public ArrayList<ActividadFisica> obtenerListaActividades(int i){
        if(i >= 0 && i < listaListasActividades.size()){
            return listaListasActividades.get(i);
        }
    return new ArrayList<>();
    }
}
