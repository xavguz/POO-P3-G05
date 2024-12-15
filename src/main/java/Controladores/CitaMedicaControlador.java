package Controladores;

import modelo.Fecha;
import modelo.CitaMedica;
import modelo.CitaMedicaModelo;
import modelo.Medico;
import modelo.MedicoModelo;
import modelo.PerfilModelo;
import vista.CitaMedicaVista;
import vista.MedicoVista;
import java.util.ArrayList;

public class CitaMedicaControlador {
    private CitaMedicaModelo citaMedicaModelo;
    private CitaMedicaVista citaMedicaVista;
    private PerfilModelo perfilModelo;
    private MedicoModelo medicoModelo;
    private MedicoVista medicoVista;

    public CitaMedicaControlador(CitaMedicaModelo citaMedicaModelo,CitaMedicaVista citaMedicaVista,
    PerfilModelo perfilModelo, MedicoModelo medicoModelo, MedicoVista medicoVista){
        this.citaMedicaModelo = citaMedicaModelo;
        this.citaMedicaVista = citaMedicaVista;
        this.perfilModelo = perfilModelo;
        this.medicoModelo = medicoModelo;
        this.medicoVista = medicoVista;
    }

    
    public void agregarCitas(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre, relacion);
        String titulo;
        String dia;
        String mes;
        String año;
        String hora;

        ArrayList<CitaMedica> listaCitas = citaMedicaModelo.obtenerListaCitas(i);
        ArrayList<Medico> listaMedicos = medicoModelo.obtenerListaMedicos(i);

        citaMedicaVista.mostrarListaCitas(listaCitas);

        titulo = citaMedicaVista.tituloCita();
        
        medicoVista.mostrarListaMedicos(listaMedicos);
        
        if (!listaMedicos.isEmpty()){
            String nombreMedico = citaMedicaVista.nombreMedico();
            
            for(Medico medico : listaMedicos){
                if (medico.getNombre().equalsIgnoreCase(nombreMedico)){
                    dia = citaMedicaVista.diaCita();
                    mes = citaMedicaVista.mesCita();
                    año = citaMedicaVista.añoCita();
                    hora = citaMedicaVista.horaCita();

                    Fecha fecha = new Fecha(dia,mes,año,hora);
                    CitaMedica cita = new CitaMedica(titulo, fecha, medico);
                    citaMedicaModelo.agregarCitaPerfil(i, cita);
                }
                else{
                    System.out.println("\nEl médico no esta en su registro. ");
                }
            }
        }else{
            System.out.println("No hay Medicos en los registros.");
        }
    }

    public void administrarCita(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre,relacion);
        int contador = 0;

        ArrayList<CitaMedica> listaCitas = citaMedicaModelo.obtenerListaCitas(i);

        while (contador == 0){

            citaMedicaVista.mostrarListaCitas(listaCitas);

            System.out.println("Escoja lo que desee hacer:");
            int opcion = citaMedicaVista.opcionesCita();
            citaMedicaVista.sc.nextLine();
            switch (opcion) {
                case 1:
                    agregarCitas(nombre,relacion);
                    break;
                case 2:
                    contador++;
                    break;
            }
        }
    }
}
