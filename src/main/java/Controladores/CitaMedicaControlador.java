package Controladores;

import modelo.Fecha;
import modelo.CitaMedica;
import modelo.CitaMedicaModelo;
import modelo.Medico;
import modelo.MedicoModelo;
import modelo.PerfilModelo;
import vista.CitaMedicaVista;
import vista.FechaVista;
import vista.MedicoVista;
import java.util.ArrayList;

public class CitaMedicaControlador {
    private CitaMedicaModelo citaMedicaModelo;
    private CitaMedicaVista citaMedicaVista;
    private PerfilModelo perfilModelo;
    private MedicoModelo medicoModelo;
    private MedicoVista medicoVista;
    private FechaVista fechaVista;

    public CitaMedicaControlador(CitaMedicaModelo citaMedicaModelo,CitaMedicaVista citaMedicaVista,
    PerfilModelo perfilModelo, MedicoModelo medicoModelo, MedicoVista medicoVista, FechaVista fechaVista){
        this.citaMedicaModelo = citaMedicaModelo;
        this.citaMedicaVista = citaMedicaVista;
        this.perfilModelo = perfilModelo;
        this.medicoModelo = medicoModelo;
        this.medicoVista = medicoVista;
        this.fechaVista = fechaVista;
    }

    
    public void agregarCitas(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre, relacion);
        String titulo;
        String dia;
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
                    dia = fechaVista.dia();
                    hora = fechaVista.hora();

                    Fecha fecha = new Fecha(dia,hora);
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
