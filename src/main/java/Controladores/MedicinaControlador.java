package Controladores;

import java.util.ArrayList;
import modelo.PerfilModelo;
import modelo.enums.*;
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

    public int OpcionesMedicamentos(){
        int opcion;
        
        do {
            System.out.println("1. Añadir Medicina.\n" + //
                                "2. Eliminar Medicina.\n" + //
                                "3. Registrar Toma.\n" + //
                                "4. Volver.");
            opcion = medicinaVista.sc.nextInt();

        }while(opcion == 1 && opcion == 2 && opcion == 3 && opcion == 4);
        return opcion;
    }

    public void añadirMedicina(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre,relacion);
        ArrayList<String> diasSeleccionados = new ArrayList<String>();
        ArrayList<String> horas = new ArrayList<String>();
        String nombreMedicamento;
        float cantidadUnidades;
        String presentacion;
        String frecuencia;
        String frecuenciaDia;
        float dosis;
        int opcion;
        int variable;
        String hora;

        System.out.print("Nombre del Medicamento: ");
        nombreMedicamento = medicinaVista.sc.nextLine();

        System.out.print("Cantidad de unidades disponibles a consumir: ");
        cantidadUnidades = medicinaVista.sc.nextFloat();
        medicinaVista.sc.nextLine();

        System.out.println("Seleccione una opción de presentación (Ingrese un numero del 1 al 6):");
        variable = 1;
        for (Presentacion p : Presentacion.values()) {
            System.out.println(variable + ". " + p);
            variable++;
        }
        opcion = medicinaVista.sc.nextInt();
        medicinaVista.sc.nextLine();
        switch (opcion) {
            case 1:
                presentacion = Presentacion.PASTILLA.name();
                break;
            case 2:
                presentacion = Presentacion.INYECCION.name();
                break;
            case 3:
                presentacion = Presentacion.SOLUCION.name();
                break;
            case 4:
                presentacion = Presentacion.GOTAS.name();
                break;
            case 5:
                presentacion = Presentacion.INHALADOR.name();
                break;
            case 6:
                presentacion = Presentacion.POLVO.name();
                break;
            default:
                presentacion = null;
                break;

        }

        System.out.println("Seleccione la frecuencia (Ingrese un numero del 1 al 6):");
        variable = 1;
        for (Frecuencia f : Frecuencia.values()) {
            System.out.println(variable + ". "+f);
            variable++;
        }

        opcion = medicinaVista.sc.nextInt();
        medicinaVista.sc.nextLine();
        switch (opcion) {
            case 1:
                frecuencia = Frecuencia.CADA_DIA.name();
                break;
            case 2:
                frecuencia = Frecuencia.CADA_DOS_DIAS.name();
                break;
            case 3:
                int n = 0;
                variable = 1;
                for(Dias dia : Dias.values()) {
                    System.out.println(variable + ". " +dia);
                    variable++;
                }

                while(n == 0) {
                    System.out.print("Seleccionar los días (del 1 al 7):\n Presione ENTER para continuar. ");
                    String dia = medicinaVista.sc.nextLine();
                    switch (dia) {
                        case "1":
                            diasSeleccionados.add("LUNES");
                            break;
                        case "2":
                            diasSeleccionados.add("MARTES");
                            break;
                        case "3":
                            diasSeleccionados.add("MIERCOLES");
                            break;
                        case "4":
                            diasSeleccionados.add("JUEVES");
                            break;
                        case "5":
                            diasSeleccionados.add("VIERNES");
                            break;
                        case "6":
                            diasSeleccionados.add("SABADO");
                            break;
                        case "7":
                            diasSeleccionados.add("DOMINGO");
                            break;
                        default:
                            n++;
                            break;
                    }
                }
                frecuencia = "DIAS [ " + String.join("/", diasSeleccionados) + " ] ";
                diasSeleccionados.clear();
                break;
            case 4:
                System.out.println("Cantidad de días: ");
                String dias = medicinaVista.sc.nextLine();
                frecuencia = "CADA_" + dias + "_DIAS";
                break;
            case 5:
                System.out.println("Cantidad de semanas: ");
                String semanas = medicinaVista.sc.nextLine();
                frecuencia = "CADA_" + semanas + "_SEMANAS";
                break;
            case 6:
                System.out.println("Cantidad de meses: ");
                String meses = medicinaVista.sc.nextLine();
                frecuencia = "CADA_" + meses + "_DIAS";
                break;
            default:
                frecuencia = null;
        }

        System.out.println("Seleccione la frecuencia en el dia (Ingrese un numero del 1 al 4):");
        variable = 1;
        for (FrecuenciaDia fDia : FrecuenciaDia.values()) {
            System.out.println(variable + ". " + fDia);
            variable++;
        }

        opcion = medicinaVista.sc.nextInt();
        medicinaVista.sc.nextLine();

        int contador;
        switch (opcion) {
            case 1:
                frecuenciaDia = FrecuenciaDia.UNA_VEZ_AL_DIA.name();
                System.out.println("Ingrese la hora para la toma (hh:mm): ");
                hora = medicinaVista.sc.nextLine();
                frecuenciaDia += " [ " + hora + " ]";
                break;
            case 2:
                frecuenciaDia = FrecuenciaDia.DOS_VECES_AL_DIA.name() + " [ ";
                contador = 0;
                while(contador < 2){
                    System.out.println("Ingrese la hora para la toma (hh:mm): ");
                    hora = medicinaVista.sc.nextLine();
                    horas.add(hora);
                    contador++;
                }
                frecuenciaDia += String.join("/",horas) + " ]";
                horas.clear();
                break;
            case 3:
                frecuenciaDia = FrecuenciaDia.TRES_VECES_AL_DIA.name() + " [ ";
                contador = 0;
                while(contador < 3){
                    System.out.println("Ingrese la hora para la toma (hh:mm): ");
                    hora = medicinaVista.sc.nextLine();
                    horas.add(hora);
                    contador++;
                }
                frecuenciaDia += String.join("/",horas) + " ]";
                horas.clear();

                break;
            default:
                frecuenciaDia = null;
                break;
        }

        System.out.println("Ingrese la dosis a tomar de la medicina (gramos): ");
        dosis = medicinaVista.sc.nextFloat();
        medicinaVista.sc.nextLine();

        Medicina medicina = new Medicina(nombreMedicamento, cantidadUnidades,presentacion, frecuencia, frecuenciaDia, dosis);
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
            int opcion = OpcionesMedicamentos();
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
