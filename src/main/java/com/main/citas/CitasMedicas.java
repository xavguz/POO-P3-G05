package com.main.citas;

import com.main.Fecha;

public class CitasMedicas {
    private String titulo;
    private Fecha fecha;
    private Medico doctor;

    public CitasMedicas(String titulo, Fecha fecha, Medico doctor){
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
}
