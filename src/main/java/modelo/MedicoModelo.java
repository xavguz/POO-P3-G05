package modelo;

import java.util.ArrayList;

public class MedicoModelo {
    private ArrayList<ArrayList<Medico>> listaListasMedicos;

    public MedicoModelo(){
        this.listaListasMedicos = new ArrayList<>();
    }

    // Inicializar Lista de medicos para un perril
    public void inicializarListaMedicosPerfil(){
        listaListasMedicos.add(new ArrayList<>());
    }

    // Agregar un medico a la lista
    public void agregarMedico(int i, Medico medico){
        if (i >= 0 && i < listaListasMedicos.size()){
            listaListasMedicos.get(i).add(medico);
        }
    }

    // Obtener la lista de medicos
    public ArrayList<Medico> obtenerListaMedicos(int i){
        if (i >= 0 && i < listaListasMedicos.size()){
            return listaListasMedicos.get(i);
        }
        return new ArrayList<>();
    }

}
