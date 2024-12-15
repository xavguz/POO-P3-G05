package Controladores;

import vista.MedicinaVista;
import modelo.MedicinaModelo;
import modelo.PerfilModelo;

import java.util.ArrayList;

public class MedicinaControlador {

    private MedicinaVista medicinaVista;
    private PerfilModelo perfilModelo;
    private TomaMedicinaControlador tomaMedicinaControlador;
    
    public MedicinaControlador(MedicinaVista medicinaVista, 
                                PerfilModelo perfilModelo, TomaMedicinaControlador tomaMedicinaControlador){
        this.medicinaVista = medicinaVista;
        this.perfilModelo = perfilModelo;
        this.tomaMedicinaControlador = tomaMedicinaControlador;
    }

    public void añadirMedicina(PerfilModelo perfil){
        
        String nombreMedicina = medicinaVista.nombreMedicina();
        float cantidadUnidadesDisponibles = medicinaVista.cantidadUnidadesDisponibles();
        String presentacion = medicinaVista.presentacionMedicina();
        String frecuencia = medicinaVista.frecuencia();
        String frecuenciaDia = medicinaVista.frecuenciaDia();
        float dosis = medicinaVista.dosis();

        MedicinaModelo medicina = new MedicinaModelo(nombreMedicina, cantidadUnidadesDisponibles, presentacion,
                frecuencia, frecuenciaDia, dosis);
        perfil.getMedicinas().add(medicina);
        System.out.println("Se ha a agregado una nueva medicina: " + nombreMedicina);
    }
    
    public void eliminarMedicina(PerfilModelo perfil){
        ArrayList<MedicinaModelo> medicinasEliminar = new ArrayList<>();
        String medicinaEliminar;

        ArrayList<MedicinaModelo> listaMedicinas = perfilModelo.getMedicinas();

        medicinaVista.mostrarListaMedicinas(listaMedicinas);

        if (!listaMedicinas.isEmpty()){
            System.out.println("Ingresar la medicina a eliminar: ");
            medicinaEliminar = medicinaVista.sc.nextLine();
            for (MedicinaModelo medicina :listaMedicinas){
                if(medicina.getNombreMedicamento().equalsIgnoreCase(medicinaEliminar)){
                    medicinasEliminar.add(medicina);
                }
            }
            String consulta;

            System.out.println("Esta seguro de eliminar la medicina (SI/NO): ");
            consulta = medicinaVista.sc.nextLine();
            if (consulta.equalsIgnoreCase("si")) {
                listaMedicinas.removeAll(medicinasEliminar);
                if (!medicinasEliminar.isEmpty()) {
                    System.out.println("Medicina eliminada.");
                } else {
                    System.out.println("No se encontró la medicina.");
                }
            }
            else {
                administrarMedicamento(perfil);
            }
        } else {
            System.out.println("No hay medicinas a eliminar!");
        }
    }
    
    public void administrarMedicamento(PerfilModelo perfil){
        
        int contador = 0;

        while (contador == 0){
            medicinaVista.mostrarListaMedicinas(perfil.getMedicinas());

            System.out.println("Escoja lo que desee hacer: ");
            int opcion = medicinaVista.opcionesMedicamentos();
            medicinaVista.sc.nextLine();
            switch (opcion) {
                case 1:
                    añadirMedicina(perfil);
                    break;
                case 2:
                    eliminarMedicina(perfil);
                    break;
                case 3:
                    tomaMedicinaControlador.administrarTomas(perfil);
                    break;
                case 4:
                    contador++;
                    break;
            }
        }
    }
}