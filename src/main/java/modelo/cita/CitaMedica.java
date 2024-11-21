package modelo.cita;

import modelo.Fecha;

public class CitaMedica {
    private String titulo;
    private Fecha fecha;
    private Medico doctor;

    public CitaMedica(String titulo, Fecha fecha, Medico doctor){
        this.titulo = titulo;
        this.fecha = fecha;
        this.doctor = doctor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public Medico getDoctor() {
        return doctor;
    }

    public void setDoctor(Medico doctor) {
        this.doctor = doctor;
    }
    @Override
    public String toString(){
        return titulo + " / " + doctor.getNombre() + " ("+ doctor.getEspecialidades() + ")" + " / " + fecha;
    }
}
