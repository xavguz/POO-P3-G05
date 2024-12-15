package Controladores;

import modelo.FechaModelo;
import modelo.PerfilModelo;
import java.util.ArrayList;
import modelo.MedicinaModelo;
import modelo.TomaMedicinaModelo;
import vista.MedicinaVista;
import vista.TomaMedicinaVista;

public class TomaMedicinaControlador {
    private MedicinaVista medicinaVista;
    private TomaMedicinaVista tomaMedicinaVista;

    public TomaMedicinaControlador(MedicinaVista medicinaVista,TomaMedicinaVista tomaMedicinaVista){
        this.medicinaVista = medicinaVista;
        this.tomaMedicinaVista = tomaMedicinaVista;
    }

    public void registrarToma(PerfilModelo perfil){
        String dia;
        String mes;
        String año;
        String hora;
        
        ArrayList<TomaMedicinaModelo> listaTomas = perfil.getTomaMedicinas();
        ArrayList<MedicinaModelo> listaMedicinas = perfil.getMedicinas();


        if (!listaMedicinas.isEmpty()){
            String seleccionMedicamento = tomaMedicinaVista.nombreMedicina();
            for (MedicinaModelo medicina:listaMedicinas){
                if (medicina.getNombreMedicamento().equalsIgnoreCase(seleccionMedicamento)){

                    dia = tomaMedicinaVista.diaToma();
                    mes = tomaMedicinaVista.mesToma();
                    año = tomaMedicinaVista.añoToma();
                    hora = tomaMedicinaVista.horaToma();

                    FechaModelo fecha = new FechaModelo(dia,mes,año,hora);
                    TomaMedicinaModelo toma = new TomaMedicinaModelo(medicina, fecha);;
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

    public void administrarTomas(PerfilModelo perfil){
        
        ArrayList<TomaMedicinaModelo> listaTomas = perfil.getTomaMedicinas();
        ArrayList<MedicinaModelo> listaMedicinas = perfil.getMedicinas();

        int contador = 0;
        while (contador == 0) {

            medicinaVista.mostrarListaMedicinas(listaMedicinas);
            tomaMedicinaVista.mostrarListaTomas(listaTomas);

            System.out.println("Escoja lo que desee hacer: ");
            int opcion = tomaMedicinaVista.opcionesTomaMedicina();
            tomaMedicinaVista.sc.nextLine();
            switch (opcion) {
                case 1:
                    registrarToma(perfil);
                    break;
                case 2:
                    contador++;
                    break;
            }
        }
    }
}

