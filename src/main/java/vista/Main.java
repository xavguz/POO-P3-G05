package vista;

import Controladores.Funciones;
import modelo.Perfil;

public class Main {
    public static void main(String[] args) {
        int contador = 0;
        while(contador == 0){
            String opcion = Funciones.Opciones();
            switch(opcion){
                case "a":
                    Funciones.CrearPerfil();
                break;
                case "b":
                    Funciones.SeleccionarPerfil(Perfil.getListaUsuarios());
                    contador += 1;
                break;
            }
        }
    }
}