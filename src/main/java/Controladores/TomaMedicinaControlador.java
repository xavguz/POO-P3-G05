package Controladores;

import modelo.Fecha;
import modelo.PerfilModelo;
import java.util.ArrayList;
import modelo.Medicina;
import modelo.MedicinaModelo;
import modelo.TomaMedicina;
import modelo.TomaMedicinaModelo;
import vista.FechaVista;
import vista.MedicinaVista;
import vista.TomaMedicinaVista;

public class TomaMedicinaControlador {
    private PerfilModelo perfilModelo;
    private MedicinaModelo medicinaModelo;
    private MedicinaVista medicinaVista;
    private TomaMedicinaModelo tomaMedicinaModelo;
    private TomaMedicinaVista tomaMedicinaVista;
    private FechaVista fechaVista;

    public TomaMedicinaControlador(PerfilModelo perfilModelo,MedicinaModelo medicinaModelo,MedicinaVista medicinaVista,
    TomaMedicinaModelo tomaMedicinaModelo,TomaMedicinaVista tomaMedicinaVista,FechaVista fechaVista){
        this.perfilModelo = perfilModelo;
        this.medicinaModelo = medicinaModelo;
        this.medicinaVista = medicinaVista;
        this.tomaMedicinaModelo = tomaMedicinaModelo;
        this.tomaMedicinaVista = tomaMedicinaVista;
        this.fechaVista = fechaVista;
    }


    public void registrarToma(String nombre,String relacion){

        int i = perfilModelo.obtenerIndice(nombre,relacion);
        ArrayList<TomaMedicina> listaTomas = tomaMedicinaModelo.obtenerTomaDePerfil(i);
        ArrayList<Medicina> listaMedicinas = medicinaModelo.obtenerMedicinasDePerfil(i);

        medicinaVista.mostrarListaMedicinas(listaMedicinas);
        tomaMedicinaVista.mostrarListaTomas(listaTomas);

        if (!listaMedicinas.isEmpty()){
            String seleccionMedicamento = tomaMedicinaVista.nombreMedicina();
            for (Medicina medicina:listaMedicinas){
                if (medicina.getNombreMedicamento().equalsIgnoreCase(seleccionMedicamento)){

                    String dia = fechaVista.dia();
                    String hora = fechaVista.hora();

                    Fecha fecha = new Fecha(dia,hora);
                    TomaMedicina toma = new TomaMedicina(medicina, fecha);
                    listaTomas.add(toma);

                    System.out.println("Se ha registrado la toma de [ " + medicina.getNombreMedicamento() + " ].");
                    tomaMedicinaVista.mostrarListaTomas(listaTomas);
                }
                else{
                    System.out.println("No esta el medicamento en los registros.");
                }
            }
        }else{
            System.out.println("No hay medicinas a regitrar toma!");
        }
    }
}
