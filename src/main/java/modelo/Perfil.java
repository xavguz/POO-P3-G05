package modelo;

import java.util.Objects;

public class Perfil {

    private String nombre;
    private String relacion;
    private String email;
    
    public Perfil(String nombre, String relacion, String email){
        this.nombre = nombre;
        this.relacion = relacion;
        this.email = email;
    }

    public Perfil(String nombreUsuario, String relacion){
        this(nombreUsuario, relacion,null);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombreUsuario){
        this.nombre = nombreUsuario;
    }

    public String getRelacion() {
        return relacion;
    }

    public void setRelacion(String relacion){
        this.relacion = relacion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }
    
    @Override
    public String toString(){
        return nombre + " (" + relacion + ").";
    }

    public boolean equals(Object p) {
        if (p != null && p instanceof Perfil) {
            Perfil perfil = (Perfil) p;
            if (Objects.equals(nombre.toLowerCase(), perfil.nombre.toLowerCase()) &&
                    Objects.equals(relacion, perfil.relacion)){
                        return true;
                    }
            }
        return false;
    }     
}
