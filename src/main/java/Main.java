import Controladores.ActividadFisicaControlador;
import Controladores.CitaMedicaControlador;
import Controladores.MedicinaControlador;
import Controladores.MedicoControlador;
import Controladores.PerfilControlador;
import Controladores.TomaMedicinaControlador;
import modelo.CitaMedica;
import modelo.CitaMedicaModelo;
import modelo.Fecha;
import modelo.Medico;
import modelo.MedicoModelo;
import modelo.PerfilModelo;
import modelo.ActividadFisica;
import modelo.ActividadFisicaModelo;
import modelo.MedicinaModelo;
import modelo.TomaMedicinaModelo;
import vista.ActividadFisicaVista;
import vista.CitaMedicaVista;
import vista.MedicinaVista;
import vista.MedicoVista;
import vista.PerfilVista;
import vista.TomaMedicinaVista;
import modelo.Perfil;
import modelo.*;

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
        ActividadFisicaModelo actividadFisicaModelo = new ActividadFisicaModelo();
        ActividadFisicaVista actividadFisicaVista = new ActividadFisicaVista();
        ActividadFisicaControlador actividadFisicaControlador = new ActividadFisicaControlador(actividadFisicaModelo, actividadFisicaVista, perfilModelo);
        MedicoControlador medicoControlador= new MedicoControlador(perfilModelo, medicoModelo, medicoVista);
        TomaMedicinaControlador tomaMedicinaControlador = new TomaMedicinaControlador(perfilModelo, medicinaModelo, 
        medicinaVista, tomaMedicinaModelo, tomaMedicinaVista);
        MedicinaControlador medicinaControlador = new MedicinaControlador(medicinaModelo, medicinaVista,
                                                                perfilModelo,tomaMedicinaControlador);
        CitaMedicaControlador citaMedicaControlador = new CitaMedicaControlador(citaMedicaModelo, citaMedicaVista, 
                                                                perfilModelo, medicoModelo, medicoVista);
        PerfilControlador perfilControlador = new PerfilControlador(perfilModelo, perfilVista, 
        medicinaModelo, tomaMedicinaModelo, 
        medicoModelo, citaMedicaModelo, 
        actividadFisicaModelo, medicinaControlador, medicoControlador, 
        citaMedicaControlador, actividadFisicaControlador);

        Perfil perfilInicio= new Perfil("Christian", "Paciente", "er.kj45@hotmail.com");
        perfilModelo.agregarPerfil(perfilInicio);
        medicinaModelo.inicializarListaMedicinaParaPerfil();
        tomaMedicinaModelo.inicializarListaTomas();
        medicoModelo.inicializarListaMedicosPerfil();
        citaMedicaModelo.inicializarListaCitasPerfil();
        actividadFisicaModelo.inicializarListaActividades();
        Medicina medicinaInicio= new Medicina("Paracetamol", 30, "PASTILLA","CADA DIA", "UNA VEZ AL DÍA [ 8:00 ]", 500);
        medicinaModelo.agregarMedicina(0, medicinaInicio);
        Fecha fechaInicio= new Fecha("Lunes", "8:00");
        ActividadFisica actividadInicial= new ActividadFisica(fechaInicio, "Trotar", "0:30", "MAÑANA");
        actividadFisicaModelo.agregarActividad(0, actividadInicial);
        Medico medicoInicial= new Medico("Jacob", "CARDIOLOGIA", "0968124200", "Jacob@hotmail.com", "Sucre 1324");
        medicoModelo.agregarMedico(0, medicoInicial);
        Fecha fechaInicio1= new Fecha("Viernes", "15:00");
        CitaMedica citaMedicaInicial= new CitaMedica("Cardiologia", fechaInicio1, medicoInicial);
        citaMedicaModelo.agregarCitaPerfil(0, citaMedicaInicial);
        perfilControlador.inicio();
    }
}
