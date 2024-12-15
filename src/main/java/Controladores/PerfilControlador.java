package Controladores;

import modelo.ListaPerfilesModelo;
import modelo.MedicoModelo;
import modelo.PerfilModelo;
import modelo.PerfilModelo;
import modelo.ActividadFisicaModelo;
import modelo.MedicinaModelo;
import modelo.TomaMedicinaModelo;
import vista.PerfilVista;
import java.util.ArrayList;

public class PerfilControlador {

    private PerfilVista perfilVista;
    private ListaPerfilesModelo listaPerfilesModelo;
    private MedicinaControlador medicinaControlador;
    private MedicoControlador medicoControlador;
    private CitaMedicaControlador citaMedicaControlador;
    private ActividadFisicaControlador actividadFisicaControlador;

    public PerfilControlador(PerfilVista perfilVista, 
                            ListaPerfilesModelo listaPerfilesModelo,MedicinaControlador medicinaControlador, 
                            MedicoControlador medicoControlador, CitaMedicaControlador citaMedicaControlador, 
                            ActividadFisicaControlador actividadFisicaControlador){
        this.perfilVista = perfilVista;
        this.listaPerfilesModelo = listaPerfilesModelo;
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

        for(PerfilModelo p: listaPerfilesModelo.getPerfiles()){
            if(p.getNombre().equalsIgnoreCase(nombre) && 
            p.getRelacion().equalsIgnoreCase(relacion)){
                encontrado = true;
                System.out.println("El perfil ya existe.");
                break;
            }
        }
        
        if (!encontrado){
            PerfilModelo perfil = new PerfilModelo(nombre, relacion, email);
            listaPerfilesModelo.getPerfiles().add(perfil);
        } 
    }
    public PerfilModelo verificarPerfil(ArrayList < PerfilModelo > listaPerfiles){
        perfilVista.mostrarListaPerfiles(listaPerfiles);
        
        System.out.println("Seleccine un perfil");
        
        String nombre = perfilVista.ingresarNombre();
        String relacion = perfilVista.ingresarRelacion();
        boolean encontrado = false;

        for (PerfilModelo usuario : listaPerfiles) {
            if (usuario.getNombre().equalsIgnoreCase(nombre) && usuario.getRelacion().equalsIgnoreCase(relacion)) {
                encontrado = true;
                return usuario;
            }
        }
        if (!encontrado) {
            System.out.println("\nNo existe el usuario.");
            inicio();
        }
        return null;
    }

    public void SeleccionarPerfil (ArrayList < PerfilModelo > listaPerfiles) {

        PerfilModelo perfil = verificarPerfil(listaPerfiles);
        int contador = 0;
        while (contador == 0){
            System.out.println("Hola, " + perfil + " que desea hacer:");
            int opcion = perfilVista.opcionesAdministrar();

            switch (opcion) {
                case 1:
                    medicinaControlador.administrarMedicamento(perfil);
                    break;
                case 2:
                    medicoControlador.administrarMedico(perfil);
                    break;
                case 3:
                    citaMedicaControlador.administrarCita(perfil);
                    break;
                case 4:
                    actividadFisicaControlador.administrarActividadFisica(perfil);
                    break;
                case 5:
                    contador++;
                    break;
            }
        } 
    }

    public void inicio(){
        int contador = 0;
        while(contador == 0){
            perfilVista.mostrarListaPerfiles(listaPerfilesModelo.getPerfiles());
            String opcion = perfilVista.opcionesIniciales();
            switch(opcion){
                case "a":
                    CrearPerfil();
                    break;
                case "b":
                    SeleccionarPerfil(listaPerfilesModelo.getPerfiles());
                    //contador++;
                    break;
                case "c":
                    contador++;
                    break;
            }
        }
    }
}

