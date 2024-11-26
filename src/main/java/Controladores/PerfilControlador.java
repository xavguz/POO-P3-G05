package Controladores;

import modelo.CitaMedicaModelo;
import modelo.MedicoModelo;
import modelo.Perfil;
import modelo.PerfilModelo;
import modelo.actividadfisica.ActividadFisicaModelo;
import modelo.medicina.MedicinaModelo;
import modelo.medicina.TomaMedicinaModelo;
import vista.ActividadFisicaVista;
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

    public String OpcionesIniciales(){
        
        perfilVista.mostrarListaPerfiles(perfilModelo.getListaPerfiles());

        String opcion;

        do {
            System.out.println("a.Crear perfil \nb.Seleccionar perfil \nc.Cerrar");
            opcion = perfilVista.sc.nextLine().toLowerCase();
        }while(!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c"));
        return opcion;
    }

    public int OpcionesAdministrar(){
        int opcion;
        
        do {
            System.out.println("1. Administrar Medicamentos.\n" + //
                                "2. Administrar Médicos.\n" + //
                                "3. Administrar Citas Médicas.\n" + //
                                "4. Administrar Actividad Fisica.\n" + //
                                "5. Volver.");
            opcion = perfilVista.sc.nextInt();
            perfilVista.sc.nextLine();
        }while(opcion == 1 && opcion == 2 && opcion == 3 && opcion == 4 && opcion == 5);
        return opcion;
    }

    public void  CrearPerfil() {
        String nombre = perfilVista.IngresarNombre();
        String relacion = perfilVista.IngresarRelacion();
        String email = perfilVista.IngresarEmail();
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
        System.out.println("Ingrese el nombre:");
        String nombre = perfilVista.sc.nextLine();
        System.out.println("Ingrese la relacion");
        String relacion = perfilVista.sc.nextLine();
        boolean encontrado = false;

        for (Perfil usuario : listaPerfiles) {
            if (usuario.getNombre().equalsIgnoreCase(nombre) && usuario.getRelacion().equalsIgnoreCase(relacion)) {
                encontrado = true;
                int contador = 0;

                while (contador == 0){
                    System.out.println("Hola, " + usuario + " que desea hacer:");
                    int opcion = OpcionesAdministrar();
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
        if (encontrado == false) {
            System.out.println("\nNo existe el usuario.");
        }
    }

    public void inicio(){
        int contador = 0;
        while(contador == 0){
            String opcion = OpcionesIniciales();
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

