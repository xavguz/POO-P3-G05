package modelo;

import modelo.Fecha;

public class ActividadFisica {
    private Fecha fecha;
    private String actividad;
    private String duracion;
    private String horario;

    public ActividadFisica(Fecha fecha, String actividad,
                           String duracion, String horario){
        this.fecha = fecha;
        this.actividad = actividad;
        this.duracion = duracion;
        this.horario = horario;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public String toString(){
        return fecha + " / " + actividad + " / " + duracion;
    }
}
