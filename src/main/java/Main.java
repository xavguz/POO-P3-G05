import Controladores.CitaMedicaControlador;
import Controladores.MedicinaControlador;
import Controladores.MedicoControlador;
import Controladores.PerfilControlador;
import Controladores.TomaMedicinaControlador;
import modelo.CitaMedicaModelo;
import modelo.MedicoModelo;
import modelo.PerfilModelo;
import modelo.medicina.MedicinaModelo;
import modelo.medicina.TomaMedicinaModelo;
import vista.CitaMedicaVista;
import vista.MedicinaVista;
import vista.MedicoVista;
import vista.PerfilVista;
import vista.TomaMedicinaVista;

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
        CitaMedicaModelo citaMedicaModelo = new CitaMedicaModelo();
        CitaMedicaVista citaMedicaVista = new CitaMedicaVista();
        MedicoControlador medicoControlador= new MedicoControlador(perfilModelo, medicoModelo, medicoVista);
        TomaMedicinaControlador tomaMedicinaControlador = new TomaMedicinaControlador(perfilModelo, medicinaModelo, 
        medicinaVista, tomaMedicinaModelo, tomaMedicinaVista);
        MedicinaControlador medicinaControlador = new MedicinaControlador(medicinaModelo, medicinaVista,
                                                                perfilModelo,tomaMedicinaControlador);
        CitaMedicaControlador citaMedicaControlador = new CitaMedicaControlador(citaMedicaModelo, citaMedicaVista, 
                                                                perfilModelo, medicoModelo, medicoVista);
        PerfilControlador perfilControlador = new PerfilControlador(perfilModelo, perfilVista, 
        medicinaModelo, tomaMedicinaModelo, medicoModelo, 
        citaMedicaModelo, medicinaControlador, medicoControlador, citaMedicaControlador);
        perfilControlador.inicio();
    }
}