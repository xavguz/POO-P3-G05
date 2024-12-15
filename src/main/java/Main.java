import Controladores.ActividadFisicaControlador;
import Controladores.CitaMedicaControlador;
import Controladores.MedicinaControlador;
import Controladores.MedicoControlador;
import Controladores.PerfilControlador;
import Controladores.TomaMedicinaControlador;
import modelo.CitaMedicaModelo;
import modelo.FechaModelo;
import modelo.MedicoModelo;
import modelo.PerfilModelo;
import modelo.ActividadFisicaModelo;
import modelo.MedicinaModelo;
import vista.ActividadFisicaVista;
import vista.CitaMedicaVista;
import vista.MedicinaVista;
import vista.MedicoVista;
import vista.PerfilVista;
import vista.TomaMedicinaVista;
import modelo.*;

public class Main {
    public static void main(String[] args) {
        ListaPerfilesModelo listaPerfiles = new ListaPerfilesModelo();
        MedicinaVista medicinaVista = new MedicinaVista();
        PerfilModelo perfilModelo = new PerfilModelo();
        PerfilVista perfilVista = new PerfilVista();
        TomaMedicinaVista tomaMedicinaVista = new TomaMedicinaVista();
        MedicoVista medicoVista = new MedicoVista();
        CitaMedicaVista citaMedicaVista = new CitaMedicaVista();
        ActividadFisicaVista actividadFisicaVista = new ActividadFisicaVista();
        ActividadFisicaControlador actividadFisicaControlador = new ActividadFisicaControlador(actividadFisicaVista);
        MedicoControlador medicoControlador= new MedicoControlador(medicoVista);
        TomaMedicinaControlador tomaMedicinaControlador = new TomaMedicinaControlador(medicinaVista, tomaMedicinaVista);
        MedicinaControlador medicinaControlador = new MedicinaControlador(medicinaVista, perfilModelo, tomaMedicinaControlador);
        CitaMedicaControlador citaMedicaControlador = new CitaMedicaControlador(citaMedicaVista, medicoVista);
        PerfilControlador perfilControlador = new PerfilControlador(perfilVista, listaPerfiles, 
                                                    medicinaControlador, medicoControlador, 
                                                    citaMedicaControlador, actividadFisicaControlador);

        PerfilModelo perfilInicio= new PerfilModelo("Pepe", "Padre", "er.kj45@hotmail.com");
        listaPerfiles.getPerfiles().add(perfilInicio);
        MedicinaModelo medicinaInicio= new MedicinaModelo("Paracetamol", 30, "PASTILLA","CADA DIA", "UNA VEZ AL DÍA [ 8:00 ]", 500);
        perfilInicio.getMedicinas().add(medicinaInicio);
        FechaModelo fechaInicio= new FechaModelo("12", "12","24","11:00");
        ActividadFisicaModelo actividadInicial= new ActividadFisicaModelo(fechaInicio, "Trotar", "30", "MAÑANA");
        perfilInicio.getActividadesFisicas().add(actividadInicial);
        MedicoModelo medicoInicial= new MedicoModelo("Jacob", "CARDIOLOGIA", "0968124200", "Jacob@hotmail.com", "Sucre 1324");
        perfilInicio.getMedicos().add(medicoInicial);
        FechaModelo fechaInicio1= new FechaModelo("15", "12","24","16:00");
        CitaMedicaModelo citaMedicaInicial= new CitaMedicaModelo("Cardiologia", fechaInicio1, medicoInicial);
        perfilInicio.getCitaMedicas().add(citaMedicaInicial);

        perfilControlador.inicio();
    }
}
