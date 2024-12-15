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

        if (listaCitas.size() < 2){
            citaMedicaVista.mostrarListaCitas(listaCitas);
        } else {
            ArrayList<CitaMedicaModelo> listaCitasOrdenada = ordenarCitaMedicas(listaCitas);
            citaMedicaVista.mostrarListaCitas(listaCitasOrdenada);
        }

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

            if (listaCitas.size() < 2){
                citaMedicaVista.mostrarListaCitas(listaCitas);
            } else {
                ArrayList<CitaMedicaModelo> listaCitasOrdenada = ordenarCitaMedicas(listaCitas);
                citaMedicaVista.mostrarListaCitas(listaCitasOrdenada);
            }

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

    public ArrayList<CitaMedicaModelo> ordenarCitaMedicas(ArrayList<CitaMedicaModelo> citasMedicas) {

        for (int i = 0; i < citasMedicas.size() - 1; i++){
            CitaMedicaModelo citaMedica1 = citasMedicas.get(i);
            int mes1 = Integer.parseInt(citaMedica1.getFecha().getMes());
            int dia1 = Integer.parseInt(citaMedica1.getFecha().getDia());
            int año1 = Integer.parseInt(citaMedica1.getFecha().getAño());

            CitaMedicaModelo citaMedica2 = citasMedicas.get(i + 1);
            int mes2 = Integer.parseInt(citaMedica2.getFecha().getMes());
            int dia2 = Integer.parseInt(citaMedica2.getFecha().getDia());
            int año2 = Integer.parseInt(citaMedica2.getFecha().getAño());

            if (año1 > año2){
                citasMedicas.set(i, citaMedica2);
                citasMedicas.set(i + 1, citaMedica1);

            } else if (año1 == año2){
                if (mes1 > mes2){
                    citasMedicas.set(i, citaMedica2);
                    citasMedicas.set(i + 1, citaMedica1);
                } else if (mes1 == mes2) {
                    if (dia1 > dia2){
                        citasMedicas.set(i, citaMedica2);
                        citasMedicas.set(i + 1, citaMedica1);
                    }

                }
            }

        }
        return citasMedicas;
    }
}
