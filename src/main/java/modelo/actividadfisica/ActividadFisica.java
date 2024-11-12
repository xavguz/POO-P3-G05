package modelo.actividadfisica;

import modelo.Fecha;
import modelo.actividadfisica.enums.Actividad;
import modelo.actividadfisica.enums.Horario;

public class ActividadFisica {
    private Fecha fecha;
    private Actividad actividad;
    private String duracion;
    private Horario horario;

    public ActividadFisica(Fecha fecha, Actividad actividad,
                           String duracion, Horario horario){
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

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }
}
