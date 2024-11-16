package vista;

import Controladores.PerfilControlador;
import modelo.Perfil;

public class Main {
    public static void main(String[] args) {
        int contador = 0;

        System.out.println("-----------");
        System.out.println("  Bienvenido");
        System.out.println("-----------");

        while(contador == 0){
            String opcion = PerfilControlador.Opciones();
            switch(opcion){
                case "a":
                    PerfilControlador.CrearPerfil();
                break;
                case "b":
                    PerfilControlador.SeleccionarPerfil(PerfilControlador.getListaUsuario());
                    contador += 1;
                break;
                case "c":
                    contador += 1;
                    break;
            }
        }
    }
}