package Controladores;

import java.util.ArrayList;
import modelo.PerfilModelo;
import modelo.medicina.*;
import vista.MedicinaVista;
import modelo.medicina.MedicinaModelo;

public class MedicinaControlador {

    private MedicinaModelo medicinaModelo;
    private MedicinaVista medicinaVista;
    private PerfilModelo perfilModelo;
    private TomaMedicinaControlador tomaMedicinaControlador;
    
    public MedicinaControlador(MedicinaModelo medicinaModelo, MedicinaVista medicinaVista, 
                                PerfilModelo perfilModelo, TomaMedicinaControlador tomaMedicinaControlador){
        this.medicinaModelo = medicinaModelo;
        this.medicinaVista = medicinaVista;
        this.perfilModelo = perfilModelo;
        this.tomaMedicinaControlador = tomaMedicinaControlador;
    }

    public void añadirMedicina(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre,relacion);
        ArrayList<Object> datosMedicina = medicinaVista.medicina();
        
        String nombreMedicamento = (String) datosMedicina.get(0);
        float cantidadUnidades = (float) datosMedicina.get(1);
        String presentacion = (String) datosMedicina.get(2);
        String frecuencia = (String) datosMedicina.get(3);
        String frecuenciaDia = (String) datosMedicina.get(4);
        float dosis = (float) datosMedicina.get(5);
        
        Medicina medicina = new Medicina(nombreMedicamento, cantidadUnidades,presentacion, 
                                        frecuencia, frecuenciaDia, dosis);
        medicinaModelo.agregarMedicina(i, medicina);
        System.out.println("Se añadio la medicina " + medicina);
    }
    
    public void eliminarMedicina(String nombre,String relacion){
        ArrayList<Medicina> medicinasEliminar = new ArrayList<>();
        String medicinaEliminar;

        int i = perfilModelo.obtenerIndice(nombre,relacion);
        ArrayList<Medicina> listaMedicinas = medicinaModelo.obtenerMedicinasDePerfil(i);

        medicinaVista.mostrarListaMedicinas(listaMedicinas);

        System.out.println("Ingresar la medicina a eliminar: ");
        medicinaEliminar = medicinaVista.sc.nextLine();

        for (Medicina medicina :listaMedicinas){
            if(medicina.getNombreMedicamento().equalsIgnoreCase(medicinaEliminar)){
                medicinasEliminar.add(medicina);
            }
        }
        String consulta;

        System.out.println("Esta seguro de eliminar la medicna (SI/NO): ");
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
            administrarMedicamento(nombre,relacion);
        }
    }
    
    public void administrarMedicamento(String nombre, String relacion){
        int i = perfilModelo.obtenerIndice(nombre,relacion);
        int contador = 0;
        while (contador == 0){
            medicinaVista.mostrarListaMedicinas(medicinaModelo.obtenerMedicinasDePerfil(i));

            System.out.println("Escoja lo que desee hacer: ");
            int opcion = medicinaVista.opcionesMedicamentos();
            medicinaVista.sc.nextLine();
            switch (opcion) {
                case 1:
                    añadirMedicina(nombre,relacion);
                    break;
                case 2:
                    eliminarMedicina(nombre,relacion);
                    break;
                case 3:
                    tomaMedicinaControlador.registrarToma(nombre,relacion);
                    break;
                case 4:
                    contador++;
                    break;
            }
        }
    }
}