package modelo.medicina;

import java.util.ArrayList;

public class MedicinaModelo {
    private ArrayList<ArrayList<Medicina>> listaListasMedicinas;

    public MedicinaModelo(){
        this.listaListasMedicinas = new ArrayList<>();
    }

    // Crear una nueva lista de medicinas para un perfil
    public void inicializarListaMedicinaParaPerfil() {
        listaListasMedicinas.add(new ArrayList<>());
    }

    // Agregar medicina a un perfil específico
    public void agregarMedicina(int i, Medicina medicina) {
        if (i >= 0 && i < listaListasMedicinas.size()) {
            listaListasMedicinas.get(i).add(medicina);
        }
    }

    // Obtener la lista de medicinas asociadas a un perfil
    public ArrayList<Medicina> obtenerMedicinasDePerfil(int i) {
        if (i >= 0 && i < listaListasMedicinas.size()) {
            return listaListasMedicinas.get(i);
        }
        return new ArrayList<>();
    }
}
