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
    
    public int OpcionesMedico(){
        int opcion;
        
        do {
            System.out.println("1. Añadir Médico.\n2. Volver.");
            opcion = medicoVista.sc.nextInt();
            medicoVista.sc.nextLine();
        }while(opcion == 1 && opcion == 2);
        return opcion;
    }

    public void añadirMedico(String nombre,String relacion){
        int i = perfilModelo.obtenerIndice(nombre, relacion);
        String nombreMedico;
        String especialidad;
        String numeroTelefono;
        String email;
        String direccion;
        int numero;

        System.out.println("Ingrese nombre: ");
        nombreMedico = medicoVista.sc.nextLine();

        numero = 1;
        for (Especialidades e:Especialidades.values() ){
            System.out.println(numero + ". " + e);
            numero++;
        }
        System.out.print("Ingrese Especialidad (numero del 1 al 10): ");
        int opcion= medicoVista.sc.nextInt();
        medicoVista.sc.nextLine();
       
        switch (opcion){
            case 1:
            especialidad= Especialidades.MEDICINA_GENERAL.name();
            break;
            case 2:
            especialidad= Especialidades.CARDIOLOGIA.name();
            break;
            case 3:
            especialidad= Especialidades.DERMATOLOGIA.name();
            break;
            case 4:
            especialidad= Especialidades.ENDOCRINOLOGIA.name();
            break;
            case 5:
            especialidad= Especialidades.GASTROENTEROLOGIA.name();
            break;
            case 6:
            especialidad= Especialidades.GERIATRIA.name();
            break;
            case 7:
            especialidad= Especialidades.NEUROLOGIA.name();
            break;
            case 8:
            especialidad= Especialidades.PEDIATRIA.name();
            break;
            case 9:
            especialidad= Especialidades.PSIQUIATRIA.name();
            break;
            default:
            especialidad= Especialidades.TRAUMATOLOGIA.name();
            break;
        }

        System.out.print("Ingrese teléfono: ");
        numeroTelefono = medicoVista.sc.nextLine();
            
        System.out.print("Ingrese correo: ");
        email= medicoVista.sc.nextLine();

        System.out.print("Ingrese dirección: ");
        direccion= medicoVista.sc.nextLine();

        Medico medico = new Medico(nombreMedico, especialidad, numeroTelefono, email, direccion);
        
        medicoModelo.agregarMedico(i, medico);

        System.out.println("Se ha añadido al Medico: " + medico);

    }

    public void administrarMedico(String nombre,String relacion){

        int i = perfilModelo.obtenerIndice(nombre, relacion);
        
        int contador = 0;
        while(contador == 0){
            
            medicoVista.mostrarListaMedicos(medicoModelo.obtenerListaMedicos(i));

            int opcion = OpcionesMedico();
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

