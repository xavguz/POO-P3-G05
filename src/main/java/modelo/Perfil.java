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
    
    @Override
    public boolean equals(Object p) {
        if (p != null && p instanceof Perfil) {
            Perfil perfil = (Perfil) p;
            if (Objects.equals(nombreUsuario.toLowerCase(), perfil.nombreUsuario.toLowerCase()) &&
                    Objects.equals(relacion, perfil.relacion)){
                        return true;
                    }
            }
        return false;
    }     
}
