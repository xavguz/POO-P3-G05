package modelo;

import modelo.Fecha;

public class TomaMedicina {
    private Medicina medicina;
    private Fecha fecha;

    public TomaMedicina(Medicina medicina, Fecha fecha){
        this.medicina = medicina;
        this.fecha = fecha;
    }

    public Medicina getMedicina() {
        return medicina;
    }

    public void setMedicina(Medicina medicina) {
        this.medicina = medicina;
    }

    public Fecha getFecha() {
        return fecha;
    }

    public void setFecha(Fecha fecha) {
        this.fecha = fecha;
    }

    public String toString(){
        return medicina.getNombreMedicamento() + " / " + fecha;
    }

}
