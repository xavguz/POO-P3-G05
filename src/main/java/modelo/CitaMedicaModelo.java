package modelo;

import java.util.ArrayList;

public class CitaMedicaModelo {
    private ArrayList<ArrayList<CitaMedica>> listaListasCitas;

    public CitaMedicaModelo(){
        this.listaListasCitas = new ArrayList<>();
    }

    //Inicializa una lista de Citas por perfil.
    public void inicializarListaCitasPerfil(){
        listaListasCitas.add(new ArrayList<CitaMedica>());
    }

    //Agrega la cita a la lista de Citas.
    public void agregarCitaPerfil(int i,CitaMedica citaMedica){
        if(i >= 0 && i < listaListasCitas.size()){
            listaListasCitas.get(i).add(citaMedica);
        }
    }

    //Obtener la lista de Citas asociada a perfil.
    public ArrayList<CitaMedica> obtenerListaCitas(int i){
        if (i >= 0 && i < listaListasCitas.size()){
            return listaListasCitas.get(i);
        }
        return new ArrayList<>();
    }

}
