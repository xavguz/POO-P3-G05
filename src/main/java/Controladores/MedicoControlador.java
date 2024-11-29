package Controladores;
import modelo.MedicoModelo;
import modelo.PerfilModelo;
import modelo.Medico;
import modelo.enums.Especialidades;
import vista.MedicoVista;

public class MedicoControlador {
    private PerfilModelo perfilModelo;
    private MedicoModelo medicoModelo;
    private MedicoVista medicoVista;

    public MedicoControlador(PerfilModelo perfilModelo, MedicoModelo medicoModelo, MedicoVista medicoVista){
        this.perfilModelo = perfilModelo;
        this.medicoModelo = medicoModelo;
        this.medicoVista = medicoVista;
    }

    public void añadirMedico(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre, relacion);

        String nombreMedico = medicoVista.nombreMedico();
        String especialidad = medicoVista.especialidadMedico();
        String numeroTelefono = medicoVista.telefonoMedico();
        String email = medicoVista.correoMedico();
        String direccion = medicoVista.direccionMedico();

        Medico medico = new Medico(nombreMedico, especialidad, numeroTelefono, email, direccion);

        medicoModelo.agregarMedico(i, medico);

        System.out.println("Se ha añadido al Medico: " + medico);

    }

    public void administrarMedico(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre, relacion);
        int contador = 0;

        while(contador == 0){
            medicoVista.mostrarListaMedicos(medicoModelo.obtenerListaMedicos(i));
            System.out.println("Escoja lo que desee hacer: ");
            int opcion = medicoVista.opcionesMedico();
            medicoVista.sc.nextLine();
            switch (opcion) {
                case 1:
                    añadirMedico(nombre,relacion);
                    break;
                case 2:
                    contador++;
                    break;
            }
        }  
    }  
}

