package Controladores;

import modelo.Perfil;
import modelo.PerfilModelo;
import modelo.medicina.MedicinaModelo;
import modelo.medicina.TomaMedicinaModelo;
import vista.PerfilVista;
import java.util.ArrayList;

public class PerfilControlador {

    private PerfilModelo perfilModelo;
    private PerfilVista perfilVista;
    private TomaMedicinaModelo tomaMedicinaModelo;
    private MedicinaModelo medicinaModelo;
    private MedicinaControlador medicinaControlador;

    public PerfilControlador(PerfilModelo perfilModelo,PerfilVista perfilVista, TomaMedicinaModelo tomaMedicinaModelo,
                            MedicinaModelo medicinaModelo, MedicinaControlador medicinaControlador){
        this.perfilModelo = perfilModelo;
        this.perfilVista = perfilVista;
        this.tomaMedicinaModelo = tomaMedicinaModelo;
        this.medicinaModelo = medicinaModelo;
        this.medicinaControlador = medicinaControlador;
    }

    public String OpcionesIniciales(){
        
        perfilVista.mostrarListaPerfiles(perfilModelo.getListaPerfiles());

        String opcion;

        do {
            System.out.println("a.Crear perfil \nb.Seleccionar perfil \nc.Cerrar");
            opcion = perfilVista.sc.nextLine().toLowerCase();
        }while(!opcion.equals("a") && !opcion.equals("b") && !opcion.equals("c"));
        return opcion;
    }

    public int OpcionesAdministrar(){
        int opcion;
        
        do {
            System.out.println("1. Administrar Medicamentos.\n" + //
                                "2. Administrar Médicos.\n" + //
                                "3. Administrar Citas Médicas.\n" + //
                                "4. Administrar Actividad Fisica.\n" + //
                                "5. Volver.");
            opcion = perfilVista.sc.nextInt();
            perfilVista.sc.nextLine();
        }while(opcion == 1 && opcion == 2 && opcion == 3 && opcion == 4 && opcion == 5);
        return opcion;
    }

    public void  CrearPerfil() {
        System.out.println("Ingrese su nombre: ");
        String nombre = perfilVista.sc.nextLine();
        System.out.println("Ingrese su relación: ");
        String relacion = perfilVista.sc.nextLine();
        System.out.println("Ingrese su email(NO obligatorio): ");
        String email = perfilVista.sc.nextLine();

        if (!email.isEmpty()) {
            email = "No tiene email.";
        }
        Perfil perfil = new Perfil(nombre, relacion, email);

        if (!perfilModelo.getListaPerfiles().contains(perfil)){
            perfilModelo.getListaPerfiles().add(perfil);
            medicinaModelo.inicializarListaMedicinaParaPerfil();
            tomaMedicinaModelo.inicializarListaTomas();
            
        }else{
            System.out.println("El perfil ya existe.\n");
        }
        
    }

    public void SeleccionarPerfil (ArrayList < Perfil > listaPerfiles) {

        perfilVista.mostrarListaPerfiles(listaPerfiles);
        
        System.out.println("Seleccine un perfil: ");

        String nombre = perfilVista.sc.nextLine();
        boolean encontrado = false;

        for (Perfil usuario : listaPerfiles) {
            if (usuario.getNombre().equalsIgnoreCase(nombre)) {
                encontrado = true;
                int contador = 0;

                while (contador == 0){
                    System.out.println("Hola, " + nombre + " que desea hacer:");
                    int opcion = OpcionesAdministrar();
                    switch (opcion) {
                        case 1:
                            medicinaControlador.administrarMedicamento(nombre);
                            break;
                        case 2:
                            MedicoControlador.administrarMedico();
                            break;
                        case 3:
                            CitasMedicasControlador.administrarCita();
                            break;
                        case 4:
                            ActividadFisicaControlador.administrarActividadFisica();
                            break;
                        case 5:
                        contador++;
                            break;
    
                    }
                }   
            }
        }
        if (encontrado == false) {
            System.out.println("\nNo existe el usuario.");
        }
    }

    public void inicio(){
        int contador = 0;
        while(contador == 0){
            String opcion = OpcionesIniciales();
            switch(opcion){
                case "a":
                    CrearPerfil();
                    break;
                case "b":
                    SeleccionarPerfil(perfilModelo.getListaPerfiles());
                    //contador++;
                    break;
                case "c":
                    contador++;
                    break;
            }
        }
    }
}

