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

    public int opcionesCita(){
        int opcion;
        
        do {
            System.out.println("1. Agregar Cita.\n" + //
                                "2. Volver.\n");
            opcion = citaMedicaVista.sc.nextInt();
            citaMedicaVista.sc.nextLine();
        }while(opcion == 1 && opcion == 2);
        return opcion;
    }
    
    public void agregarCitas(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre, relacion);
        String titulo;
        String dia;
        String hora;

        ArrayList<CitaMedica> listaCitas = citaMedicaModelo.obtenerListaCitas(i);
        ArrayList<Medico> listaMedicos = medicoModelo.obtenerListaMedicos(i);

        citaMedicaVista.mostrarListaCitas(listaCitas);

        System.out.print("Ingrese el título de la cita: ");
        titulo = citaMedicaVista.sc.nextLine();
        
        medicoVista.mostrarListaMedicos(listaMedicos);
        
        System.out.print("Elija un médico(nombre): ");
        String nombreMedico = medicoVista.sc.nextLine();
        
        for(Medico medico : listaMedicos){
            if (medico.getNombre().equalsIgnoreCase(nombreMedico)){
                System.out.println("Ingrese el dia de la cita: ");
                dia = citaMedicaVista.sc.nextLine();
                System.out.println("Ingrese la hora de la cita: ");
                hora = citaMedicaVista.sc.nextLine();

                Fecha fecha = new Fecha(dia,hora);
                CitaMedica cita = new CitaMedica(titulo, fecha, medico);
                citaMedicaModelo.agregarCitaPerfil(i, cita);
            }
            else{
                System.out.println("\nEl médico no esta en su registro. ");
            }
        }
    }

    public void administrarCita(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre,relacion);
        int contador = 0;

        ArrayList<CitaMedica> listaCitas = citaMedicaModelo.obtenerListaCitas(i);

        while (contador == 0){

            citaMedicaVista.mostrarListaCitas(listaCitas);

            System.out.println("Escoja lo que desee hacer:");
            int opcion = opcionesCita();
            
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
