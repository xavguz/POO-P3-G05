package modelo;

public class ActividadFisicaModelo {
    private FechaModelo fecha;
    private String actividad;
    private String duracion;
    private String horario;

    public ActividadFisicaModelo(FechaModelo fecha, String actividad,
                           String duracion, String horario){
        this.fecha = fecha;
        this.actividad = actividad;
        this.duracion = duracion;
        this.horario = horario;
    }

    public ActividadFisicaModelo(){}

    public FechaModelo getFecha() {
        return fecha;
    }

    public void setFecha(FechaModelo fecha) {
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
