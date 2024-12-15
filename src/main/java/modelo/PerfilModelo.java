package modelo;

import java.util.ArrayList;
import java.util.Objects;


public class PerfilModelo {

    private String nombre;
    private String relacion;
    private String email;
    private ArrayList<MedicinaModelo> medicinas;
    private ArrayList<TomaMedicinaModelo> tomaMedicinas;
    private ArrayList<MedicoModelo> medicos;
    private ArrayList<CitaMedicaModelo> citaMedicas;
    private ArrayList<ActividadFisicaModelo> actividadesFisicas;
    
    public PerfilModelo(String nombre, String relacion, String email){
        this.nombre = nombre;
        this.relacion = relacion;
        this.email = email;
        this.medicinas = new ArrayList<>();
        this.tomaMedicinas = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.citaMedicas = new ArrayList<>();
        this.actividadesFisicas = new ArrayList<>();
    }
    public PerfilModelo(){
        this.medicinas = new ArrayList<>();
        this.tomaMedicinas = new ArrayList<>();
        this.medicos = new ArrayList<>();
        this.citaMedicas = new ArrayList<>();
        this.actividadesFisicas = new ArrayList<>();
    }

    public PerfilModelo(String nombreUsuario, String relacion){
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

    public ArrayList<MedicinaModelo> getMedicinas() {
        return medicinas;
    }

    public ArrayList<MedicoModelo> getMedicos() {
        return medicos;
    }

    public ArrayList<CitaMedicaModelo> getCitaMedicas() {
        return citaMedicas;
    }

    public ArrayList<ActividadFisicaModelo> getActividadesFisicas() {
        return actividadesFisicas;
    }

    public ArrayList<TomaMedicinaModelo> getTomaMedicinas() {
        return tomaMedicinas;
    }

    
    @Override
    public String toString(){
        return nombre + " (" + relacion + ").";
    }

    public boolean equals(Object p) {
        if (p != null && p instanceof PerfilModelo) {
            PerfilModelo perfil = (PerfilModelo) p;
            if (Objects.equals(nombre.toLowerCase(), perfil.nombre.toLowerCase()) &&
                    Objects.equals(relacion, perfil.relacion)){
                        return true;
                    }
            }
        return false;
    }

}
