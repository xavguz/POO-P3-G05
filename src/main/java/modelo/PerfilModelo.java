package modelo;

import java.util.ArrayList;

public class PerfilModelo {
    private ArrayList<Perfil> listaPerfiles;

    public PerfilModelo(){
        this.listaPerfiles = new ArrayList<>();
    }

    public void agregarPerfil(Perfil perfil){
        listaPerfiles.add(perfil);
    }
    
    public int obtenerIndice(String nombre,String relacion){
        for (int i = 0; i < listaPerfiles.size(); i++){
            if (listaPerfiles.get(i).getNombre().equals(nombre) && 
                listaPerfiles.get(i).getRelacion().equals(relacion)){
                return i;
            }
        }
    return -1;
    }
    
    public ArrayList<Perfil> getListaPerfiles() {
        return listaPerfiles;
    }
}

