package modelo.medicina;

import java.util.ArrayList;

public class TomaMedicinaModelo {
    private ArrayList<ArrayList<TomaMedicina>> listaListasTomas;

    public TomaMedicinaModelo(){
        this.listaListasTomas = new ArrayList<>();
    }

    //Crea una lista de tomas para un perfil.
    public void inicializarListaTomas(){
        listaListasTomas.add( new ArrayList<>());
    }

    //Agregar Toma a la lista de tomas.
    public void agregarToma(int i , TomaMedicina tomaMedicina){
        if (i>=0 && i < listaListasTomas.size()){
            listaListasTomas.get(i).add(tomaMedicina);
        }
    }
    
    //Obterner la lista de tomas asociada a un perfil.
    public ArrayList<TomaMedicina> obtenerTomaDePerfil(int i){
        if (i>=0 && i<listaListasTomas.size()){
            return listaListasTomas.get(i);
        }
    return new ArrayList<>();

    }

}
