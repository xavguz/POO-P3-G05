package modelo;

import java.util.Objects;

public class Perfil {

    private String nombreUsuario;
    private String relacion;
    private String email;
    
    public Perfil(String nombreUsuario, String relacion, String email){
        this.nombreUsuario = nombreUsuario;
        this.relacion = relacion;
        this.email = email;
    }

    public Perfil(String nombreUsuario, String relacion){
        this(nombreUsuario, relacion,null);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario){
        this.nombreUsuario = nombreUsuario;
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
    /*  @Override
    public boolean equals(Object p) {
        if (this == p) return true;
        if (o == null || getClass() != p.getClass()) return false;
        Perfil perfil = (Perfil) p;
        return Objects.equals(nombreUsuario, perfil.nombreUsuario) &&
               Objects.equals(relacion, perfil.relacion) &&
               Objects.equals(email, perfil.email);*/
               
}
