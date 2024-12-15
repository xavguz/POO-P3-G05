package Controladores;

import modelo.FechaModelo;
import modelo.CitaMedicaModelo;
import modelo.MedicoModelo;
import modelo.PerfilModelo;
import vista.CitaMedicaVista;
import vista.MedicoVista;
import java.util.ArrayList;

public class CitaMedicaControlador {
    private CitaMedicaVista citaMedicaVista;
    private MedicoVista medicoVista;

    public CitaMedicaControlador(CitaMedicaVista citaMedicaVista, MedicoVista medicoVista){
        this.citaMedicaVista = citaMedicaVista;
        this.medicoVista = medicoVista;
    }
    
    public void agregarCitas(PerfilModelo perfil){
        String titulo;
        String dia;
        String mes;
        String año;
        String hora;

        ArrayList<CitaMedicaModelo> listaCitas = perfil.getCitaMedicas();
        ArrayList<MedicoModelo> listaMedicos = perfil.getMedicos();

        citaMedicaVista.mostrarListaCitas(listaCitas);

        titulo = citaMedicaVista.tituloCita();
        
        medicoVista.mostrarListaMedicos(listaMedicos);
        
        if (!listaMedicos.isEmpty()){
            String nombreMedico = citaMedicaVista.nombreMedico();
            
            for(MedicoModelo medico : listaMedicos){
                if (medico.getNombre().equalsIgnoreCase(nombreMedico)){
                    dia = citaMedicaVista.diaCita();
                    mes = citaMedicaVista.mesCita();
                    año = citaMedicaVista.añoCita();
                    hora = citaMedicaVista.horaCita();

                    FechaModelo fecha = new FechaModelo(dia,mes,año,hora);
                    CitaMedicaModelo cita = new CitaMedicaModelo(titulo, fecha, medico);
                    listaCitas.add(cita);
                }
                else{
                    System.out.println("\nEl médico no esta en su registro. ");
                }
            }
        }else{
            System.out.println("No hay Medicos en los registros.");
        }
    }

    public void administrarCita(PerfilModelo perfil){
        int contador = 0;

        ArrayList<CitaMedicaModelo> listaCitas = perfil.getCitaMedicas();

        while (contador == 0){

            citaMedicaVista.mostrarListaCitas(listaCitas);

            System.out.println("Escoja lo que desee hacer:");
            int opcion = citaMedicaVista.opcionesCita();
            citaMedicaVista.sc.nextLine();
            switch (opcion) {
                case 1:
                    agregarCitas(perfil);
                    break;
                case 2:
                    contador++;
                    break;
            }
        }
    }
}
