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
    public void agregarMedicina(int indicePerfil, Medicina medicina) {
        if (indicePerfil >= 0 && indicePerfil < listaListasMedicinas.size()) {
            listaListasMedicinas.get(indicePerfil).add(medicina);
        }
    }

    // Obtener la lista de medicinas asociadas a un perfil
    public ArrayList<Medicina> obtenerMedicinasDePerfil(int indicePerfil) {
        if (indicePerfil >= 0 && indicePerfil < listaListasMedicinas.size()) {
            return listaListasMedicinas.get(indicePerfil);
        }
        return new ArrayList<>();
    }
}
