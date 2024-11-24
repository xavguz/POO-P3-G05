package Controladores;

import modelo.Fecha;
import modelo.PerfilModelo;
import java.util.ArrayList;
import modelo.medicina.Medicina;
import modelo.medicina.MedicinaModelo;
import modelo.medicina.TomaMedicina;
import modelo.medicina.TomaMedicinaModelo;
import vista.MedicinaVista;
import vista.TomaMedicinaVista;

public class TomaMedicinaControlador {
    private PerfilModelo perfilModelo;
    private MedicinaModelo medicinaModelo;
    private MedicinaVista medicinaVista;
    private TomaMedicinaModelo tomaMedicinaModelo;
    private TomaMedicinaVista tomaMedicinaVista;

    public TomaMedicinaControlador(PerfilModelo perfilModelo,MedicinaModelo medicinaModelo,MedicinaVista medicinaVista,
    TomaMedicinaModelo tomaMedicinaModelo,TomaMedicinaVista tomaMedicinaVista){
        this.perfilModelo = perfilModelo;
        this.medicinaModelo = medicinaModelo;
        this.medicinaVista = medicinaVista;
        this.tomaMedicinaModelo = tomaMedicinaModelo;
        this.tomaMedicinaVista = tomaMedicinaVista;
    }


    public void registrarToma(String nombre){

        int i = perfilModelo.obtenerIndice(nombre);
        ArrayList<TomaMedicina> listaTomas = tomaMedicinaModelo.obtenerTomaDePerfil(i);
        ArrayList<Medicina> listaMedicinas = medicinaModelo.obtenerMedicinasDePerfil(i);

        medicinaVista.mostrarListaMedicinas(listaMedicinas);
        tomaMedicinaVista.mostrarListaTomas(listaTomas);

        System.out.println("Escriba un medicamento a registrar toma: ");
        String seleccionMedicamento = tomaMedicinaVista.sc.nextLine();

        for (Medicina medicina:listaMedicinas){
            if (medicina.getNombreMedicamento().equalsIgnoreCase(seleccionMedicamento)){
                String dia;
                String hora;

                System.out.println("Ingrese el dia de la toma: ");
                dia = tomaMedicinaVista.sc.nextLine();
                System.out.println("Ingrese la hora de la toma (hh:mm): ");
                hora = tomaMedicinaVista.sc.nextLine();

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
    }
}
