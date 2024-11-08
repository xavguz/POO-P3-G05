package com.main;

import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Perfil {

    public static ArrayList<Perfil> listaUsuarios = new ArrayList<>();
    private String nombreUsuario;
    private String relacion;
    private String email;

    public Perfil(String nombreUsuario, String relacion, String email){
        this.nombreUsuario = nombreUsuario;
        this.relacion = relacion;
        this.email = email;
        listaUsuarios.add(this);
    }

    public Perfil(String nombreUsuario, String relacion){
        this(nombreUsuario, relacion,null);
        listaUsuarios.add(this);
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

    public static ArrayList<Perfil> getListaUsuarios() {
        return listaUsuarios;
    }

    @Override
    public String toString(){
        return "Nombre de Usuario: " + nombreUsuario + "\n" +
                "Relacion del Usuario: " + relacion + "\n" +
                "Email del Usuario:" + (email.isEmpty()?"No tiene email":email);
    }
}
