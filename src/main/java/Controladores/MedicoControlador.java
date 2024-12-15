package Controladores;
import modelo.MedicoModelo;
import modelo.PerfilModelo;
import vista.MedicoVista;

public class MedicoControlador {
    private MedicoVista medicoVista;

    public MedicoControlador(MedicoVista medicoVista){
        this.medicoVista = medicoVista;
    }

    public void añadirMedico(PerfilModelo perfil){

        String nombreMedico = medicoVista.nombreMedico();
        String especialidad = medicoVista.especialidadMedico();
        String numeroTelefono = medicoVista.telefonoMedico();
        String email = medicoVista.correoMedico();
        String direccion = medicoVista.direccionMedico();

        MedicoModelo medico = new MedicoModelo(nombreMedico, especialidad, numeroTelefono, email, direccion);
        perfil.getMedicos().add(medico);

        System.out.println("Se ha añadido al Medico: " + medico);

    }

    public void administrarMedico(PerfilModelo perfil){
        int contador = 0;

        while(contador == 0){
            medicoVista.mostrarListaMedicos(perfil.getMedicos());
            System.out.println("Escoja lo que desee hacer: ");
            int opcion = medicoVista.opcionesMedico();
            medicoVista.sc.nextLine();
            switch (opcion) {
                case 1:
                    añadirMedico(perfil);
                    break;
                case 2:
                    contador++;
                    break;
            }
        }  
    }  
}

