package vista;

import Controladores.MedicinaControlador;
import Controladores.MedicoControlador;
import Controladores.PerfilControlador;
import Controladores.TomaMedicinaControlador;
import modelo.MedicoModelo;
import modelo.PerfilModelo;
import modelo.medicina.MedicinaModelo;
import modelo.medicina.TomaMedicinaModelo;

public class Main {
    public static void main(String[] args) {

        MedicinaModelo medicinaModelo = new MedicinaModelo();
        MedicinaVista medicinaVista = new MedicinaVista();
        PerfilModelo perfilModelo = new PerfilModelo();
        PerfilVista perfilVista = new PerfilVista();
        TomaMedicinaModelo tomaMedicinaModelo = new TomaMedicinaModelo();
        TomaMedicinaVista tomaMedicinaVista = new TomaMedicinaVista();
        MedicoModelo medicoModelo = new MedicoModelo();
        MedicoVista medicoVista = new MedicoVista();
        MedicoControlador medicoControlador= new MedicoControlador(perfilModelo, medicoModelo, medicoVista);
        TomaMedicinaControlador tomaMedicinaControlador = new TomaMedicinaControlador(perfilModelo, medicinaModelo, 
        medicinaVista, tomaMedicinaModelo, tomaMedicinaVista);
        MedicinaControlador medicinaControlador = new MedicinaControlador(medicinaModelo, medicinaVista,
                                                                            perfilModelo,tomaMedicinaControlador);
        PerfilControlador perfilControlador = new PerfilControlador(perfilModelo, 
                                                        perfilVista, medicinaModelo, tomaMedicinaModelo, 
                                                        medicoModelo, medicinaControlador, medicoControlador);
        perfilControlador.inicio();
    }
}