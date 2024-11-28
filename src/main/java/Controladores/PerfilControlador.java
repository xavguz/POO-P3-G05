package Controladores;

import modelo.CitaMedicaModelo;
import modelo.MedicoModelo;
import modelo.Perfil;
import modelo.PerfilModelo;
import modelo.ActividadFisicaModelo;
import modelo.MedicinaModelo;
import modelo.TomaMedicinaModelo;
import vista.PerfilVista;
import java.util.ArrayList;

public class PerfilControlador {

    private PerfilModelo perfilModelo;
    private PerfilVista perfilVista;
    private MedicinaModelo medicinaModelo;
    private TomaMedicinaModelo tomaMedicinaModelo;
    private MedicoModelo medicoModelo;
    private CitaMedicaModelo citaMedicaModelo;
    private ActividadFisicaModelo actividadFisicaModelo;
    private MedicinaControlador medicinaControlador;
    private MedicoControlador medicoControlador;
    private CitaMedicaControlador citaMedicaControlador;
    private ActividadFisicaControlador actividadFisicaControlador;

    public PerfilControlador(PerfilModelo perfilModelo,PerfilVista perfilVista, MedicinaModelo medicinaModelo,
                            TomaMedicinaModelo tomaMedicinaModelo, MedicoModelo medicoModelo, 
                            CitaMedicaModelo citaMedicaModelo, ActividadFisicaModelo actividadFisicaModelo ,
                            MedicinaControlador medicinaControlador, MedicoControlador medicoControlador, 
                            CitaMedicaControlador citaMedicaControlador, ActividadFisicaControlador actividadFisicaControlador){
        this.perfilModelo = perfilModelo;
        this.perfilVista = perfilVista;
        this.medicinaModelo = medicinaModelo;
        this.tomaMedicinaModelo = tomaMedicinaModelo;
        this.medicoModelo = medicoModelo;
        this.citaMedicaModelo = citaMedicaModelo;
        this.actividadFisicaModelo = actividadFisicaModelo;
        this.medicinaControlador = medicinaControlador;
        this.medicoControlador = medicoControlador;
        this.citaMedicaControlador = citaMedicaControlador;
        this.actividadFisicaControlador = actividadFisicaControlador;
    }

    public void  CrearPerfil() {
        String nombre = perfilVista.ingresarNombre();
        String relacion = perfilVista.ingresarRelacion();
        String email = perfilVista.ingresarEmail();
        boolean encontrado = false;

        for(Perfil p:perfilModelo.getListaPerfiles()){
            if(p.getNombre().equalsIgnoreCase(nombre) && 
            p.getRelacion().equalsIgnoreCase(relacion)){
                encontrado = true;
                System.out.println("El perfil ya existe.");
                break;
            }
        }
        
        if (!encontrado){
            Perfil perfil = new Perfil(nombre, relacion, email);
            medicinaModelo.inicializarListaMedicinaParaPerfil();
            tomaMedicinaModelo.inicializarListaTomas();
            medicoModelo.inicializarListaMedicosPerfil();
            citaMedicaModelo.inicializarListaCitasPerfil();
            actividadFisicaModelo.inicializarListaActividades();
            perfilModelo.agregarPerfil(perfil);
        } 
    }

    public void SeleccionarPerfil (ArrayList < Perfil > listaPerfiles) {

        perfilVista.mostrarListaPerfiles(listaPerfiles);
        
        System.out.println("Seleccine un perfil");
        
        String nombre = perfilVista.ingresarNombre();
        String relacion = perfilVista.ingresarRelacion();
        boolean encontrado = false;

        for (Perfil usuario : listaPerfiles) {
            if (usuario.getNombre().equalsIgnoreCase(nombre) && usuario.getRelacion().equalsIgnoreCase(relacion)) {
                encontrado = true;
                int contador = 0;
                while (contador == 0){
                    System.out.println("Hola, " + usuario + " que desea hacer:");
                    int opcion = perfilVista.opcionesAdministrar();
                    switch (opcion) {
                        case 1:
                            medicinaControlador.administrarMedicamento(nombre,relacion);
                            break;
                        case 2:
                            medicoControlador.administrarMedico(nombre,relacion);
                            break;
                        case 3:
                            citaMedicaControlador.administrarCita(nombre,relacion);
                            break;
                        case 4:
                            actividadFisicaControlador.administrarActividadFisica(nombre,relacion);
                            break;
                        case 5:
                        contador++;
                            break;
                    
                    }
                }   
            }
        }
        if (!encontrado) {
            System.out.println("\nNo existe el usuario.");
        }
    }

    public void inicio(){
        int contador = 0;
        while(contador == 0){
            perfilVista.mostrarListaPerfiles(perfilModelo.getListaPerfiles());
            String opcion = perfilVista.opcionesIniciales();
            switch(opcion){
                case "a":
                    CrearPerfil();
                    break;
                case "b":
                    SeleccionarPerfil(perfilModelo.getListaPerfiles());
                    //contador++;
                    break;
                case "c":
                    contador++;
                    break;
            }
        }
    }
}

