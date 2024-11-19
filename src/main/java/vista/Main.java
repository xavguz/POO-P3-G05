package vista;

import Controladores.PerfilControlador;

public class Main {
    public static void main(String[] args) {
        int contador = 0;

        while(contador == 0){
            String opcion = PerfilControlador.OpcionesIniciales();
            switch(opcion){
                case "a":
                    PerfilControlador.CrearPerfil();
                break;
                case "b":
                    PerfilControlador.SeleccionarPerfil(PerfilControlador.getListaUsuario());
                    contador++;
                break;
                case "c":
                    contador++;
                    break;
            }
            
        }
    }
}